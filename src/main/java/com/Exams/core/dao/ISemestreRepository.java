package com.Exams.core.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Exams.core.bo.Semestre;




public interface ISemestreRepository extends JpaRepository<Semestre, Long> {

	Semestre findByIntitule(String intitule);
}
