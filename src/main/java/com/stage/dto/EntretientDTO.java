package com.stage.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class EntretientDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Long idCandidature;
	public String typeEntretient;
	public String decisionEvaluateur;
	public String nomEvaluateur;
	public String prenomEvaluateur;
	public String roleEvaluateur;
	public String nomCandidat;
	public String prenomCandidat;

}
