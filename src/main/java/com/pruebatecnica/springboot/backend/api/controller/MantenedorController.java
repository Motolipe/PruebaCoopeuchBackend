package com.pruebatecnica.springboot.backend.api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.springboot.backend.api.dto.Mantenedor;
import com.pruebatecnica.springboot.backend.api.service.IMantenedorService;

@RestController
@CrossOrigin("*")
public class MantenedorController {
	
	@Autowired
	private IMantenedorService mantenedorService;
	
	@GetMapping("/listar")
	public List<Mantenedor> listar(){
	return mantenedorService.findAll();
	}

	@GetMapping("/ver/{id}")
	public Mantenedor detalle(@PathVariable int id){
	return mantenedorService.findById(id);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Mantenedor> delete(@PathVariable int id){
		Mantenedor mantenedor = mantenedorService.findById(id);
		
		if(mantenedor != null) {
		mantenedorService.deleteById(id);
		}else {
			return new ResponseEntity<Mantenedor>(mantenedor, HttpStatus.INTERNAL_SERVER_ERROR);
		}
			return new ResponseEntity<Mantenedor>(mantenedor, HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	public ResponseEntity<Mantenedor> save(@RequestBody Mantenedor mantenedor) {
		Date date = new Date();
		mantenedor.setFechaCreacion(date);
		Mantenedor obj = mantenedorService.save(mantenedor);
		return new ResponseEntity<Mantenedor>(obj, HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<Mantenedor> editar(@RequestBody Mantenedor mantenedor, @PathVariable int id){
		Mantenedor mantenedorDB = mantenedorService.findById(id);
		if(mantenedorDB !=null) {
		Date date = new Date();
		mantenedorDB.setDescripcion(mantenedor.getDescripcion());
		mantenedorDB.setVigente(mantenedor.isVigente());
		mantenedorDB.setFechaCreacion(date);
		Mantenedor obj = mantenedorService.save(mantenedorDB);
		return new ResponseEntity<Mantenedor>(obj, HttpStatus.OK);
		}else {
			return new ResponseEntity<Mantenedor>(mantenedor, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
