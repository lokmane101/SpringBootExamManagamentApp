package com.Exams.core.services;

import java.util.List;

import com.Exams.core.bo.Administrateur;

public interface IAdministrateurService {
	

	public Administrateur getAdministrateurByNom(String nom);
	public List<Administrateur> getAllAdministrateurs();

	
}
