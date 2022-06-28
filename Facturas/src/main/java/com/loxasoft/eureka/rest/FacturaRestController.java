package com.loxasoft.eureka.rest;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.loxasoft.eureka.entity.Factura;
import com.loxasoft.eureka.model.Envios;
import com.loxasoft.eureka.model.Fruta;
import com.loxasoft.eureka.model.Proveedor;
import com.loxasoft.eureka.model.User;
import com.loxasoft.eureka.model.Verduras;
import com.loxasoft.eureka.repository.FacturaRepository;
import com.loxasoft.eureka.services.FacturaService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping

public class FacturaRestController {

		@Autowired
		private FacturaService facturaService;
		
		@Autowired
		private RestTemplate clienteRest;


		@GetMapping("/all")
		public Iterable<Factura> getFactura() {

			return this.facturaService.findFacturaAll();
		}

		@GetMapping("/factura-GetDatos")
	      public String getFacturaEnvio2() {
			List<Proveedor> prov = Arrays.asList(clienteRest.getForObject("http://servicio-fruteria/fruteria/proveedores/all", Proveedor[].class));
			List<Envios> envios = Arrays.asList(clienteRest.getForObject("http://servicio-fruteria/fruteria/envios/all", Envios[].class));
			List<User> user = Arrays.asList(clienteRest.getForObject("http://servicio-fruteria/fruteria/users/all", User[].class));
			List<Fruta> fruta = Arrays.asList(clienteRest.getForObject("http://servicio-fruteria/fruteria/fruta/all", Fruta[].class));
			List<Verduras> verduras = Arrays.asList(clienteRest.getForObject("http://servicio-fruteria/fruteria/verduras/all", Verduras[].class));

			return prov + "\n"+ envios+ "\n"+ user+ "\n"+ fruta+ "\n"+ verduras;
	      }
	
	    
}
