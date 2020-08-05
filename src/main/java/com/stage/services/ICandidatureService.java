package com.stage.services;

import java.util.List;

import com.stage.entities.Candidature;
import com.stage.enumerations.Statut;

public interface ICandidatureService {
	public List<Candidature> findAll();

	public Candidature findById(Long id);

	public Candidature addCandidature(Candidature candidature);
	
	public Candidature addCandidature(String numCorrespondance);

	public Candidature updateCandidature(Candidature candidature);
	
	public Candidature updateCandidatureStatus(Candidature candidature,Statut statut);

	public  void deleteCandidature(Candidature candidature);
	
	public Candidature findByProfilAndCourante(String numCorrespondance);
}