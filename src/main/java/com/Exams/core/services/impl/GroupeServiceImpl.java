package com.Exams.core.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Exams.core.bo.Groupe;
import com.Exams.core.dao.IGroupeRepository;
import com.Exams.core.services.IGroupeService;

@Service
@Transactional
public class GroupeServiceImpl implements IGroupeService {
	
	@Autowired
	private IGroupeRepository groupeDao;
	
	public void addGroupe(Groupe pGroupe) {
		groupeDao.save(pGroupe);

	}
	public void updateGroupe(Groupe pGroupe) {
		groupeDao.save(pGroupe);
	}
	public Groupe getGroupeById(Long id) {
		return groupeDao.findById(id).get();
	}
	public void deleteGroupe(Long id) {
		groupeDao.deleteById(id);	
	}
	
	public List<Groupe> getAllGroupes(){
		return groupeDao.findAll();
	}
	public Groupe getGroupeByNomGroupe(String nomGroupe) {
		return groupeDao.findByNomGroupe(nomGroupe);	}
	



}
