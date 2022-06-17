package com.practicasjunio2022.fruteria.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.practicasjunio2022.fruteria.model.Proveedor;

public interface ProvService {

	List<Proveedor> getAll();
	
	Proveedor getById(long id);
	
	List<Proveedor> getByName(String name);
	
	Proveedor update(Proveedor p);
	
	void delete(long id);
	
	Page<Proveedor> getAllSortByname(int page, int size);
	
}
