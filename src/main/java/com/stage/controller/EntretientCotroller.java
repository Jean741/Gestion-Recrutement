package com.stage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stage.dto.EntretientDTO;
import com.stage.entities.Candidature;
import com.stage.entities.Entretient;
import com.stage.enumerations.TypeEntretient;
import com.stage.services.ICandidatureService;
import com.stage.services.IEntretientService;

@RestController
@CrossOrigin(origins = "anonymous", allowedHeaders = "*")
public class EntretientCotroller {
	
	@Autowired
	ICandidatureService candidatureService;
	
	@Autowired
	IEntretientService entretientService;
	

	@GetMapping("/entretients")
	public List<Entretient> getAll() {
		return entretientService.findAll();
	}
	
	@PostMapping("/entretients")
	public Entretient createEntretient(@RequestBody EntretientDTO dto) {
		Candidature candidature = candidatureService.findById(dto.idCandidature);
		
		System.out.println(dto.nomCandidat);
		System.out.println(dto.nomEvaluateur);
		switch (dto.typeEntretient) {
		case "9":
			return entretientService.addEntretientToCandidature(candidature,TypeEntretient.Entretien_Dans_La_Societe,dto);
		case "8":
			return entretientService.addEntretientToCandidature(candidature,TypeEntretient.Test_Ecrit,dto);
		default:
			break;
		}
		
		switch (dto.decisionEvaluateur) {
		case "3":
			return entretientService.addEntretientToCandidature(candidature,TypeEntretient.Quizz_En_Ligne,dto);
		default:
			break;
		}
		// to commit
		return null;
	}
	
	@DeleteMapping("/entretients/id")
	public void deleteEntretient(@RequestParam Long id) {
		  entretientService.deleteEntretientById(id);
	}
}
