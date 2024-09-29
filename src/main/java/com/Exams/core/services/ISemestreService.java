package com.Exams.core.services;
import com.Exams.core.bo.Semestre;

import java.util.List;


public interface ISemestreService {
	
	
	public void addSemestre(Semestre semestre);

	public void updateSemestre(Semestre semestre);

	public List<Semestre> getAllSemestres();

	public void deleteSemestre(Long id);

	public Semestre getSemestreById(Long id);
	public Semestre getSemestreByIntitule(String intitule);
	
}
