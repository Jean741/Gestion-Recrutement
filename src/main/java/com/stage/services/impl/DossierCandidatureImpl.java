package com.stage.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stage.dto.DossierCandidatureDTO;
import com.stage.entities.DossierCandidature;
import com.stage.repository.DossierCandidatureRepository;
import com.stage.repository.ProfilRepository;
import com.stage.services.IDossierCandidatureService;

@Service
public class DossierCandidatureImpl implements IDossierCandidatureService {

	@Autowired
	DossierCandidatureRepository dossierCandidatureRepository;
	@Autowired
	ProfilRepository profilRepository;

	@Override
	public List<DossierCandidature> findAll() {
		return dossierCandidatureRepository.findAll();
	}

	@Override
	public DossierCandidature addDossierCandidature(DossierCandidatureDTO dto) {
		
		DossierCandidature dossier = new DossierCandidature(dto.titre,
				profilRepository.findByNumCorrespondance(dto.numCorrespondance));
		
		if (dossierCandidatureRepository.findByProfilAndTitre(profilRepository.findByNumCorrespondance(dto.numCorrespondance),
				dto.titre) == null) {
			return dossierCandidatureRepository.save(dossier);
		}else {
			return dossierCandidatureRepository.findByProfilAndTitre(profilRepository.findByNumCorrespondance(dto.numCorrespondance),
					dto.titre);
		}
	}

	@Override
	public DossierCandidature updateDossierCandidature(DossierCandidature dossierCandidature) {
		return dossierCandidatureRepository.saveAndFlush(dossierCandidature);
	}

	@Override
	public DossierCandidature deleteDossierCandidature(DossierCandidature dossierCandidature) {
		return null;
	}

}
