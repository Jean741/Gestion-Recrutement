package com.stage.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stage.addOn.CandidatureStats;
import com.stage.entities.Candidature;
import com.stage.entities.Profil;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, Long> {

	public Candidature findByProfilAndCourante(Profil profil, boolean courante);

	/*
	 * @Query("select new com.stage.addOn.CandidatureStats(count(u),u.dateDeCandidature,u.statut) from Candidature u  group by dateDeCandidature,statut"
	 * ) List<CandidatureStats> candidaturesParStatut();
	 */

	// Nombre de candidatures par status en general
	@Query("select new com.stage.addOn.CandidatureStats(count(u),u.statut) from Candidature u  group by statut")
	List<CandidatureStats> nombreDeCandidaturesParStatut();

	// Nombre de candidatures par date de candidature en general
	@Query("select new com.stage.addOn.CandidatureStats(count(u),u.dateDeCandidature) from Candidature u "
			+ "group by dateDeCandidature " + "ORDER BY date_de_candidature ASC")
	List<CandidatureStats> nombreDeCandidaturesParDateDeCandidature();

	// Nombre de candidatures par date de candidature par jour suivant un interval
	@Query("select new com.stage.addOn.CandidatureStats(count(u),u.dateDeCandidature) from Candidature u "
			+ "where date_de_candidature BETWEEN :dateDebut AND :dateFin " + "group by dateDeCandidature "
			+ "ORDER BY date_de_candidature ASC")
	List<CandidatureStats> nombreDeCandidaturesParDateDeCandidatureEntre(@Param("dateDebut") LocalDate dateDebut,
			@Param("dateFin") LocalDate dateFin);

	// Nombre de candidatures par date de candidature par Anne suivant un interval
	@Query("select new com.stage.addOn.CandidatureStats(count(u), TO_CHAR(u.dateDeCandidature,'YYYY') ) from Candidature u "
			+ "where TO_CHAR(u.dateDeCandidature,'YYYY') BETWEEN :dateDebut AND :dateFin "
			+ "group by TO_CHAR(u.dateDeCandidature,'YYYY') " + "ORDER BY TO_CHAR(u.dateDeCandidature,'YYYY') ASC")
	List<CandidatureStats> candidaturesParDateDeCandidatureEntreAnne(@Param("dateDebut") String dateDebut,
			@Param("dateFin") String dateFin);

	// Nombre de candidatures par date de candidature par Mois suivant un interval
	@Query("select new com.stage.addOn.CandidatureStats(count(u), TO_CHAR(u.dateDeCandidature,'YYYY-MM') ) from Candidature u "
			+ "where TO_CHAR(u.dateDeCandidature,'YYYY-MM') BETWEEN :dateDebut AND :dateFin  "
			+ "group by TO_CHAR(u.dateDeCandidature,'YYYY-MM') "
			+ "ORDER BY TO_CHAR(u.dateDeCandidature,'YYYY-MM') ASC")
	List<CandidatureStats> candidaturesParDateDeCandidatureEntreMois(@Param("dateDebut") String dateDebut,
			@Param("dateFin") String dateFin);

	// Nombre de candidatures par date de candidature suivant un interval
	@Query("select u from com.stage.entities.Candidature u "
			+ "where u.dateDeCandidature BETWEEN :dateDebut AND :dateFin " + "ORDER BY u.dateDeCandidature ASC")
	List<Candidature> candidaturesParDateDeCandidatureEntre(@Param("dateDebut") LocalDate dateDebut,
			@Param("dateFin") LocalDate dateFin);

}
