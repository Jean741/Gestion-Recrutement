package com.stage.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
@JsonIgnoreProperties(value = { "profils","candidatures" })
public class Quizz implements Serializable {

	static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	Long id;
	@Getter
	@Setter
	String titre;

	@OneToMany(mappedBy = "quizz", fetch = FetchType.LAZY)
	@Getter
	@Setter
	List<CandidatureInQuizz> candidatures;

	public Quizz(String titre) {
		super();
		this.titre = titre;
	}

}
