package com.Exams.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Exams.core.bo.ElementPedagogique;



public interface IElementPedagogiqueRepository extends JpaRepository<ElementPedagogique, Long>{
	ElementPedagogique getElementPedagogiqueByTitre(String titre);
}
