package com.stage.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.stage.enumerations.TypeEntretient;

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
@JsonIgnoreProperties(value = { "candidature", "profil" })
public class Entretient implements Serializable {
	 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	Long id;
	
	@Getter
	@Setter
	TypeEntretient typeEntretient;

	@Getter
	@Setter
	String nomEvaluateur;
	
	@Getter
	@Setter
	String prenomEvaluateur;
	
	@Getter
	@Setter
	String roleEvaluateur;
	
	@Getter
	@Setter
	LocalDate dateEntretient;
	
	@ManyToOne
	@Getter
	@Setter
	Candidature candidature;

	public Entretient(TypeEntretient typeEntretient) {
		super();
		this.typeEntretient = typeEntretient;
		this.dateEntretient= LocalDate.now();
	}
	
}
