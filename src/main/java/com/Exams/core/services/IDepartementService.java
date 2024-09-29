package com.Exams.core.services;
import com.Exams.core.bo.Departement;

import java.util.List;


public interface IDepartementService {
	
	
	public void addDepartement(Departement departement);

	public void updateDepartement(Departement departement);

	public List<Departement> getAllDepartements();

	public void deleteDepartement(Long id);

	public Departement getDepartementById(Long id);
	

	public Departement findByNomDepartement(String departement);

	
	
}
