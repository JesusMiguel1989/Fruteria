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
import com.practicasjunio2022.fruteria.model.Verduras;
import com.practicasjunio2022.fruteria.services.VerdurasService;

@RestController
@RequestMapping("/verduras")
public class VerdurasRestController {

	@Autowired
	private VerdurasService verdurasService;

	@GetMapping("/all")
	public List<Verduras> getAll() {
		return this.verdurasService.getAll();
	}

	@GetMapping("/all2/{page}/{tam}")
	public Page<Verduras> getAll2(@PathVariable("page") int page, @PathVariable("tam") int tam) {
		return this.verdurasService.getAllSortByname(page, tam);
	}

	@GetMapping("/{codVerdura}")
	public Verduras getUser(@PathVariable("codVerdura") long codVerdura) {
		return this.verdurasService.getByCodVerdura(codVerdura);
	}

	@DeleteMapping("/{codVerdura}")
	public void deleteUser(@PathVariable("codVerdura") long codVerdura) {
		this.verdurasService.delete(codVerdura);
	}

	@DeleteMapping
	public ResponseEntity<Void> customDeleteVerduras(@RequestParam(name = "codVerdura", required = false) Long codVerdura,
			@RequestParam(name = "name", required = false) String name) {
		if (codVerdura == null && name == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		if (codVerdura != null) {
			this.verdurasService.delete(codVerdura);
		} else {
			List<Verduras> l = this.verdurasService.getByName(name);
			l.forEach(x -> this.verdurasService.delete(x.getCodVerdura()));
		}
		return ResponseEntity.ok().build();
	}

	@PatchMapping("/{codVerdura}")
	public Verduras updateVerduras(@PathVariable("codVerdura") long codVerdura, @RequestBody Verduras verduras) {
		Verduras verdurasDb = this.verdurasService.getByCodVerdura(codVerdura);
		if (verdurasDb != null) {
			verdurasDb.setName(verduras.getName());
			verdurasDb = this.verdurasService.update(verdurasDb);
		}
		return verdurasDb;
	}

	@PatchMapping("/name/{name}")
	public List<Verduras> updateVerduras(@PathVariable("name") String name, @RequestBody final Verduras verduras) {
		List<Verduras> listVerdurasDb = this.verdurasService.getByName(name);
		if (!listVerdurasDb.isEmpty()) {
			listVerdurasDb.forEach(x -> {
				x.setName(verduras.getName());
				this.verdurasService.update(x);
			});
		}
		return listVerdurasDb;
	}

	@PatchMapping
	public List<Verduras> updateByNameVerduras(@RequestParam("name") String name,
			@RequestBody(required = true) final Verduras verduras) {
		List<Verduras> listVerdurasDb = this.verdurasService.getByName(name);
		if (!listVerdurasDb.isEmpty()) {
			listVerdurasDb.forEach(x -> {
				x.setName(verduras.getName());
				this.verdurasService.update(x);
			});
		}
		return listVerdurasDb;
	}

	//Nuevo:
	
	@PostMapping
	public String saveVerduras(@RequestBody final Verduras verduras) {
		this.verdurasService.update(verduras);
		return "Insert Procesado";
	}
	
	@PutMapping("/{codVerdura}")
	public Verduras replaceVerduras(@PathVariable("codVerdura") long codVerdura, @RequestBody Verduras verduras) {
		Verduras verdurasDb = this.verdurasService.getByCodVerdura(codVerdura);
		if (verdurasDb != null) {
			verdurasDb.setName(verduras.getName());
			verdurasDb.setFamilia(verduras.getFamilia());
			verdurasDb = this.verdurasService.update(verdurasDb);
		}
		return verdurasDb;
	}
}
