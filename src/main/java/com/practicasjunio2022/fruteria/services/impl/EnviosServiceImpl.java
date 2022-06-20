package com.practicasjunio2022.fruteria.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.practicasjunio2022.fruteria.model.Envios;
import com.practicasjunio2022.fruteria.repository.EnviosRepository;
import com.practicasjunio2022.fruteria.services.EnviosService;

public class EnviosServiceImpl  implements EnviosService{
	//@Qualifier(value = "nombre")
		@Autowired
		private EnviosRepository EnviosRepo;

		@Override
		public List<Envios> getAll() {
			return (List<Envios>) this.EnviosRepo.findAll();
		}
		
		@Override
		public Page<Envios> getAllSortBydireccion(int page, int size) {
			return this.EnviosRepo.findAll(PageRequest.of(page, size, Sort.by("id")));
		}

		@Override
		public Envios getById(long id) {
			Optional<Envios> ou = this.EnviosRepo.findById(id);
			return ou.isPresent() ? ou.get() : null;
		}

		@Override
		public List<Envios> getBydireccion(String name) {
			List<Envios> listEnvioss = this.EnviosRepo.findBydireccion(name);
			if(listEnvioss.isEmpty()) {
				listEnvioss = this.EnviosRepo.findLikedireccion(name);
			}
			return listEnvioss;
		}

		@Override
		public Envios update(Envios Envios) {
			return this.EnviosRepo.save(Envios);
		}

		@Override
		public void delete(long id) {
			this.EnviosRepo.deleteById(id);
		}
}
