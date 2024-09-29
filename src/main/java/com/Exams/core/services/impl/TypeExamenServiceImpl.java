package com.Exams.core.services.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Exams.core.bo.TypeExamen;
import com.Exams.core.dao.ITypeExamenRepository;
import com.Exams.core.services.ITypeExamenService;

@Service
@Transactional
public class TypeExamenServiceImpl implements ITypeExamenService {
	
	@Autowired
	private ITypeExamenRepository typeExamenDao;
	
	public void addTypeExamen(TypeExamen pTypeExamen) {
		typeExamenDao.save(pTypeExamen);

	}
	public void updateTypeExamen(TypeExamen pTypeExamen) {
		typeExamenDao.save(pTypeExamen);
	}
	public TypeExamen getTypeExamenById(Long id) {
		return typeExamenDao.findById(id).get();
	}
	public void deleteTypeExamen(Long id) {
		typeExamenDao.deleteById(id);	
	}
	
	public List<TypeExamen> getAllTypeExamens(){
		return typeExamenDao.findAll();
	}
	@Override
	public TypeExamen getTypeExamenByIntitule(String intitule) {
		return typeExamenDao.findByIntitule(intitule);
	}
	

	

	


}
