package com.stage.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.stage.enumerations.Statut;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity
@JsonIgnoreProperties(value = { "profil" })
public class Candidature implements Serializable {

	static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	Long id;

	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	Statut statut;

	@Getter
	@Setter
	LocalDate dateDeCandidature;
	
	@Getter
	@Setter
	LocalDate dateAcceptation;
	
	@Getter
	@Setter
	LocalDate dateConfirmationCandidat;
	
	@Getter
	@Setter
	LocalDate dateNiveauEntretient;
	
	@Getter
	@Setter
	LocalDate dateNiveauEvaluateur;
	
	@Getter
	@Setter
	LocalDate dateNiveauQuizz;
	
	@Getter
	@Setter
	LocalDate dateRefus;
	
	@Getter
	@Setter
	String commentaire;
	
	@Getter
	@Setter
	boolean courante;

	@ManyToOne
	@Getter
	@Setter
	Profil profil;

	@OneToMany(mappedBy = "candidature", fetch = FetchType.LAZY)
	@Getter
	@Setter
	List<CandidatureInQuizz> quizzs;
	
	@OneToMany(mappedBy = "candidature", fetch = FetchType.LAZY)
	@Getter
	@Setter
	List<Entretient> entretients;

	public Candidature(@NonNull Statut statut, @NonNull Profil profil) {
		super();
		this.statut = statut;
		this.profil = profil;
		this.dateDeCandidature = LocalDate.now();
		this.courante=false;
	}

	public Candidature(Statut statut, LocalDate dateDeCandidature, Profil profil) {
		super();
		this.statut = statut;
		this.dateDeCandidature = dateDeCandidature;
		this.profil = profil;
		this.courante=false;
	}

	public Candidature(Profil profil) {
		super();
		this.profil = profil;
		this.statut=Statut.En_Cours;
		this.dateDeCandidature = LocalDate.now();
		this.courante=true;
	}

	public Candidature(Profil profil,
			Statut statut,
			LocalDate dateDeCandidature,
			LocalDate dateAcceptation,
			LocalDate dateConfirmationCandidat,
			LocalDate dateNiveauEntretient,
			LocalDate dateNiveauEvaluateur,
			LocalDate dateNiveauQuizz,
			LocalDate dateRefus) {
		super();
		this.profil = profil;
		this.statut = statut;
		this.dateDeCandidature = dateDeCandidature;
		this.dateAcceptation = dateAcceptation;
		this.dateConfirmationCandidat = dateConfirmationCandidat;
		this.dateNiveauEntretient = dateNiveauEntretient;
		this.dateNiveauEvaluateur = dateNiveauEvaluateur;
		this.dateNiveauQuizz = dateNiveauQuizz;
		this.dateRefus = dateRefus;
	}
	
	

}
