package com.stage.services;

import java.util.List;

import com.stage.dto.EntretientDTO;
import com.stage.entities.Candidature;
import com.stage.entities.Entretient;
import com.stage.enumerations.TypeEntretient;

public interface IEntretientService {
	public List<Entretient> findAll();

	Entretient findById(Long id);

	Entretient addEntretient(Entretient entretient);

	Entretient addEntretient(TypeEntretient typeEntretient);
	
	Entretient addEntretientToCandidature(Candidature candidature, TypeEntretient typeEntretient,EntretientDTO dto);

	Entretient updateEntretient(Entretient entretient);

	void deleteEntretient(Entretient entretient);
	void deleteEntretientById(Long id);

}