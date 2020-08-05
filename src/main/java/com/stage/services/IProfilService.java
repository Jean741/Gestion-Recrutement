package com.stage.services;

import java.util.List;

import com.stage.entities.Profil;

public interface IProfilService {

	public List<Profil> findAll();

	public Profil ajouterProfil(Profil p);

	public Profil findByNumCorrespondance(String numCorrespondance);

	public Profil updateProfil(Profil p);

}
