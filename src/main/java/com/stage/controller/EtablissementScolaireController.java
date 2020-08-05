package com.stage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stage.entities.EtablissementScolaire;
import com.stage.services.IEtablissementScolaireService;
import com.stage.services.IProfilService;

@RestController
@CrossOrigin(origins = "anonymous", allowedHeaders = "*")
public class EtablissementScolaireController {
 
	@Autowired
	IEtablissementScolaireService etablissementScolaireService;
	@Autowired
	IProfilService profilService;
	@Autowired
	
	@GetMapping("/etablissements")
	public List<EtablissementScolaire>getAll() {
		return etablissementScolaireService.findAll();
	}
	
	
	/*@GetMapping("/Etablissements/id")
	public Profil getProfil(@RequestParam String numCorrespondance) {
		return profilService.findByNumCorrespondance(numCorrespondance);
	}
	 */
	
	
	@PostMapping("/etablissements")
	public EtablissementScolaire addEtablissement(@RequestBody EtablissementScolaire etablissementScolaire) {
		return etablissementScolaireService.addEtablissementScolaire(etablissementScolaire);
	}
	
	/*
	@PutMapping("/Etablissements")
	public Profil updateProfil(@RequestBody Profil p) {
		return profilService.updateProfil(p);
	}
	*/

}
