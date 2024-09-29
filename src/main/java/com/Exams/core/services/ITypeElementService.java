package com.Exams.core.services;
import com.Exams.core.bo.TypeElement;

import java.util.List;


public interface ITypeElementService {
	
	
	public void addTypeElement(TypeElement typeElement);

	public void updateTypeElement(TypeElement typeElement);

	public List<TypeElement> getAllTypeElements();

	public void deleteTypeElement(Long id);

	public TypeElement getTypeElementById(Long id);
	
}
