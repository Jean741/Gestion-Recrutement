package com.stage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.entities.EtablissementScolaire;

@Repository
public interface EtablissementScolaireRepository extends JpaRepository<EtablissementScolaire, Long> {
	public Optional<EtablissementScolaire> findById(Long id);

}
