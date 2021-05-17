package com.pruebatecnica.springboot.backend.api.dao;

import org.springframework.data.repository.CrudRepository;

import com.pruebatecnica.springboot.backend.api.dto.Mantenedor;

public interface MantenedorDao extends CrudRepository<Mantenedor, Integer> {

}
