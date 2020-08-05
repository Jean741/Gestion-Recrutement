package com.stage.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CandidatureStatusDTO implements Serializable {
 
	private static final long serialVersionUID = 1L;
	public Long id;
	public String numeroStatut;

}
