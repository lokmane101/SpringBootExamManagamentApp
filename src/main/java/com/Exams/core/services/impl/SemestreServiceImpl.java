package com.Exams.core.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Exams.core.bo.Semestre;
import com.Exams.core.dao.ISemestreRepository;
import com.Exams.core.services.ISemestreService;

@Service
@Transactional
public class SemestreServiceImpl implements ISemestreService {
	
	@Autowired
	private ISemestreRepository semestreDao;
	
	public void addSemestre(Semestre pSemestre) {
		semestreDao.save(pSemestre);

	}
	public void updateSemestre(Semestre pSemestre) {
		semestreDao.save(pSemestre);
	}
	public Semestre getSemestreById(Long id) {
		return semestreDao.findById(id).get();
	}
	public void deleteSemestre(Long id) {
		semestreDao.deleteById(id);	
	}
	
	public List<Semestre> getAllSemestres(){
		return semestreDao.findAll();
	}
	
	public Semestre getSemestreByIntitule(String intitule) {
		return semestreDao.findByIntitule(intitule);
	}

	


}
