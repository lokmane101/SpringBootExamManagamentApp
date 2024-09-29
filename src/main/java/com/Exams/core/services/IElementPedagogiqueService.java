package com.Exams.core.services;

import java.util.List;

import com.Exams.core.bo.ElementPedagogique;

public interface IElementPedagogiqueService {
	
	public void addElementPedagogique(ElementPedagogique elementpedagogique);
	
	public void deleteElementPedagogique(Long id);
	
	public void updateElementPedagogique(ElementPedagogique elementpedagogique);
	
	public ElementPedagogique getElementPedagogiqueById(Long id);
	
	public ElementPedagogique getElementPedagogiqueByTitre(String titre);
	
	public List<ElementPedagogique> getAllElementPedagogiques();
}
