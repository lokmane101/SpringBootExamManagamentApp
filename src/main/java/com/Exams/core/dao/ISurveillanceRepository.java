package com.Exams.core.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Exams.core.bo.Surveillance;




public interface ISurveillanceRepository extends JpaRepository<Surveillance, Long> {
}
