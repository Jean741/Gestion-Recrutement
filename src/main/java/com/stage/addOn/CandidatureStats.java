package com.stage.addOn;

import java.time.LocalDate;

import com.stage.enumerations.Statut;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CandidatureStats {

	Long nbreCandidature;
	LocalDate dateDeCandidature;
	Statut statut;
	String anne;

	public CandidatureStats(Long nbreCandidature, Statut statut) {
		super();
		this.nbreCandidature = nbreCandidature;
		this.statut = statut;
	}

	public CandidatureStats(Long nbreCandidature, LocalDate dateDeCandidature) {
		super();
		this.nbreCandidature = nbreCandidature;
		this.dateDeCandidature = dateDeCandidature;
	}

	public CandidatureStats(Long nbreCandidature, String anne) {
		super();
		this.nbreCandidature = nbreCandidature;
		this.anne = anne;
	}
}
