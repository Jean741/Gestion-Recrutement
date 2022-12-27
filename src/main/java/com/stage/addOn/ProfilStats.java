package com.stage.addOn;

import java.time.LocalDate;

import com.stage.enumerations.Statut;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProfilStats {

	Long nbreProfil;
	LocalDate dateDeCreation;
	Statut statut;

	public ProfilStats(Long nbreProfil, Statut statut) {
		super();
		this.nbreProfil = nbreProfil;
		this.statut = statut;
	}

	public ProfilStats(Long nbreCandidature, LocalDate dateDeCreation) {
		super();
		this.nbreProfil = nbreCandidature;
		this.dateDeCreation = dateDeCreation;
	}
}
