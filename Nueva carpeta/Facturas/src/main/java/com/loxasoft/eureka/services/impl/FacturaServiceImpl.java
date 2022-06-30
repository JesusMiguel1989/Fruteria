package com.loxasoft.eureka.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.loxasoft.eureka.model.Factura;
import com.loxasoft.eureka.repository.FacturaRepository;
import com.loxasoft.eureka.services.FacturaService;

@Component
public class FacturaServiceImpl implements FacturaService{
	
	@Autowired
	private FacturaRepository facturaRepo;

	@Override
	public List<Factura> getAll() {
		return (List<Factura>) this.facturaRepo.findAll();
	}
	
	@Override
	public Page<Factura> getAllSortByDate(int page, int size) {
	return this.facturaRepo.findAll(PageRequest.of(page, size, Sort.by("idUsuarioFact")));
	}

	@Override
	public List<Factura> getById(long idUsuarioFact) {
		List<Factura> listFacturas = this.facturaRepo.findById(idUsuarioFact);
		return listFacturas;
	}

	@Override
	public List<Factura> getByDate(String fecha) {
		List<Factura> listFacturas = this.facturaRepo.findLikeDate(fecha);
		return listFacturas;
	}
	
	@Override
	public List<Factura> getByProduct(String producto) {
		List<Factura> listFacturas = this.facturaRepo.findLikeProduct(producto);
		return listFacturas;
	}

	//@Override
	//public Factura update(Factura user) {
	//	return this.facturaRepo.save(user);
	//}

	@Override
	public void delete(long id, String date) {
		this.facturaRepo.delete(id, date);
	}
}
