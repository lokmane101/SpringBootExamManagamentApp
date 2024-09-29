package com.Exams.core.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.Exams.core.bo.Administrateur;

public interface IAdministrateurRepository extends JpaRepository<Administrateur, Long> {
	

    Administrateur findByNom(String nom);

}
