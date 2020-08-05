package com.stage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.entities.Quizz;

@Repository
public interface QuizzRepository extends JpaRepository<Quizz, Long> {

}
