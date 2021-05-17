package com.pruebatecnica.springboot.backend.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pruebatecnica.springboot.backend.api.controller.MantenedorController;
import com.pruebatecnica.springboot.backend.api.dto.Mantenedor;
import com.pruebatecnica.springboot.backend.api.service.MantenedorServiceImpl;

@SpringBootTest
class SpringbootBackendPruebaTecnicaApplicationTests {

	@InjectMocks
	MantenedorController mantenedorService;
	
	@Mock
	MantenedorServiceImpl mantenedorServiceImpl;
	
	
	
	@Test
	final void detalleTest() {
		int valor = 1;
		Mantenedor mantenedor = new Mantenedor();
		mantenedor.setIdentificacion(1);
		mantenedor.setDescripcion("Felipe");
		mantenedor.setVigente(true);
		Mockito.when(mantenedorService.detalle(valor)).thenReturn(mantenedor);
		
		
	}

}
