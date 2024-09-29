package com.Exams.core.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Exams.core.bo.Salle;
import com.Exams.core.dao.ISalleRepository;
import com.Exams.core.services.ISalleService;

@Service
@Transactional
public class SalleServiceImpl implements ISalleService {
	
	@Autowired
	private ISalleRepository salleDao;
	
	public void addSalle(Salle pSalle) {
		salleDao.save(pSalle);

	}
	public void updateSalle(Salle pSalle) {
		salleDao.save(pSalle);
	}
	public Salle getSalleById(Long id) {
		return salleDao.findById(id).get();
	}
	public void deleteSalle(Long id) {
		salleDao.deleteById(id);	
	}
	
	public List<Salle> getAllSalles(){
		return salleDao.findAll();
	}
	@Override
	public Salle getSalleByNomSalle(String nomSalle) {
		return salleDao.findByNomSalle(nomSalle );
		
	}

	


}
