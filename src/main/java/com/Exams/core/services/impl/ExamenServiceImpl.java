package com.Exams.core.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Exams.core.bo.Examen;
import com.Exams.core.dao.IExamenRepository;
import com.Exams.core.services.IExamenService;

@Service
@Transactional
public class ExamenServiceImpl implements IExamenService {
	
	@Autowired
	private IExamenRepository examenDao;
	
	public void addExamen(Examen pExamen) {
		examenDao.save(pExamen);

	}
	public void updateExamen(Examen pExamen) {
		examenDao.save(pExamen);
	}
	public Examen getExamenById(Long id) {
		return examenDao.findById(id).get();
	}
	public void deleteExamen(Long id) {
		examenDao.deleteById(id);	
	}
	
	public List<Examen> getAllExamens(){
		return examenDao.findAll();		
	}


}
