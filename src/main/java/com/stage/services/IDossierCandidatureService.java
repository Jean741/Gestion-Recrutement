package com.stage.services;

import java.util.List;

import com.stage.dto.DossierCandidatureDTO;
import com.stage.entities.DossierCandidature;

public interface IDossierCandidatureService {
	public List<DossierCandidature> findAll();
	public DossierCandidature addDossierCandidature(DossierCandidatureDTO dto);
	public DossierCandidature updateDossierCandidature(DossierCandidature dossierCandidature);
	public DossierCandidature deleteDossierCandidature(DossierCandidature dossierCandidature);

}
