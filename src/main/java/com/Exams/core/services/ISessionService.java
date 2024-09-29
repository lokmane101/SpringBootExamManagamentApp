package com.Exams.core.services;
import com.Exams.core.bo.Session;

import java.util.List;


public interface ISessionService {
	
	
	public void addSession(Session session);

	public void updateSession(Session session);

	public List<Session> getAllSessions();

	public void deleteSession(Long id);

	public Session getSessionById(Long id);
	public Session getSessionByIntitule(String intitule);
	
}
