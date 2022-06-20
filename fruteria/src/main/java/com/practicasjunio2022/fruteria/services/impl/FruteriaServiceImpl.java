package com.practicasjunio2022.fruteria.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.practicasjunio2022.fruteria.model.Fruta;
import com.practicasjunio2022.fruteria.model.User;
import com.practicasjunio2022.fruteria.repository.FrutaRepository;
import com.practicasjunio2022.fruteria.repository.UserRepository;
import com.practicasjunio2022.fruteria.services.FrutaService;
import com.practicasjunio2022.fruteria.services.UserService;

@Component
//@Service
public class FruteriaServiceImpl implements FrutaService {

	//@Qualifier(value = "nombre")
	@Autowired
	private FrutaRepository frutaRepo;

	@Override
	public List<Fruta> getAll() {
		return (List<Fruta>) this.frutaRepo.findAll();
	}
	
	@Override
	public Page<Fruta> getAllSortByname(int page, int size) {
		return this.frutaRepo.findAll(PageRequest.of(page, size, Sort.by("id")));
	}

	@Override
	public Fruta getBycod_fruta(long cod_fruta) {
		Optional<Fruta> ou = this.frutaRepo.findById(cod_fruta);
		return ou.isPresent() ? ou.get() : null;
	}

	@Override
	public List<Fruta> getByName(String name) {
		List<Fruta> listFruta = this.frutaRepo.findByName(name);
		if(listFruta.isEmpty()) {
			listFruta = this.frutaRepo.findLikeName(name);
		}
		return listFruta;
	}

	@Override
	public Fruta update(Fruta fruta) {
		return this.frutaRepo.save(fruta);
	}

	@Override
	public void delete(long cod_fruta) {
		this.frutaRepo.deleteById(cod_fruta);
	}

}
