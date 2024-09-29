package com.Exams.core.services;
import com.Exams.core.bo.Personnel;

import java.util.List;


public interface IPersonnelService {
	
	
	public void addPersonnel(Personnel pPersonnel);

	public void updatePersonnel(Personnel pPersonne);

	public List<Personnel> getAllPersonnels();

	public void deletePersonnel(Long id);

	public Personnel getPersonnelById(Long id);
	public List<Personnel> getPersonnelByNomAndPrenom(String nom, String prenom);
	
	
}
