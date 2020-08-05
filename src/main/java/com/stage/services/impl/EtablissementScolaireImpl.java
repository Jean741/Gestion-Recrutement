package com.stage.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stage.entities.EtablissementScolaire;
import com.stage.repository.EntrepriseRepository;
import com.stage.repository.EtablissementScolaireRepository;
import com.stage.repository.PosteRepository;
import com.stage.repository.ProfilRepository;
import com.stage.services.IEtablissementScolaireService;

@Service
public class EtablissementScolaireImpl implements IEtablissementScolaireService {
	@Autowired
	ProfilRepository profilRepository;
	
	 
	
	@Autowired
	EntrepriseRepository entrepriseRepository;
	@Autowired
	PosteRepository posteRepository;
	
	@Autowired
	EtablissementScolaireRepository etablissementScolaireRepository;
	
	@Override
	public List<EtablissementScolaire> findAll() {
		return etablissementScolaireRepository.findAll(Sort.by(Sort.Direction.ASC, "nomEtablissement"));
	}
	@Override
	public EtablissementScolaire addEtablissementScolaire(EtablissementScolaire etablissementScolaire) {
		return etablissementScolaireRepository.save(etablissementScolaire);
	}
	@Override
	public EtablissementScolaire updateEtablissementScolaire(EtablissementScolaire etablissementScolaire) {
		return etablissementScolaireRepository.saveAndFlush(etablissementScolaire);
	}
	@Override
	public void deleteEtablissementScolaire(Long id) {
		
	}

	
	
	
 
	
	
	
	 
}
