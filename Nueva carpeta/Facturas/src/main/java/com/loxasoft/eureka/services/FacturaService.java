package com.loxasoft.eureka.services;

import java.util.List;
import org.springframework.data.domain.Page;
import com.loxasoft.eureka.model.Factura;

public interface FacturaService {
	
	List<Factura> getAll();
	
	List<Factura> getById(long id);
	
	List<Factura> getByDate(String fecha);
	
	List<Factura> getByProduct(String producto);
	
	//Factura update(Factura factura);
	
	void delete(long id, String date);
	
	Page<Factura> getAllSortByDate(int page, int size);
}
