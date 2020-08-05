package com.stage.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stage.dto.ExperienceProfessionnelleDTO;
import com.stage.entities.ExperienceProfessionnelle;
import com.stage.repository.EntrepriseRepository;
import com.stage.repository.ExperienceProfessionnelleRepository;
import com.stage.repository.PosteRepository;
import com.stage.repository.ProfilRepository;
import com.stage.services.IExperienceProfessionnelleService;

@Service
public class ExperienceProfessionnelleImpl implements IExperienceProfessionnelleService {

	@Autowired
	EntrepriseRepository entrepriseRepository;
	@Autowired
	ExperienceProfessionnelleRepository experienceProfessionnelleRepository;
	@Autowired
	ProfilRepository profilRepository;

	@Autowired
	PosteRepository posteRepository;

	@Override
	public List<ExperienceProfessionnelle> findAll() {
		return experienceProfessionnelleRepository.findAll();
	}

	@Override
	public ExperienceProfessionnelle addExperienceProfessionnelle(ExperienceProfessionnelle experienceProfessionnelle) {
		return null;
	}

	@Override
	public ExperienceProfessionnelle updateExperienceProfessionnelle(
			ExperienceProfessionnelle experienceProfessionnelle) {
		return null;
	}

	@Override
	public ExperienceProfessionnelle addConpleteExperienceProfessionnelle(ExperienceProfessionnelleDTO dto) {
		ExperienceProfessionnelle experience = new ExperienceProfessionnelle(
				profilRepository.findByNumCorrespondance(dto.idProfil),
				entrepriseRepository.findById(dto.idEntreprise).get(), dto.poste, dto.datteEntree, dto.datteSortie);
		return experienceProfessionnelleRepository.save(experience);
	}

	@Override
	public void deleteExperienceProfessionnelle(Long id) {
		experienceProfessionnelleRepository.deleteById(id);
	}

	@Override
	public void deleteExperienceProfessionnelle(ExperienceProfessionnelle experienceProfessionnelle) {

	}

}
