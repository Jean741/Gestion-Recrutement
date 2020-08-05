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

import com.stage.dto.ExperienceProfessionnelleDTO;
import com.stage.entities.ExperienceProfessionnelle;
import com.stage.services.IEntrepriseService;
import com.stage.services.IExperienceProfessionnelleService;
import com.stage.services.IProfilService;

@RestController
@CrossOrigin(origins = "anonymous", allowedHeaders = "*")
public class ExperienceProfessionnelleController {
 
	@Autowired
	IEntrepriseService entrepriseService;
	@Autowired
	IExperienceProfessionnelleService experienceProfessionnelleService;
	@Autowired
	IProfilService profilService;
	
	@GetMapping("/experienceProfessionnelle")
	public List<ExperienceProfessionnelle> getAll() {
		return experienceProfessionnelleService.findAll();
	}
		

	/*@GetMapping("/experienceProfessionnelle/id")
	public Profil getProfil(@RequestParam String numCorrespondance) {
		return profilService.findByNumCorrespondance(numCorrespondance);
	}
	 */
	
	
	@PostMapping("/experienceProfessionnelle")
	public ExperienceProfessionnelle addConpleteExperienceProfessionnelle(@RequestBody ExperienceProfessionnelleDTO experienceProfessionnelleDTO) {
		return experienceProfessionnelleService.addConpleteExperienceProfessionnelle(experienceProfessionnelleDTO);
	}
	
	/*
	@PutMapping("/experienceProfessionnelle")
	public Profil updateProfil(@RequestBody Profil p) {
		return profilService.updateProfil(p);
	}
	*/
	
	@DeleteMapping("/experienceProfessionnelle/id")
	public void deleteExperiencesProfessionnelle(
			@RequestParam Long id) {
		experienceProfessionnelleService.deleteExperienceProfessionnelle(id);
	}
}
