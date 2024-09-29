package com.Exams.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Exams.core.bo.Enseignant;

public interface IEnseignantRepository extends JpaRepository<Enseignant, Long> {
	
    @Query("SELECT e FROM Enseignant e WHERE e.filiere.id = :id_filiere")
    List<Enseignant> findAllByFiliereId(@Param("id_filiere") Long filiereId);

    @Query("SELECT e FROM Enseignant e WHERE e.departement.id = :id_departement")
    List<Enseignant> findAllByDepartementId(@Param("id_departement") Long departementId);

	Enseignant findByNom(String nom);

}
