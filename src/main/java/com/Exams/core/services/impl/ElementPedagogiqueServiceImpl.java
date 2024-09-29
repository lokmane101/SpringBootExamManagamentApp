package com.Exams.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Exams.core.bo.ElementPedagogique;
import com.Exams.core.dao.IElementPedagogiqueRepository;
import com.Exams.core.services.IElementPedagogiqueService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ElementPedagogiqueServiceImpl implements IElementPedagogiqueService {
	

	@Autowired
	private IElementPedagogiqueRepository elementpedagogiqueDao;
	
	
	public void addElementPedagogique(ElementPedagogique elementpedagogique) {
		
		elementpedagogiqueDao.save( elementpedagogique);
	}

	@Override
	public void deleteElementPedagogique(Long id) {
		// TODO Auto-generated method stub
		elementpedagogiqueDao.deleteById(id);
		
	}

	@Override
	public void updateElementPedagogique(ElementPedagogique elementpedagogique) {
		// TODO Auto-generated method stub
		elementpedagogiqueDao.save(elementpedagogique);
		
	}

	
	
	public ElementPedagogique getElementPedagogiqueByTitre(String titre) {
		return elementpedagogiqueDao.getElementPedagogiqueByTitre(titre);
		
	}

	@Override
	public ElementPedagogique getElementPedagogiqueById(Long id) {
		// TODO Auto-generated method stub
		return elementpedagogiqueDao.findById(id).get();
	}

	@Override
	public List<ElementPedagogique> getAllElementPedagogiques() {
		// TODO Auto-generated method stub
		return elementpedagogiqueDao.findAll();
	}

	

}
