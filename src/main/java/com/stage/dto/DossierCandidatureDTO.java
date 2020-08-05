package com.stage.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class DossierCandidatureDTO implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	public String titre;
	public String numCorrespondance;
}
