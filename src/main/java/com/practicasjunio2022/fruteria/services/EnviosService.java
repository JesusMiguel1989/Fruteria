package com.practicasjunio2022.fruteria.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.practicasjunio2022.fruteria.model.Envios;
@Service
public interface EnviosService {

	List<Envios> getAll();
	
	Envios getById(long id);
	
	List<Envios> getBydireccion(String direccion);
	
	Envios updateorsave(Envios Envios);
	
	void delete(long id);
	
	
	Page<Envios> getAllSortBydireccion(int page, int size);
	
}
