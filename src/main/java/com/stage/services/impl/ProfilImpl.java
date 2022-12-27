package com.stage.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stage.entities.Profil;
import com.stage.repository.EntrepriseRepository;
import com.stage.repository.ExperienceProfessionnelleRepository;
import com.stage.repository.PosteRepository;
import com.stage.repository.ProfilRepository;
import com.stage.services.IProfilService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
//@AllArgsConstructor
//@NoArgsConstructor
public class ProfilImpl implements IProfilService {
	@Autowired
	ProfilRepository profilRepository;

	@Autowired
	ExperienceProfessionnelleRepository experienceProfessionnelleRepository;

	@Autowired
	EntrepriseRepository entrepriseRepository;
	@Autowired
	PosteRepository posteRepository;

	public Profil ajouterProfil(Profil p) {
		p.setDateDeCreation(LocalDate.now());
		return profilRepository.save(p);
	}

	@Override
	public Profil findByNumCorrespondance(String numCorrespondance) {
		return profilRepository.findByNumCorrespondance(numCorrespondance);
	}

	@Override
	public Profil updateProfil(Profil p) {
		Profil profil = profilRepository.findByNumCorrespondance(p.getNumCorrespondance());
		profil.setCompetenceDeux(p.getCompetenceDeux());
		;
		profil.setNumCorrespondance(p.getNumCorrespondance());
		profil.setCompetenceUne(p.getCompetenceUne());
		profil.setCompetenceTrois(p.getCompetenceTrois());
		profil.setSource(p.getSource());
		profil.setLienAutre(p.getLienAutre());
		profil.setLienLinkedIn(p.getLienLinkedIn());
		return profilRepository.saveAndFlush(profil);
	}

	@Override
	public List<Profil> findAll() {
		return profilRepository.findAll();
	}

}
