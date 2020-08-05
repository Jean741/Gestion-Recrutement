package com.stage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.entities.ExperienceProfessionnelle;

@Repository
public interface ExperienceProfessionnelleRepository extends JpaRepository<ExperienceProfessionnelle, Long> {
	public Optional<ExperienceProfessionnelle> findById(Long id);

}
