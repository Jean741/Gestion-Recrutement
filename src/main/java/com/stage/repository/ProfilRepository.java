package com.stage.repository;

 

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stage.addOn.ProfilStats;
import com.stage.entities.Profil;
@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long> {

	public Optional<Profil> findById(Long id);
 	public Profil findByNumCorrespondance(String numCorrespondance);
 	
 	
 	
 	@Query("select new com.stage.addOn.ProfilStats(count(p),p.dateDeCreation) from Profil p  group by dateDeCreation")
	List<ProfilStats> profilsParDateDeCreation();

}
