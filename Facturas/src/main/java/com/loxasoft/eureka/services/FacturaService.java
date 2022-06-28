package com.loxasoft.eureka.services;

import java.util.List;
import com.loxasoft.eureka.entity.Factura;
import com.loxasoft.eureka.model.Envios;


public interface FacturaService {
	
	 	public List<Factura> findFacturaAll();

	    public Factura createFactura(Factura Factura);
	    public Factura updateFactura(Factura Factura);
	    public Factura deleteFactura(Factura Factura);
	    public Factura getFactura(Long id);
		List<Factura> findAllEnvios();


}
