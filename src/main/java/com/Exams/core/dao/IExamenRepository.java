package com.Exams.core.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Exams.core.bo.Examen;




public interface IExamenRepository extends JpaRepository<Examen, Long> {
}
