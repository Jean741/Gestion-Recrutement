package com.stage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.entities.ExperienceScolaire;

@Repository
public interface ExperienceScolaireRepository extends JpaRepository<ExperienceScolaire, Long> {
	public Optional<ExperienceScolaire> findById(Long id);

}
