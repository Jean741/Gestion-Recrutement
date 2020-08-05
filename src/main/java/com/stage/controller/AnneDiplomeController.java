package com.stage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stage.entities.AnneDiplomesAcceptes;
import com.stage.repository.AnneDiplomesAcceptesRepository;

@RestController
@CrossOrigin(origins = "anonymous", allowedHeaders = "*")
public class AnneDiplomeController {

	@Autowired
	AnneDiplomesAcceptesRepository anneDiplomesAcceptesRepository;

	@GetMapping("/anne")
	public List<AnneDiplomesAcceptes> getAll() {
		return anneDiplomesAcceptesRepository.findAll();
	}

}
