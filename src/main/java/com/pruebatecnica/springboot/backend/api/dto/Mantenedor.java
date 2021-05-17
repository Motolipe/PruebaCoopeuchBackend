package com.pruebatecnica.springboot.backend.api.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
/*
 * @author Felipe Aliaga
 */
@Entity
@Table(name = "mantenedor")
@Getter
@Setter
public class Mantenedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int identificacion;
	private String descripcion;
	private boolean vigente;
	
	@Column(name = "fecha_creacion")
	@DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	

}
