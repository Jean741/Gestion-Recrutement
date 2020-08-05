package com.stage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stage.entities.Entreprise;
import com.stage.services.IEntrepriseService;
import com.stage.services.IProfilService;

@RestController
@CrossOrigin(origins = "anonymous", allowedHeaders = "*")
public class EntrepriseController {
 
	@Autowired
	IEntrepriseService entrepriseService;
	@Autowired
	IProfilService profilService;
	@Autowired
	 
	
	@GetMapping("/entreprise")
	public List<Entreprise>getAll() {
		return entrepriseService.findAll();
	}
	
	
	/*@GetMapping("/entreprise/id")
	public Profil getProfil(@RequestParam String numCorrespondance) {
		return profilService.findByNumCorrespondance(numCorrespondance);
	}
	 */
	
	
	@PostMapping("/entreprise")
	public Entreprise addEtablissement(@RequestBody Entreprise entreprise) {
		return entrepriseService.addEntreprise(entreprise);
	}
	
	/*
	@PutMapping("/entreprise")
	public Profil updateProfil(@RequestBody Profil p) {
		return profilService.updateProfil(p);
	}
	*/

}
