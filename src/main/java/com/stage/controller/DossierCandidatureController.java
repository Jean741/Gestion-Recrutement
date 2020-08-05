package com.stage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stage.dto.DossierCandidatureDTO;
import com.stage.entities.DossierCandidature;
import com.stage.services.IDossierCandidatureService;
import com.stage.services.IProfilService;

@RestController
@CrossOrigin(origins = "anonymous", allowedHeaders = "*")
public class DossierCandidatureController {

	@Autowired
	IDossierCandidatureService dossierCandidatureService;
	@Autowired
	IProfilService profilService;

	@GetMapping("/dossierCandidature")
	public List<DossierCandidature> getAll() {
		return dossierCandidatureService.findAll();
	}

	/*
	 * @GetMapping("/dossierCandidature/id") public Profil getProfil(@RequestParam
	 * String numCorrespondance) { return
	 * dossierCandidatureService.findByNumCorrespondance(numCorrespondance); }
	 */

	@PostMapping("/dossierCandidature")
	public DossierCandidature addDossierCandidature(@RequestBody DossierCandidatureDTO dossierCandidatureDTO) {
		return dossierCandidatureService.addDossierCandidature(dossierCandidatureDTO);
	}

	/*
	 * @PutMapping("/dossierCandidature") public Profil
	 * updateDossierCandidature(@RequestBody Profil p) { return
	 * profilService.updateProfil(p); }
	 */

}
