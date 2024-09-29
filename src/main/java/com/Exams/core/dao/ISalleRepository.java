package com.Exams.core.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Exams.core.bo.Salle;

public interface ISalleRepository extends JpaRepository<Salle, Long> {

	Salle findByNomSalle(String nomSalle);
}
