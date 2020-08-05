package com.stage.entities;

import java.io.Serializable;

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
@JsonIgnoreProperties(value = { "profil" })
public class ExperienceScolaire implements Serializable {

	static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	Long id;

	@ManyToOne
	@Getter
	@Setter
	EtablissementScolaire etablissementScolaire;

	@Getter
	@Setter
	String diplome;
	
	@Column(nullable = false)
	@Getter
	@Setter
	String anneDeDiplome;

	@ManyToOne
	@Getter
	@Setter
	Profil profil;
	

	public ExperienceScolaire(Profil profil,EtablissementScolaire etablissementScolaire, String anneDeDiplome,String diplome) {
		super();
		this.profil = profil;
		this.etablissementScolaire = etablissementScolaire;
		this.anneDeDiplome = anneDeDiplome;
		this.diplome =diplome;
	}

}
