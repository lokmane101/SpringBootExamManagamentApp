package com.Exams.core.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Exams.core.bo.Departement;




public interface IDepartementRepository extends JpaRepository<Departement, Long> {

	Departement findByNomDepartement(String nom);
}
