package com.Exams.core.services;
import com.Exams.core.bo.TypeExamen;

import java.util.List;


public interface ITypeExamenService {
	
	
	public void addTypeExamen(TypeExamen typeExamen);

	public void updateTypeExamen(TypeExamen typeExamen);

	public List<TypeExamen> getAllTypeExamens();

	public void deleteTypeExamen(Long id);

	public TypeExamen getTypeExamenById(Long id);
	
	public TypeExamen getTypeExamenByIntitule(String intitule);
}
