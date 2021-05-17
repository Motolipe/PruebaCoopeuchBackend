package com.pruebatecnica.springboot.backend.api.service;

import java.util.List;

import com.pruebatecnica.springboot.backend.api.dto.Mantenedor;

public interface IMantenedorService {

	public List<Mantenedor> findAll();
	public Mantenedor findById(int id);
	public void deleteById(int id);
	public Mantenedor save(Mantenedor persona);
	
}
