package com.stage.dto;

import java.io.Serializable;

public class ExperienceScolaireDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Long idEcole;
	public String idProfil;
	public String anneDeDiplome;
	public String diplome;

	public ExperienceScolaireDTO() {
		super();
	}

	public ExperienceScolaireDTO(Long idEcole, String idProfil, String anneDeDiplome, String diplome) {
		super();
		this.idEcole = idEcole;
		this.idProfil = idProfil;
		this.anneDeDiplome = anneDeDiplome;
		this.diplome = diplome;
	}

}
