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

import com.stage.dto.ExperienceScolaireDTO;
import com.stage.entities.ExperienceScolaire;
import com.stage.repository.ExperienceScolaireRepository;
import com.stage.services.IEtablissementScolaireService;
import com.stage.services.IExperienceScolaireService;
import com.stage.services.IProfilService;

@RestController
@CrossOrigin(origins = "anonymous", allowedHeaders = "*")
public class ExperienceScolaireController {
  
	@Autowired
	IEtablissementScolaireService etablissementScolaireService;
	@Autowired
	IExperienceScolaireService experienceScolaireService;
	@Autowired
	IProfilService profilService;
	@Autowired
	ExperienceScolaireRepository experienceScolaireRepository;
	
	@GetMapping("/experienceScolaire")
	public List<ExperienceScolaire>getAll() {
		return experienceScolaireService.findAll();
	}
	
	
	/*@GetMapping("/experienceScolaire/id")
	public Profil getProfil(@RequestParam String numCorrespondance) {
		return profilService.findByNumCorrespondance(numCorrespondance);
	}
	 */
	
	
	@PostMapping("/experienceScolaire")
	public ExperienceScolaire addEtablissement(@RequestBody ExperienceScolaireDTO experienceScolaireDTO) {
		return experienceScolaireService.addConpleteExperienceScolaire(experienceScolaireDTO);
	}
	
	/*
	@PutMapping("/Etablissements")
	public Profil updateProfil(@RequestBody Profil p) {
		return profilService.updateProfil(p);
	}
	*/
	@DeleteMapping("/experienceScolaire/id")
	public void deleteExperiencesScolaire(
			@RequestParam Long id) {
		 experienceScolaireService.deleteExperienceScolaire(id);
	}

}
