package com.stage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.entities.Candidature;
import com.stage.entities.CandidatureInQuizz;
import com.stage.entities.Quizz;

@Repository
public interface CandidatureInQuizzRepository extends JpaRepository<CandidatureInQuizz, Long> {
	CandidatureInQuizz findByCandidatureAndQuizz(Candidature candidature,Quizz quizz );

}
