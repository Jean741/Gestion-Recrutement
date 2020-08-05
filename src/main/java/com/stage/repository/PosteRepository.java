package com.stage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.entities.Poste;

@Repository
public interface PosteRepository extends JpaRepository<Poste, Long> {
	public Optional<Poste> findById(Long id);

}
