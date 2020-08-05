package com.stage.services;

import java.util.List;

import com.stage.dto.ExperienceProfessionnelleDTO;
import com.stage.entities.ExperienceProfessionnelle;

public interface IExperienceProfessionnelleService {

	public List<ExperienceProfessionnelle> findAll();

	public ExperienceProfessionnelle addExperienceProfessionnelle(ExperienceProfessionnelle experienceProfessionnelle);

	public ExperienceProfessionnelle updateExperienceProfessionnelle(
			ExperienceProfessionnelle experienceProfessionnelle);

	public void deleteExperienceProfessionnelle(ExperienceProfessionnelle experienceProfessionnelle);

	public void deleteExperienceProfessionnelle(Long id);

	public ExperienceProfessionnelle addConpleteExperienceProfessionnelle(ExperienceProfessionnelleDTO dto);

}
