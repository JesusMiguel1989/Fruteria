package com.loxasoft.eureka.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.loxasoft.eureka.entity.Factura;
import com.loxasoft.eureka.model.Envios;
import com.loxasoft.eureka.repository.FacturaRepository;
import com.loxasoft.eureka.services.FacturaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FacturaServiceImpl implements FacturaService{
	
	@Autowired
	private FacturaRepository facturaRepo;
	@Autowired
	private RestTemplate clienteRest;


	@Override
	public List<Factura> findFacturaAll() {
		 return  (List<Factura>) facturaRepo.findAll();
	}

    @Override
    public Factura createFactura(Factura factura) {
    	
        return null;
    }

	@Override
	public Factura updateFactura(Factura Factura) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Factura deleteFactura(Factura Factura) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Factura getFactura(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Factura> findAllEnvios() {
		List<Envios> envio = Arrays.asList(clienteRest.getForObject("http://localhost:8080/fruteria/envios/all", Envios[].class));
		
		return envio.stream().map(p -> new Factura((long)1, p)).collect(Collectors.toList());
	}

}
