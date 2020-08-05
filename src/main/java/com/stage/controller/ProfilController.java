package com.stage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stage.addOn.ProfilStats;
import com.stage.entities.DossierCandidature;
import com.stage.entities.ExperienceProfessionnelle;
import com.stage.entities.ExperienceScolaire;
import com.stage.entities.Profil;
import com.stage.repository.ProfilRepository;
import com.stage.services.IProfilService;

@RestController
@CrossOrigin(origins = "anonymous", allowedHeaders = "*")
public class ProfilController {

	@Autowired
	IProfilService profilService;
	@Autowired
	ProfilRepository profilRepository;
 

	@GetMapping("/profil")
	public List<Profil> getAll() {
		return profilService.findAll();
	}

	@GetMapping("/profil/numCorrespondance")
	public Profil getProfil(@RequestParam String numCorrespondance) {
		return profilService.findByNumCorrespondance(numCorrespondance);
	}

	@GetMapping("/profil/experienceProfessionnelle/numCorrespondance")
	public List<ExperienceProfessionnelle> getExperiencesProfessionnelleByProfilNumCorrespondance(
			@RequestParam String numCorrespondance) {
		return profilService.findByNumCorrespondance(numCorrespondance).getExperiencesProfessionnelle();
	}

	@GetMapping("/profil/experienceScolaire/numCorrespondance")
	public List<ExperienceScolaire> getExperiencesScolaireByProfilNumCorrespondance(
			@RequestParam String numCorrespondance) {
		return profilService.findByNumCorrespondance(numCorrespondance).getExperiencesScolaire();
	}

	@GetMapping("/profil/dossierCandidature/numCorrespondance")
	public List<DossierCandidature> getDossierCandidatureByProfilNumCorrespondance(
			@RequestParam String numCorrespondance) {
		return profilService.findByNumCorrespondance(numCorrespondance).getDossierCandidatures();
	}

	@PostMapping("/profil")
	public Profil ajouterProfil(@RequestBody Profil p) {
		return profilService.ajouterProfil(p);
	}

	@PutMapping("/profil")
	public Profil updateProfil(@RequestBody Profil p) {
		return profilService.updateProfil(p);
	}
	
	

	// **************** Methodes De Reporting BI *************************

	@GetMapping("/profil/datedecreation")
	public List<ProfilStats> getCandidaturesParDateDeCandidature() {
		return profilRepository.profilsParDateDeCreation();
	}

}
