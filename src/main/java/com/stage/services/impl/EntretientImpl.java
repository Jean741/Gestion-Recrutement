package com.stage.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stage.dto.EntretientDTO;
import com.stage.entities.Candidature;
import com.stage.entities.Entretient;
import com.stage.enumerations.TypeEntretient;
import com.stage.repository.EntretientRepository;
import com.stage.services.IEntretientService;

@Service
public class EntretientImpl implements IEntretientService {
	
	@Autowired
	EntretientRepository entretientRepository;

	@Override
	public List<Entretient> findAll() {
		return entretientRepository.findAll();
	}

	@Override
	public Entretient findById(Long id) {
		return entretientRepository.findById(id).get();
	}

	@Override
	public Entretient addEntretient(Entretient entretient) {
		return null;
	}

	@Override
	public Entretient addEntretient(TypeEntretient typeEntretient) {
		return null;
	}

	@Override
	public Entretient updateEntretient(Entretient entretient) {
		return null;
	}

	@Override
	public void deleteEntretient(Entretient entretient) {
		
	}

	@Override
	public Entretient addEntretientToCandidature(Candidature candidature, TypeEntretient typeEntretient,EntretientDTO dto) {
		Entretient entretient = new Entretient(typeEntretient);
		entretient.setCandidature(candidature);
		entretient.setNomEvaluateur(dto.nomEvaluateur);
		entretient.setPrenomEvaluateur(dto.prenomEvaluateur);
		entretient.setRoleEvaluateur(dto.roleEvaluateur);
		return entretientRepository.save(entretient);
	}

	@Override
	public void deleteEntretientById(Long id) {
		entretientRepository.deleteById(id);
	}

}
