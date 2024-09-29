package com.Exams.core.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Exams.core.bo.Departement;
import com.Exams.core.dao.IDepartementRepository;
import com.Exams.core.services.IDepartementService;

@Service
@Transactional
public class DepartementServiceImpl implements IDepartementService {
	
	@Autowired
	private IDepartementRepository departementDao;
	
	public void addDepartement(Departement pDepartement) {
		departementDao.save(pDepartement);

	}
	public void updateDepartement(Departement pDepartement) {
		departementDao.save(pDepartement);
	}
	public Departement getDepartementById(Long id) {
		return departementDao.findById(id).get();
	}
	public void deleteDepartement(Long id) {
		departementDao.deleteById(id);	
	}
	
	public List<Departement> getAllDepartements(){
		return departementDao.findAll();
		
	}
	
		public Departement findByNomDepartement(String nom) {
		    return departementDao.findByNomDepartement(nom);
		}

		
	}

