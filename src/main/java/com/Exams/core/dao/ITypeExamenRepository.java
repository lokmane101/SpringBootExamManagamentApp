package com.Exams.core.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Exams.core.bo.TypeExamen;




public interface ITypeExamenRepository extends JpaRepository<TypeExamen, Long> {

	public TypeExamen findByIntitule(String intitule);
}
