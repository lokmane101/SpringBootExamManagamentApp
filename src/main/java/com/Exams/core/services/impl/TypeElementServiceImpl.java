package com.Exams.core.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Exams.core.bo.TypeElement;
import com.Exams.core.dao.ITypeElementRepository;
import com.Exams.core.services.ITypeElementService;

@Service
@Transactional
public class TypeElementServiceImpl implements ITypeElementService {
	
	@Autowired
	private ITypeElementRepository typeElementDao;
	
	public void addTypeElement(TypeElement pTypeElement) {
		typeElementDao.save(pTypeElement);

	}
	public void updateTypeElement(TypeElement pTypeElement) {
		typeElementDao.save(pTypeElement);
	}
	public TypeElement getTypeElementById(Long id) {
		return typeElementDao.findById(id).get();
	}
	public void deleteTypeElement(Long id) {
		typeElementDao.deleteById(id);	
	}
	
	public List<TypeElement> getAllTypeElements(){
		return typeElementDao.findAll();
	}

	


}
