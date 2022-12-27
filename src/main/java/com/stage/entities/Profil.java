package com.stage.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@JsonIgnoreProperties(value = { "experiencesScolaires", "experiencesProfessionnelles", "dossierCandidatures", "candidatures" })
public class Profil implements Serializable {

	static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	// @Column(name = "profil_id")
	Long id;

	@Column(nullable = false, unique = true)
	@Getter
	@Setter
	String numCorrespondance;

	@Getter
	@Setter
	String competenceUne;

	@Getter
	@Setter
	String competenceDeux;

	@Getter
	@Setter
	String competenceTrois;
	
	@Getter
	@Setter
	LocalDate dateDeCreation;

	@Getter
	@Setter
	String source;
	
	@Getter
	@Setter
	String lienLinkedIn;
	
	@Getter
	@Setter
	String lienAutre;

	@OneToMany(mappedBy = "profil", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@Getter
	@Setter
	List<ExperienceScolaire> experiencesScolaire;

	@OneToMany(mappedBy = "profil", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@Getter
	@Setter
	List<ExperienceProfessionnelle> experiencesProfessionnelle;
	
	@OneToMany(mappedBy = "profil", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@Getter
	@Setter
	List<Candidature> candidatures;

	@OneToMany(mappedBy = "profil", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@Getter
	@Setter
	List<DossierCandidature> dossierCandidatures;

	public Profil(String numCorrespondance) {
		super();
		this.numCorrespondance = numCorrespondance;
		this.dateDeCreation = LocalDate.now();
	}

}
