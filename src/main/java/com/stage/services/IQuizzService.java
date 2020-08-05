package com.stage.services;

import java.util.List;

import com.stage.dto.QuizzDTO;
import com.stage.entities.CandidatureInQuizz;
import com.stage.entities.Quizz;

public interface IQuizzService {

	public List<Quizz> findAll();

	public Quizz addQuizz(Quizz quizz);

	public Quizz updateQuizz(Quizz quizz);

	public void deleteQuizz(Quizz quizz);

	void deleteQuizz(Long id);

	CandidatureInQuizz addQuizzToCandidature(QuizzDTO dto);

	void removeQuizzFromCandidature(QuizzDTO dto);
}
