package com.practicasjunio2022.fruteria.services;

import java.util.List;
import org.springframework.data.domain.Page;
import com.practicasjunio2022.fruteria.model.Verduras;

public interface VerdurasService {

	List<Verduras> getAll();
	
	Verduras getByCodVerdura(long codVerdura);
	
	List<Verduras> getByName(String name);
	
	Verduras update(Verduras veruras);
	
	void delete(long codVerdura);
	
	Page<Verduras> getAllSortByname(int page, int size);
}
