package com.stage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.entities.Offre;

@Repository
public interface OffreRepository extends JpaRepository<Offre, Long> {

}
