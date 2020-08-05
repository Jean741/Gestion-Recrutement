package com.stage.entities;

import java.io.Serializable;

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
@JsonIgnoreProperties(value = { "candidature", "profil" })
public class CandidatureInQuizz implements Serializable {

	static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	Long id;

	@ManyToOne
	@Getter
	@Setter
	Quizz quizz;

	@ManyToOne
	@Getter
	@Setter
	Candidature candidature;

	public CandidatureInQuizz(Quizz quizz, Candidature candidature) {
		super();
		this.quizz = quizz;
		this.candidature = candidature;
	}

}
