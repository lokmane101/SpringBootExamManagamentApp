package com.Exams.core.services;
import java.util.List;

import com.Exams.core.bo.Enseignant;

public interface IEnseignantService {
	
	public List<Enseignant> getAllEnseignants();
	public List<Enseignant> getAllEnseignantsByFiliereId(Long id);
	public Enseignant getEnseignantById(Long id);
	public List<Enseignant> getAllEnseignantsByDepartementId(Long id);
	public Enseignant getEnseignantByNom(String nom);
	public void updateEnseignant(Enseignant enseignant);

	
}
