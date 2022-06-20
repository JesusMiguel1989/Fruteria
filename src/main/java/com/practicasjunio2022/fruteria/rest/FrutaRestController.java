package com.practicasjunio2022.fruteria.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practicasjunio2022.fruteria.model.Fruta;
import com.practicasjunio2022.fruteria.services.FrutaService;

@RestController
@RequestMapping("/fruta")
public class FrutaRestController {

	@Autowired
	private FrutaService FrutaService;

	@GetMapping("/all")
	public List<Fruta> getAll() {
		return this.FrutaService.getAll();
	}

	@GetMapping("/all2/{page}/{tam}")
	public Page<Fruta> getAll2(@PathVariable("page") int page, @PathVariable("tam") int tam) {
		return this.FrutaService.getAllSortByname(page, tam);
	}

	@GetMapping("/{cod_fruta}")
	public Fruta getFruta(@PathVariable("cod_fruta") long cod_fruta) {
		return this.FrutaService.getBycod_fruta(cod_fruta);
	}

	@DeleteMapping("/borrar/{cod_fruta}")
	public void deleteFruta(@PathVariable("cod_fruta") long cod_fruta) {
		this.FrutaService.delete(cod_fruta);
	}

	@DeleteMapping
	public ResponseEntity<Void> customDeleteFruta(@RequestParam(name = "cod_fruta", required = false) Long cod_fruta,
			@RequestParam(name = "name", required = false) String name) {
		if (cod_fruta == null && name == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		if (cod_fruta != null) {
			this.FrutaService.delete(cod_fruta);
		} else {
			List<Fruta> l = this.FrutaService.getByName(name);
			l.forEach(x -> this.FrutaService.delete(x.getcod_fruta()));
		}
		return ResponseEntity.ok().build();
	}

	@PostMapping("/{id}")
	public Fruta updateUser(@PathVariable("id") long cod_fruta, @RequestBody Fruta user) {
		Fruta frutaDb = this.FrutaService.getBycod_fruta(cod_fruta);
		if (frutaDb != null) {
			frutaDb.setName(user.getName());
			frutaDb = this.FrutaService.update(frutaDb);
		}
		return frutaDb;
	}

	@PostMapping("/name/{name}")
	public List<Fruta> updateFruta(@PathVariable("name") String name, @RequestBody final Fruta fruta) {
		List<Fruta> listFrutaDb = this.FrutaService.getByName(name);
		if (!listFrutaDb.isEmpty()) {
			listFrutaDb.forEach(x -> {
				x.setName(fruta.getName());
				this.FrutaService.update(x);
			});
		}
		return listFrutaDb;
	}

	@PostMapping
	public List<Fruta> updateByNameFruta(@RequestParam("name") String name,
			@RequestBody(required = true) final Fruta fruta) {
		List<Fruta> listFrutaDb = this.FrutaService.getByName(name);
		if (!listFrutaDb.isEmpty()) {
			listFrutaDb.forEach(x -> {
				x.setName(fruta.getName());
				this.FrutaService.update(x);
			});
		}
		return listFrutaDb;
	}
	
	@PostMapping("/nuevo")
	private int SaveFruta(@RequestBody Fruta f) {
		FrutaService.update(f);
		return (int) f.getcod_fruta();
	}
	
	@PatchMapping("/modificar")
	private void modifyFruta(@RequestBody Fruta f) {
		FrutaService.update(f);
		
	}

}
