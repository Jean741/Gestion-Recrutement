package com.stage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.entities.Entreprise;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {

}
