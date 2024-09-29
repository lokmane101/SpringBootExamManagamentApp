package com.Exams.core.services;
import com.Exams.core.bo.Filiere;

import java.util.List;


public interface IFiliereService {
	
	
	public void addFiliere(Filiere filiere);

	public void updateFiliere(Filiere filiere);

	public List<Filiere> getAllFilieres();

	public void deleteFiliere(Long id);

	public Filiere getFiliereByIdFiliere(Long id);
	
	public Filiere findByNomFiliere(String nom);
	
}
