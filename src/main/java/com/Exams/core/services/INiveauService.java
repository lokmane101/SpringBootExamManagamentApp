package com.Exams.core.services;
import com.Exams.core.bo.Niveau;

import java.util.List;


public interface INiveauService {
	
	
	public void addNiveau(Niveau niveau);

	public void updateNiveau(Niveau niveau);

	public List<Niveau> getAllNiveaus();

	public void deleteNiveau(Long id);

	public Niveau getNiveauById(Long id);
	
}
