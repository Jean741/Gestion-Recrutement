package com.stage.services;

import java.util.List;

import com.stage.dto.ExperienceScolaireDTO;
import com.stage.entities.ExperienceScolaire;

public interface IExperienceScolaireService {

	public List<ExperienceScolaire> findAll();

	public ExperienceScolaire addExperienceScolaire(ExperienceScolaire experienceScolaire);

	public ExperienceScolaire addConpleteExperienceScolaire(ExperienceScolaireDTO dto);

	public ExperienceScolaire updateExperienceScolaire(ExperienceScolaire experienceScolaire);

	public void deleteExperienceScolaire(ExperienceScolaire experienceScolaire);

	public void deleteExperienceScolaire(Long id);
}
