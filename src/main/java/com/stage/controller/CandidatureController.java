package com.stage.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stage.addOn.CandidatureStats;
import com.stage.dto.CandidatureDTO;
import com.stage.dto.CandidatureStatusDTO;
import com.stage.entities.Candidature;
import com.stage.enumerations.Statut;
import com.stage.repository.CandidatureRepository;
import com.stage.services.ICandidatureService;

@RestController
@CrossOrigin(origins = "anonymous", allowedHeaders = "*")
public class CandidatureController {

	@Autowired
	CandidatureRepository candidatureRepository;
	@Autowired
	ICandidatureService candidatureService;
	
	// **************** Methodes CRUD *************************

	@GetMapping("/candidatures")
	public List<Candidature> getAll() {
		return candidatureService.findAll();
	}
	
	@GetMapping("/candidatures/id")
	public Candidature getOneById(@RequestParam Long id) {
		return candidatureService.findById(id);
	}
	
	@GetMapping("/candidatures/numCorrespondance")
	public Candidature getCouranteCandidatureParNumeroCorespondance(@RequestParam String numCorrespondance) {
		return candidatureService.findByProfilAndCourante(numCorrespondance);
	}
	
	@PostMapping("/candidatures")
	public Candidature createCandidature(@RequestBody CandidatureDTO dto) {
		return candidatureService.addCandidature(dto.numCorrespondance);
	}
	
	@PutMapping("/candidatures/setToAccepte")
	public Candidature updateCandidatureAccepte(@RequestParam Long id) {
		Candidature candidature =candidatureRepository.findById(id).get();
		candidature.setDateAcceptation(LocalDate.now());
		return candidatureService.updateCandidatureStatus(candidature,Statut.Accepté);
	}
	
	@PutMapping("/candidatures/setToConfirmationCandidat")
	public Candidature updateCandidatureConfirmationCandidat(@RequestParam Long id) {
		Candidature candidature =candidatureRepository.findById(id).get();
		candidature.setDateConfirmationCandidat(LocalDate.now());
		return candidatureService.updateCandidatureStatus(candidature,Statut.Confirmation_du_candidat);
	}
	
	@PutMapping("/candidatures/setToNiveauEntretient")
	public Candidature updateCandidatureNiveauEntretient(@RequestParam Long id) {
		Candidature candidature =candidatureRepository.findById(id).get();
		candidature.setDateNiveauEntretient(LocalDate.now());
		return candidatureService.updateCandidatureStatus(candidature,Statut.Niveau_Entretient);
	}
	
	@PutMapping("/candidatures/setToNiveauEvaluateur")
	public Candidature updateCandidatureNiveauEvaluateur(@RequestParam Long id) {
		Candidature candidature =candidatureRepository.findById(id).get();
		candidature.setDateNiveauEvaluateur(LocalDate.now());
		return candidatureService.updateCandidatureStatus(candidature,Statut.Niveau_Evaluateur);
	}
	
	@PutMapping("/candidatures/setToQuizz")
	public Candidature updateCandidatureQuizz(@RequestParam Long id) {
		Candidature candidature =candidatureRepository.findById(id).get();
		candidature.setDateNiveauQuizz(LocalDate.now());
		return candidatureService.updateCandidatureStatus(candidature,Statut.Quizz);
	}
	
	@PutMapping("/candidatures/changeStatus")
	public Candidature updateCandidatureStatus(@RequestBody CandidatureStatusDTO dto) {
		Candidature candidature =candidatureRepository.findById(dto.id).get();		
		switch (dto.numeroStatut) {
		case "1":
			candidature.setDateRefus(LocalDate.now());
			return candidatureService.updateCandidatureStatus(candidature,Statut.Refusé);
		case "4":
			candidature.setDateAcceptation(LocalDate.now());
			return candidatureService.updateCandidatureStatus(candidature,Statut.Accepté);
		case "5":
			candidature.setDateNiveauEntretient(LocalDate.now());
			return candidatureService.updateCandidatureStatus(candidature,Statut.Niveau_Entretient);
		case "3":
			candidature.setDateNiveauQuizz(LocalDate.now());
			return candidatureService.updateCandidatureStatus(candidature,Statut.Quizz);
		case "10":
			candidature.setDateConfirmationCandidat(LocalDate.now());
			return candidatureService.updateCandidatureStatus(candidature,Statut.Confirmation_du_candidat);
		case "11":
			candidature.setDateNiveauEvaluateur(LocalDate.now());
			return candidatureService.updateCandidatureStatus(candidature,Statut.Niveau_Evaluateur);
		default:
			break;
		}
		return candidature;
	}
	
	/*
	@GetMapping("/profil/experienceProfessionnelle/numCorrespondance")
	public List<ProfilInExperienceProfessionnelle> getExperiencesProfessionnelleByProfilNumCorrespondance(
			@RequestParam String numCorrespondance) {
		return profilService.findByNumCorrespondance(numCorrespondance).getExperiencesProfessionnelle();
	}*/
	
	// **************** Methodes De Reporting BI *************************
	
	@GetMapping("/candidatures/statut")
	public List<CandidatureStats> getCandidaturesParStatut() {
		return candidatureRepository.nombreDeCandidaturesParStatut();
	}
	
	@GetMapping("/candidatures/datedecandidature")
	public List<CandidatureStats> getCandidaturesParDateDeCandidature() {
		return candidatureRepository.nombreDeCandidaturesParDateDeCandidature();
	}
	
	@GetMapping("/candidatures/datedecandidatureAnne")
	public List<CandidatureStats> getcandidaturesParDateDeCandidatureEntreAnne(@RequestParam String dateDebut,
			@RequestParam String dateFin) {
		return candidatureRepository.candidaturesParDateDeCandidatureEntreAnne(dateDebut,dateFin);
	}
	
	@GetMapping("/candidatures/datedecandidatureMois")
	public List<CandidatureStats> getcandidaturesParDateDeCandidatureEntreMois(@RequestParam String dateDebut,
			@RequestParam String dateFin) {
		return candidatureRepository.candidaturesParDateDeCandidatureEntreMois(dateDebut,dateFin);
	}
	
	
	@GetMapping("/candidatures/nombreAnddatedecandidatureParIntervalle")
	public List<CandidatureStats> getNombreCandidaturesParDateDeCandidatureEntre(@RequestParam String dateDebut,
			@RequestParam String dateFin) {
		dateDebut=dateDebut+"-01";
		dateFin=dateFin+"-01";
		return candidatureRepository.nombreDeCandidaturesParDateDeCandidatureEntre(LocalDate.parse(dateDebut),LocalDate.parse(dateFin));
	}
	
	@GetMapping("/candidatures/dateDeCandidatureParIntervalle")
	public List<Candidature> getCandidaturesParDateDeCandidatureEntre(@RequestParam String dateDebut,
			@RequestParam String dateFin) {
		dateDebut=dateDebut+"-01";
		dateFin=dateFin+"-01";
		return candidatureRepository.candidaturesParDateDeCandidatureEntre(LocalDate.parse(dateDebut),LocalDate.parse(dateFin));
	}

	
}
