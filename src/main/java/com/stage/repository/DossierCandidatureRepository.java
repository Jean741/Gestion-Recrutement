package com.stage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.entities.DossierCandidature;
import com.stage.entities.Profil;

@Repository
public interface DossierCandidatureRepository extends JpaRepository<DossierCandidature, Long> {
	public List<DossierCandidature> findByProfil(Profil profil);
	public DossierCandidature findByProfilAndTitre(Profil profil,String titre);
	
}
