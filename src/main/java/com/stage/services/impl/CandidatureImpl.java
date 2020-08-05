package com.stage.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stage.entities.Candidature;
import com.stage.enumerations.Statut;
import com.stage.repository.CandidatureRepository;
import com.stage.repository.ProfilRepository;
import com.stage.services.ICandidatureService;

@Service
public class CandidatureImpl implements ICandidatureService {

	@Autowired
	CandidatureRepository candidatureRepository;
	@Autowired
	ProfilRepository proilRepository;

	@Override
	public List<Candidature> findAll() {
		return candidatureRepository.findAll();
	}
	
	@Override
	public Candidature findById(Long id) {
		return candidatureRepository.findById(id).get();
	}

	@Override
	public Candidature addCandidature(Candidature candidature) {
		return candidatureRepository.save(candidature);
	}

	@Override
	public Candidature addCandidature(String numCorrespondance) {
		return candidatureRepository.save(new Candidature(proilRepository.findByNumCorrespondance(numCorrespondance)));
	}

	@Override
	public Candidature updateCandidatureStatus(Candidature candidature, Statut statut) {
		candidature.setStatut(statut);
		return candidatureRepository.saveAndFlush(candidature);
	}

	@Override
	public Candidature updateCandidature(Candidature candidature) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCandidature(Candidature candidature) {
		// TODO Auto-generated method stub

	}

	@Override
	public Candidature findByProfilAndCourante(String numCorrespondance) {

		return candidatureRepository.findByProfilAndCourante(proilRepository.findByNumCorrespondance(numCorrespondance),
				true);
	}

	

}
