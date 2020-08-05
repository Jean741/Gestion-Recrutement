package com.stage.services;

import java.util.List;

import com.stage.entities.Entreprise;

public interface IEntrepriseService {

	public List<Entreprise> findAll();
	public Entreprise addEntreprise(Entreprise entreprise);
	public Entreprise updateEntreprise(Entreprise entreprise);
	public Entreprise deleteEntreprise(Entreprise entreprise);

}
