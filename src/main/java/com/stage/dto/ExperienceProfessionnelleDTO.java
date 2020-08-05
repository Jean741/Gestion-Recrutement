package com.stage.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class ExperienceProfessionnelleDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Long idEntreprise;
	public String idProfil;
	public String poste;
	public LocalDate datteEntree;
	public LocalDate datteSortie;
}
