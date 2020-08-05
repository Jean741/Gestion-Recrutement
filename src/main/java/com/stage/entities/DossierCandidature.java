package com.stage.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@JsonIgnoreProperties(value = "profil")
public class DossierCandidature implements Serializable {

	static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	Long id;

	@Getter
	@Setter
	@Column(nullable = false)
	String titre;
	
	@Getter
	@Setter
	LocalDate dateDeCreation;

	@ManyToOne
	@Getter
	@Setter
	Profil profil;

	public DossierCandidature(String titre, Profil profil) {
		super();
		this.titre = titre;
		this.profil = profil;
		this.dateDeCreation = LocalDate.now();
	}

}
