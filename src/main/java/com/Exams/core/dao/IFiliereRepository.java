package com.Exams.core.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Exams.core.bo.Filiere;

public interface IFiliereRepository extends JpaRepository<Filiere, Long> {
	
	public Filiere findByNomFiliere(String nom); 
}
