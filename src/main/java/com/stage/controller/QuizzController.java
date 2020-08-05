package com.stage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stage.dto.QuizzDTO;
import com.stage.entities.CandidatureInQuizz;
import com.stage.entities.Quizz;
import com.stage.services.IQuizzService;

@RestController
@CrossOrigin(origins = "anonymous", allowedHeaders = "*")
public class QuizzController {

	@Autowired
	IQuizzService quizzService;

	@GetMapping("/quizz")
	public List<Quizz> getAll() {
		return quizzService.findAll();
	}

	@PostMapping("/quizz/addToCandidature")
	public CandidatureInQuizz addQuizzToCandidature(@RequestBody QuizzDTO dto) {
		return quizzService.addQuizzToCandidature(dto);
	}

	@DeleteMapping("/quizz/removeFromCandidature")
	public void removeQuizzToCandidature(@RequestBody QuizzDTO dto) {
		quizzService.removeQuizzFromCandidature(dto);
	}

}
