package com.Exams.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Exams.core.bo.Groupe;




public interface IGroupeRepository extends JpaRepository<Groupe, Long> {
	Groupe findByIdGroupe(Long idGroupe);    
    Groupe findByNomGroupe(String nom);
   
}
