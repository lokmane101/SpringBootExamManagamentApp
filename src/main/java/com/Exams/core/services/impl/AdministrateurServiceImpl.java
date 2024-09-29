package com.Exams.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Exams.core.bo.Administrateur;
import com.Exams.core.dao.IAdministrateurRepository;
import com.Exams.core.services.IAdministrateurService;

@Service
@Transactional
public class AdministrateurServiceImpl implements IAdministrateurService{

	@Autowired
	private IAdministrateurRepository administrateurDao;
	
	public Administrateur getAdministrateurByNom(String nom) {
    	return administrateurDao.findByNom(nom);
    }
	public List<Administrateur> getAllAdministrateurs() {
    	return administrateurDao.findAll();
    }

	

}
