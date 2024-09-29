package com.Exams.core.services;
import com.Exams.core.bo.Groupe;

import java.util.List;


public interface IGroupeService {
	
	
	public void addGroupe(Groupe groupe);

	public void updateGroupe(Groupe groupe);

	public List<Groupe> getAllGroupes();

	public void deleteGroupe(Long id);

	public Groupe getGroupeById(Long id);
	public Groupe getGroupeByNomGroupe(String nomGroupe);

	 //public Groupe findGroupeWithEnseignants();
	
}
