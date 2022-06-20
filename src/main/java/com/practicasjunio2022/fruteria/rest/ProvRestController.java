package com.practicasjunio2022.fruteria.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practicasjunio2022.fruteria.model.Proveedor;
import com.practicasjunio2022.fruteria.services.ProvService;

@RestController
@RequestMapping("/proveedores")
public class ProvRestController {

	@Autowired
	private ProvService provService;

	@GetMapping("/all")
	public List<Proveedor> getAll() {
		return this.provService.getAll();
	}

	@GetMapping("/all2/{page}/{tam}")
	public Page<Proveedor> getAll2(@PathVariable("page") int page, @PathVariable("tam") int tam) {
		return this.provService.getAllSortByname(page, tam);
	}

	@GetMapping("/{id}")
	public Proveedor getProv(@PathVariable("id") long id) {
		return this.provService.getById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteProv(@PathVariable("id") long id) {
		this.provService.delete(id);
	}

	@DeleteMapping
	public ResponseEntity<Void> customDeleteProv(@RequestParam(name = "id", required = false) Long id,
			@RequestParam(name = "name", required = false) String name) {
		if (id == null && name == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		if (id != null) {
			this.provService.delete(id);
		} else {
			List<Proveedor> l = this.provService.getByName(name);
			l.forEach(x -> this.provService.delete(x.getId_prov()));
		}
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public Proveedor updateProv(@PathVariable("id") long id, @RequestBody Proveedor p) {
		Proveedor ProvDb = this.provService.getById(id);
		if (ProvDb != null) {
			ProvDb.setName(p.getName());
			ProvDb = this.provService.update(ProvDb);
		}
		return ProvDb;
	}
	 @PostMapping("/nuevo")
	    private int saveProv(@RequestBody Proveedor p) {
	        provService.update(p);
	        return (int) p.getId_prov();
	    }
	

	@PostMapping("/name/{name}")
	public List<Proveedor> updateProv(@PathVariable("name") String name, @RequestBody final Proveedor p) {
		List<Proveedor> listProvDb = this.provService.getByName(name);
		if (!listProvDb.isEmpty()) {
			listProvDb.forEach(x -> {
				x.setName(p.getName());
				this.provService.update(x);
			});
		}
		return listProvDb;
	}

	@PostMapping
	public List<Proveedor> updateByNameUser(@RequestParam("name") String name,
			@RequestBody(required = true) final Proveedor p) {
		List<Proveedor> listProvDb = this.provService.getByName(name);
		if (!listProvDb.isEmpty()) {
			listProvDb.forEach(x -> {
				x.setName(p.getName());
				this.provService.update(x);
			});
		}
		return listProvDb;
	}

}
