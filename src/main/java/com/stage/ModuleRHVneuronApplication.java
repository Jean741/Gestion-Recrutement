package com.stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.stage.repository.AnneDiplomesAcceptesRepository;
import com.stage.repository.CandidatureInQuizzRepository;
import com.stage.repository.CandidatureRepository;
import com.stage.repository.DecisionEvaluateurRepository;
import com.stage.repository.DossierCandidatureRepository;
import com.stage.repository.EntrepriseRepository;
import com.stage.repository.EtablissementScolaireRepository;
import com.stage.repository.ExperienceProfessionnelleRepository;
import com.stage.repository.ExperienceScolaireRepository;
import com.stage.repository.OffreRepository;
import com.stage.repository.PosteRepository;
import com.stage.repository.ProfilRepository;
import com.stage.repository.QuizzRepository;


@SpringBootApplication
public class ModuleRHVneuronApplication extends SpringBootServletInitializer implements CommandLineRunner {
	
	@Autowired
	DecisionEvaluateurRepository decisionEvaluateurRepository;

	@Autowired
	DossierCandidatureRepository dossierCandidatureRepository;

	@Autowired
	OffreRepository offreRepository;
	@Autowired
	ProfilRepository profilRepository;
	@Autowired
	ExperienceProfessionnelleRepository experienceProfessionnelleRepository;

	@Autowired
	ExperienceScolaireRepository experienceScolaireRepository;
	@Autowired
	EntrepriseRepository entrepriseRepository;
	@Autowired
	PosteRepository posteRepository;
	
	@Autowired
	CandidatureInQuizzRepository candidatureInQuizzRepository;
	@Autowired
	EtablissementScolaireRepository etablissementScolaireRepository;
	@Autowired
	AnneDiplomesAcceptesRepository anneRepository;
	@Autowired
	QuizzRepository quizzRepository;

	@Autowired
	CandidatureRepository candidatureRepository;
	 
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ModuleRHVneuronApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ModuleRHVneuronApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*	// decisions
		DecisionEvaluateur d1 = new DecisionEvaluateur("Refuser");
		DecisionEvaluateur d2 = new DecisionEvaluateur("Aiguiller");
		DecisionEvaluateur d3 = new DecisionEvaluateur("Renvoyer pour passer des quizz");
		DecisionEvaluateur d4 = new DecisionEvaluateur("Accepter");
		DecisionEvaluateur d5 = new DecisionEvaluateur("Programmer pour un entretient");

		decisionEvaluateurRepository.save(d1);
		decisionEvaluateurRepository.save(d2);
		decisionEvaluateurRepository.save(d3);
		decisionEvaluateurRepository.save(d4);
		decisionEvaluateurRepository.save(d5);

		// Offres
		Offre offre = new Offre("Developpeur Java");
		Offre offre1 = new Offre("Developpeur Python");
		Offre offre2 = new Offre("Chercheur Commercial");
		Offre offre3 = new Offre("Techicient de surface");

		offreRepository.save(offre);
		offreRepository.save(offre1);
		offreRepository.save(offre2);
		offreRepository.save(offre3);

		// anneRepository

		for (int j = 2005; j < 2020; j++) {
			//System.out.println(String.valueOf(j));
			AnneDiplomesAcceptes a = new AnneDiplomesAcceptes(String.valueOf(j));
			anneRepository.save(a);
		}

		// *********************************************************************************************************

		// **************** Entreprises *************************
		List<String> entreprises = new ArrayList<String>();
		entreprises.add("Vneuron");
		entreprises.add("Spark-It");
		entreprises.add("Megasoft");
		entreprises.add("Creative AZed");
		entreprises.add("WORKGROUP TECHNOLOGIES");
		entreprises.add("Graphicard Tunisie");
		entreprises.add("TelNet");
		entreprises.add("ASM-Mulimediat");
		entreprises.add("Fredom Of Dev");
		entreprises.add("Talend");
		entreprises.add("VEGANET");
		entreprises.add("Minotore");
		entreprises.forEach(entreprise -> {
			Entreprise en = new Entreprise(entreprise);
			entrepriseRepository.save(en);
		});

		Poste poste = new Poste("Secretaire");
		Poste poste1 = new Poste("Comptable");
		posteRepository.save(poste);
		posteRepository.save(poste1);

		// **************** Profil *************************

		Profil p1 = new Profil("jeaunclaude.attiglah@vneuron.com");
		Profil p = new Profil("1001");

		profilRepository.save(p);
		profilRepository.save(p1);

		// **************** Etablissement Scolaires *************************

		List<String> etablissements = new ArrayList<String>();
		etablissements.add("Enis");
		etablissements.add("ENET'com");
		etablissements.add("École nationale d'ingénieurs de Bizerte");
		etablissements.add("École nationale d'ingénieurs de Carthage");
		etablissements.add("École nationale d'ingénieurs de Gabès");
		etablissements.add("École polytechnique de Tunisie");
		etablissements.add("ENSIT");
		etablissements.add("Institut supérieur d'informatique et de multimédia de Sfax ");
		etablissements.add("Institut supérieur d'informatique ");
		etablissements.add("Faculté des Sciences de Tunis");
		etablissements.add("Faculte de Gestion de Tunis");
		etablissements.add("Faculte de Commerce de Nabeul");
		etablissements.add("Institut supérieur des arts multimédia de La Manouba");
		etablissements.add("École nationale supérieure d'ingénieurs de Tunis");
		etablissements.add("ESPRIT");

		etablissements.forEach(etablissement -> {
			EtablissementScolaire ets = new EtablissementScolaire(etablissement);
			etablissementScolaireRepository.save(ets);
		});

		// profilRepository.deleteById(20L);
		profilRepository.findAll().forEach(a -> {
			//System.out.println(a.getId());
		});

	

		// **************** Quizzs *************************
		List<String> quizzs = new ArrayList<String>();
		
		quizzs.add("Java");
		quizzs.add("PHP");
		quizzs.add("JavaScript");
		quizzs.add("Personnalité");
		quizzs.add("SQL");
		quizzs.add("Nouveauté Java 8");
		quizzs.add("Machine learning");
		quizzs.add("Rapidité");
		quizzs.add("Productivité");

		quizzs.forEach(quizz -> {
			Quizz qu = new Quizz(quizz);
			quizzRepository.save(qu);
		});
		
	
		

		// **************** Candidatures *************************
		 LocalDate date = LocalDate.parse("2017-02-05");
		 LocalDate date1 = LocalDate.parse("2018-02-05");
		 LocalDate date2 = LocalDate.parse("2019-02-05");
		 LocalDate date3 = LocalDate.parse("2019-02-06");
		 LocalDate date4 = LocalDate.parse("2019-03-05");
		 
		 

		 candidatureRepository.save(new Candidature(Statut.Accepté,date,profilRepository.findById(1L).get()));
		 candidatureRepository.save(new Candidature(Statut.En_Cours,date1,profilRepository.findById(1L).get()));
		 candidatureRepository.save(new Candidature(Statut.Cloturée,date,profilRepository.findById(1L).get()));
		 candidatureRepository.save(new Candidature(Statut.Cloturée,date2,profilRepository.findById(2L).get()));
		 candidatureRepository.save(new Candidature(Statut.Accepté,date2,profilRepository.findById(1L).get()));
		 candidatureRepository.save(new Candidature(Statut.Cloturée,date2,profilRepository.findById(2L).get()));
		 candidatureRepository.save(new Candidature(Statut.Confirmation_du_candidat,profilRepository.findById(1L).get()));
		 candidatureRepository.save(new Candidature(Statut.Accepté,date,profilRepository.findById(1L).get()));
		 candidatureRepository.save(new Candidature(Statut.En_Cours,date1,profilRepository.findById(1L).get()));
		 candidatureRepository.save(new Candidature(Statut.Cloturée,date,profilRepository.findById(1L).get()));
		 candidatureRepository.save(new Candidature(Statut.Cloturée,date2,profilRepository.findById(2L).get()));
		 candidatureRepository.save(new Candidature(Statut.Accepté,date2,profilRepository.findById(1L).get()));
		 candidatureRepository.save(new Candidature(Statut.Cloturée,date2,profilRepository.findById(2L).get()));
		 candidatureRepository.save(new Candidature(Statut.Confirmation_du_candidat,profilRepository.findById(1L).get()));
		 candidatureRepository.save(new Candidature(Statut.Accepté,date,profilRepository.findById(1L).get()));
		 candidatureRepository.save(new Candidature(Statut.En_Cours,date3,profilRepository.findById(1L).get()));
		 candidatureRepository.save(new Candidature(Statut.Cloturée,date,profilRepository.findById(1L).get()));
		 candidatureRepository.save(new Candidature(Statut.Cloturée,date2,profilRepository.findById(2L).get()));
		 candidatureRepository.save(new Candidature(Statut.Accepté,date4,profilRepository.findById(1L).get()));
		 candidatureRepository.save(new Candidature(Statut.Cloturée,date2,profilRepository.findById(2L).get()));
		 candidatureRepository.save(new Candidature(Statut.Confirmation_du_candidat,profilRepository.findById(1L).get()));
		 candidatureRepository.save(new Candidature(profilRepository.findById(1L).get()));
		 
		// **************** Candidatures  in quizz*************************
		 
		// candidatureInQuizzRepository.save(new CandidatureInQuizz(quizzRepository.findById(1L).get(), candidatureRepository.findById(22L).get()));
		// candidatureInQuizzRepository.save(new CandidatureInQuizz(quizzRepository.findById(2L).get(), candidatureRepository.findById(22L).get()));
		 //candidatureInQuizzRepository.save(new CandidatureInQuizz(quizzRepository.findById(4L).get(), candidatureRepository.findById(22L).get()));
	
		//  candidatureRepository.save(new Candidature(profilRepository.findByNumCorrespondance("jeaunclaude.attiglah@vneuron.com")));
		// candidatureInQuizzRepository.save(new CandidatureInQuizz(quizzRepository.findById(2L).get(), candidatureRepository.findById(1L).get()));
		  	

		//  candidatureRepository.save(new Candidature(profilRepository.findByNumCorrespondance("jeaunclaude.attiglah@vneuron.com"),Statut.Accepté,date2,date1,date2,date3,date4,date3,date));

		 
		 */

		}

}
