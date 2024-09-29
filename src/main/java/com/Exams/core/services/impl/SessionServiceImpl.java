package com.Exams.core.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Exams.core.bo.Session;
import com.Exams.core.dao.ISessionRepository;
import com.Exams.core.services.ISessionService;

@Service
@Transactional
public class SessionServiceImpl implements ISessionService {
	
	@Autowired
	private ISessionRepository sessionDao;
	
	public void addSession(Session pSession) {
		sessionDao.save(pSession);

	}
	public void updateSession(Session pSession) {
		sessionDao.save(pSession);
	}
	public Session getSessionById(Long id) {
		return sessionDao.findById(id).get();
	}
	public void deleteSession(Long id) {
		sessionDao.deleteById(id);	
	}
	
	public List<Session> getAllSessions(){
		return sessionDao.findAll();
	}
	
	public Session getSessionByIntitule(String intitule){
		return sessionDao.findByIntitule(intitule);
	}
	
	

	


}
