package com.Exams.core.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Exams.core.bo.Session;




public interface ISessionRepository extends JpaRepository<Session, Long> {

	Session findByIntitule(String intitule);
}
