package com.practicasjunio2022.fruteria.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.practicasjunio2022.fruteria.model.Proveedor;
import com.practicasjunio2022.fruteria.repository.ProvRepository;
import com.practicasjunio2022.fruteria.services.ProvService;

@Component
//@Service
public class ProvServiceImpl implements ProvService {

	//@Qualifier(value = "nombre")
	@Autowired
	private ProvRepository provRepo;

	@Override
	public List<Proveedor> getAll() {
		return (List<Proveedor>) this.provRepo.findAll();
	}
	
	@Override
	public Page<Proveedor> getAllSortByname(int page, int size) {
		return this.provRepo.findAll(PageRequest.of(page, size, Sort.by("id")));
	}

	@Override
	public Proveedor getById(long id) {
		Optional<Proveedor> ou = this.provRepo.findById(id);
		return ou.isPresent() ? ou.get() : null;
	}

	@Override
	public List<Proveedor> getByName(String name) {
		List<Proveedor> list = this.provRepo.findByName(name);
		if(list.isEmpty()) {
			list = this.provRepo.findLikeName(name);
		}
		return list;
	}
	@Override
	public List<Proveedor> getByAddres(String addres) {
		List<Proveedor> list = this.provRepo.findByAddres(addres);
		if(list.isEmpty()) {
			list = this.provRepo.findLikeName(addres);
		}
		return list;
	}

	@Override
	public Proveedor update(Proveedor p) {
		return this.provRepo.save(p);
	}

	@Override
	public void delete(long id) {
		this.provRepo.deleteById(id);
	}

}
