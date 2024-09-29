package com.Exams.core.services;
import com.Exams.core.bo.Surveillance;

import java.util.List;


public interface ISurveillanceService {
	
	
	public void addSurveillance(Surveillance surveillance);

	public void updateSurveillance(Surveillance surveillance);

	public List<Surveillance> getAllSurveillances();

	public void deleteSurveillance(Long id);

	public Surveillance getSurveillanceById(Long id);
	
}
