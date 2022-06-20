package com.practicasjunio2022.fruteria.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.practicasjunio2022.fruteria.model.Fruta;
import com.practicasjunio2022.fruteria.model.User;

public interface FrutaService {

	List<Fruta> getAll();
	
	Fruta getBycod_fruta(long cod_fruta);
	
	List<Fruta> getByName(String name);
	
	Fruta update(Fruta fruta);
	
	void delete(long id);
	
	Page<Fruta> getAllSortByname(int page, int size);
	
}
