package com.stage.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stage.dto.QuizzDTO;
import com.stage.entities.CandidatureInQuizz;
import com.stage.entities.Quizz;
import com.stage.repository.CandidatureInQuizzRepository;
import com.stage.repository.CandidatureRepository;
import com.stage.repository.QuizzRepository;
import com.stage.services.IQuizzService;

@Service
public class QuizzImpl implements IQuizzService {

	@Autowired
	QuizzRepository quizzRepository;
	@Autowired
	CandidatureInQuizzRepository candidatureInQuizzRepository;
	@Autowired
	CandidatureRepository candidatureRepository;

	@Override
	public List<Quizz> findAll() {
		return quizzRepository.findAll();
	}

	@Override
	public Quizz addQuizz(Quizz quizz) {
		return quizzRepository.save(quizz);
	}

	@Override
	public Quizz updateQuizz(Quizz quizz) {
		return quizzRepository.saveAndFlush(quizz);
	}

	@Override
	public void deleteQuizz(Quizz quizz) {
		quizzRepository.delete(quizz);
	}

	@Override
	public void deleteQuizz(Long id) {
		quizzRepository.deleteById(id);
	}

	@Override
	public CandidatureInQuizz addQuizzToCandidature(QuizzDTO dto) {
		return candidatureInQuizzRepository.save(new CandidatureInQuizz(quizzRepository.findById(dto.idQuizz).get(),
				candidatureRepository.findById(dto.idCandidature).get()));
	}

	@Override
	public void removeQuizzFromCandidature(QuizzDTO dto) {
		CandidatureInQuizz c = candidatureInQuizzRepository.findByCandidatureAndQuizz(
				candidatureRepository.findById(dto.idCandidature).get(), quizzRepository.findById(dto.idQuizz).get());
		candidatureInQuizzRepository.delete(c);
	}

}
