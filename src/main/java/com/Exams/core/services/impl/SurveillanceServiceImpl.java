package com.Exams.core.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Exams.core.bo.Surveillance;
import com.Exams.core.dao.ISurveillanceRepository;
import com.Exams.core.services.ISurveillanceService;

@Service
@Transactional
public class SurveillanceServiceImpl implements ISurveillanceService {
	
	@Autowired
	private ISurveillanceRepository surveillanceDao;
	
	public void addSurveillance(Surveillance pSurveillance) {
		surveillanceDao.save(pSurveillance);

	}
	public void updateSurveillance(Surveillance pSurveillance) {
		surveillanceDao.save(pSurveillance);
	}
	public Surveillance getSurveillanceById(Long id) {
		return surveillanceDao.findById(id).get();
	}
	public void deleteSurveillance(Long id) {
		surveillanceDao.deleteById(id);	
	}
	
	public List<Surveillance> getAllSurveillances(){
		return surveillanceDao.findAll();
	}

	


}
