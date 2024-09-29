package com.Exams.core.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Exams.core.bo.Filiere;
import com.Exams.core.dao.IFiliereRepository;
import com.Exams.core.services.IFiliereService;

@Service
@Transactional
public class FiliereServiceImpl implements IFiliereService {
	
	@Autowired
	private IFiliereRepository filiereDao;
	
	public void addFiliere(Filiere pFiliere) {
		filiereDao.save(pFiliere);

	}
	public void updateFiliere(Filiere pFiliere) {
		filiereDao.save(pFiliere);
	}
	public Filiere getFiliereByIdFiliere(Long id) {
		return filiereDao.findById(id).get();
	}
	public void deleteFiliere(Long id) {
		filiereDao.deleteById(id);	
	}
	
	public List<Filiere> getAllFilieres(){
		return filiereDao.findAll();
	}
	
	public Filiere findByNomFiliere(String nom) {
		return filiereDao.findByNomFiliere(nom);
	}

	


}
