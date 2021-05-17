package com.pruebatecnica.springboot.backend.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebatecnica.springboot.backend.api.dao.MantenedorDao;
import com.pruebatecnica.springboot.backend.api.dto.Mantenedor;

@Service
public class MantenedorServiceImpl implements IMantenedorService {
	
	@Autowired
	private MantenedorDao mantenedorDao; 
	
	@Override
	@Transactional(readOnly = true)
	public List<Mantenedor> findAll() { 
		return (List<Mantenedor>) mantenedorDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Mantenedor findById(int id) {
		return mantenedorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		mantenedorDao.deleteById(id);		
	}
	
	@Override
	@Transactional
	public Mantenedor save(Mantenedor persona) {
		return mantenedorDao.save(persona);
	}

}
