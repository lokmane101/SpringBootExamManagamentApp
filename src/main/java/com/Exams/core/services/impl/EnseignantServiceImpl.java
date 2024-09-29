package com.Exams.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Exams.core.bo.Enseignant;
import com.Exams.core.dao.IEnseignantRepository;
import com.Exams.core.services.IEnseignantService;

@Service
@Transactional
public class EnseignantServiceImpl implements IEnseignantService{

	@Autowired
	private IEnseignantRepository enseignantDao;
	@Override
	public List<Enseignant> getAllEnseignants() {
		return enseignantDao.findAll();
	}
	@Override
    public List<Enseignant> getAllEnseignantsByFiliereId(Long filiereId) {
        return enseignantDao.findAllByFiliereId(filiereId);
    }

    @Override
    public List<Enseignant> getAllEnseignantsByDepartementId(Long departementId) {
        return enseignantDao.findAllByDepartementId(departementId);
    }
    @Override
	public Enseignant getEnseignantByNom(String nom) {
    	return enseignantDao.findByNom(nom);
    }
	@Override
	public Enseignant getEnseignantById(Long id) {
		
		return enseignantDao.findById(id).get();
	}
	@Override
	public void updateEnseignant(Enseignant enseignant) {
		enseignantDao.save(enseignant);
		
	}

	

}
