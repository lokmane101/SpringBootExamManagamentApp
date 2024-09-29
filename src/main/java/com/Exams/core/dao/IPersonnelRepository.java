package com.Exams.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Exams.core.bo.Personnel;

public interface IPersonnelRepository extends JpaRepository<Personnel, Long> {
    Personnel findByIdPersonnel(Long idPersonnel);
    
    List<Personnel> findByNomAndPrenom(String nom, String prenom);
    
    Personnel findByNom(String nom);

}
