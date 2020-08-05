package com.stage.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity
@JsonIgnoreProperties(value = { "etablissementScolaires", "profil" })
public class ExperienceProfessionnelle implements Serializable {

	static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	Long id;
	
	@Getter
	@Setter
	LocalDate datteEntree;

	@Getter
	@Setter
	LocalDate datteSortie;

	@ManyToOne(fetch = FetchType.EAGER)
	@Getter
	@Setter
	Entreprise entreprise;

	
	@Getter
	@Setter
	String poste;

	@ManyToOne
	@Getter
	@Setter
	Profil profil;
	
	public ExperienceProfessionnelle(Profil profil,Entreprise entreprise, String poste,LocalDate datteEntree,LocalDate datteSortie) {
		super();
		this.profil = profil;
		this.entreprise = entreprise;
		this.poste = poste;
		this.datteEntree = datteEntree;
		this.datteSortie = datteSortie;
	}

}
