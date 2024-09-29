package com.Exams.core.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Exams.core.bo.Niveau;
import com.Exams.core.dao.INiveauRepository;
import com.Exams.core.services.INiveauService;

@Service
@Transactional
public class NiveauServiceImpl implements INiveauService {
	
	@Autowired
	private INiveauRepository niveauDao;
	
	public void addNiveau(Niveau pNiveau) {
		niveauDao.save(pNiveau);

	}
	public void updateNiveau(Niveau pNiveau) {
		niveauDao.save(pNiveau);
	}
	public Niveau getNiveauById(Long id) {
		return niveauDao.findById(id).get();
	}
	public void deleteNiveau(Long id) {
		niveauDao.deleteById(id);	
	}
	
	public List<Niveau> getAllNiveaus(){
		return niveauDao.findAll();
	}

	


}
