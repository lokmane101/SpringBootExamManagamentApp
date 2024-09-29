package com.Exams.core.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Exams.core.bo.Personnel;
import com.Exams.core.dao.IPersonnelRepository;
import com.Exams.core.services.IPersonnelService;

@Service
@Transactional
public class PersonnelServiceImpl implements IPersonnelService {
	
	@Autowired
	private IPersonnelRepository personnelDao;
	
	public void addPersonnel(Personnel pPersonnel) {
		personnelDao.save(pPersonnel);

	}
	public void updatePersonnel(Personnel pPersonnel) {
		personnelDao.save(pPersonnel);
	}
	public Personnel getPersonnelById(Long id) {
		return personnelDao.findById(id).get();
	}
	public void deletePersonnel(Long id) {
		personnelDao.deleteById(id);	
	}
	
	public List<Personnel> getAllPersonnels(){
		return personnelDao.findAll();
	}
	public List<Personnel> getPersonnelByNomAndPrenom(String nom, String prenom) {
		return personnelDao.findByNomAndPrenom(nom, prenom);
		
	}
     

}
