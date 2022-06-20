package com.practicasjunio2022.fruteria.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import com.practicasjunio2022.fruteria.model.Verduras;
import com.practicasjunio2022.fruteria.repository.VerdurasRepository;
import com.practicasjunio2022.fruteria.services.VerdurasService;

@Component
//@Service
public class VerdurasServiceImpl implements VerdurasService {

	//@Qualifier(value = "name")
	@Autowired
	private VerdurasRepository verdurasRepo;

	@Override
	public List<Verduras> getAll() {
		return (List<Verduras>) this.verdurasRepo.findAll();
	}
	
	@Override
	public Page<Verduras> getAllSortByname(int page, int size) {
		return this.verdurasRepo.findAll(PageRequest.of(page, size, Sort.by("codVerdura")));
	}

	@Override
	public Verduras getByCodVerdura(long codVerdura) {
		Optional<Verduras> ou = this.verdurasRepo.findById(codVerdura);
		return ou.isPresent() ? ou.get() : null;
	}

	@Override
	public List<Verduras> getByName(String name) {
		List<Verduras> listVerduras = this.verdurasRepo.findByName(name);
		if(listVerduras.isEmpty()) {
			listVerduras = this.verdurasRepo.findLikeName(name);
		}
		return listVerduras;
	}

	@Override
	public Verduras update(Verduras verduras) {
		return this.verdurasRepo.save(verduras);
	}

	@Override
	public void delete(long codVerdura) {
		this.verdurasRepo.deleteById(codVerdura);
	}
}
