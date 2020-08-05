package com.stage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.entities.DecisionEvaluateur;

@Repository
public interface DecisionEvaluateurRepository extends JpaRepository<DecisionEvaluateur, Long> {

}
