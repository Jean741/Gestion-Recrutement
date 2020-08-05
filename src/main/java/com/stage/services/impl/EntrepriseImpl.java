package com.stage.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stage.entities.Entreprise;
import com.stage.repository.EntrepriseRepository;
import com.stage.repository.EtablissementScolaireRepository;
import com.stage.repository.ExperienceProfessionnelleRepository;
import com.stage.repository.PosteRepository;
import com.stage.repository.ProfilRepository;
import com.stage.services.IEntrepriseService;

@Service
public class EntrepriseImpl implements IEntrepriseService {
	@Autowired
	ProfilRepository profilRepository;
	
	@Autowired
	ExperienceProfessionnelleRepository experienceProfessionnelleRepository;
	
	@Autowired
	EntrepriseRepository entrepriseRepository;
	@Autowired
	PosteRepository posteRepository;
	
	@Autowired
	EtablissementScolaireRepository etablissementScolaireRepository;
	
	@Override
	public List<Entreprise> findAll() {
		return entrepriseRepository.findAll(Sort.by(Sort.Direction.ASC, "nomEntreprise"));
	}
	
	@Override
	public Entreprise addEntreprise(Entreprise entreprise) {
		return entrepriseRepository.save(entreprise);
	}
	@Override
	public Entreprise updateEntreprise(Entreprise entreprise) {
		return entrepriseRepository.saveAndFlush(entreprise);
	}
	@Override
	public Entreprise deleteEntreprise(Entreprise entreprise) {
		return null;
	}
	 

 
	
	
	
	 
}
