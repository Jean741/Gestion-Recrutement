package com.stage.services;

import java.util.List;

import com.stage.entities.EtablissementScolaire;

public interface IEtablissementScolaireService {

	public List<EtablissementScolaire> findAll();
	public EtablissementScolaire addEtablissementScolaire(EtablissementScolaire etablissementScolaire);
	public EtablissementScolaire updateEtablissementScolaire(EtablissementScolaire etablissementScolaire);
	public void deleteEtablissementScolaire(Long id);

}
