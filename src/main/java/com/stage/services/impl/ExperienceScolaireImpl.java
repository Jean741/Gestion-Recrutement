package com.stage.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stage.dto.ExperienceScolaireDTO;
import com.stage.entities.ExperienceScolaire;
import com.stage.repository.EtablissementScolaireRepository;
import com.stage.repository.ExperienceScolaireRepository;
import com.stage.repository.ProfilRepository;
import com.stage.services.IExperienceScolaireService;

@Service
public class ExperienceScolaireImpl implements IExperienceScolaireService {

	@Autowired
	EtablissementScolaireRepository etablissementScolaireRepository;
	@Autowired
	ExperienceScolaireRepository experienceScolaireRepository;
	@Autowired
	ProfilRepository profilRepository;

	@Override
	public List<ExperienceScolaire> findAll() {
		return experienceScolaireRepository.findAll();
	}

	@Override
	public ExperienceScolaire addExperienceScolaire(ExperienceScolaire experienceScolaire) {
		return experienceScolaireRepository.save(experienceScolaire);
	}

	@Override
	public ExperienceScolaire updateExperienceScolaire(ExperienceScolaire experienceScolaire) {
		return null;
	}

	@Override
	public ExperienceScolaire addConpleteExperienceScolaire(ExperienceScolaireDTO dto) {

		ExperienceScolaire experience = new ExperienceScolaire(profilRepository.findByNumCorrespondance(dto.idProfil),
				etablissementScolaireRepository.findById(dto.idEcole).get(), dto.anneDeDiplome, dto.diplome);
		return experienceScolaireRepository.save(experience);
	}

	@Override
	public void deleteExperienceScolaire(Long id) {
		experienceScolaireRepository.deleteById(id);
	}

	@Override
	public void deleteExperienceScolaire(ExperienceScolaire experienceScolaire) {

	}

}
