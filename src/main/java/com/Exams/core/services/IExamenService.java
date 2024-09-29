package com.Exams.core.services;

import java.util.List;

import com.Exams.core.bo.Examen;




public interface IExamenService  {
	public void addExamen(Examen pExamen);

	public void updateExamen(Examen pPersonne);

	public List<Examen> getAllExamens();

	public void deleteExamen(Long id);

	public Examen getExamenById(Long id);
	

}
