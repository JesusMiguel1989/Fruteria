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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practicasjunio2022.fruteria.model.Proveedor;
import com.practicasjunio2022.fruteria.model.User;
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
	public Proveedor getUser(@PathVariable("id") long id) {
		return this.provService.getById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		this.provService.delete(id);
	}

	@DeleteMapping
	public ResponseEntity<Void> customDeleteUser(@RequestParam(name = "id", required = false) Long id,
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

	@PatchMapping("/{id}")
	public Proveedor updateUser(@PathVariable("id") long id, @RequestBody User user) {
		Proveedor userDb = this.provService.getById(id);
		if (userDb != null) {
			userDb.setName(user.getName());
			userDb = this.provService.update(userDb);
		}
		return userDb;
	}

	@PatchMapping("/name/{name}")
	public List<Proveedor> updateUser(@PathVariable("name") String name, @RequestBody final User user) {
		List<Proveedor> listUserDb = this.provService.getByName(name);
		if (!listUserDb.isEmpty()) {
			listUserDb.forEach(x -> {
				x.setName(user.getName());
				this.provService.update(x);
			});
		}
		return listUserDb;
	}

	@PatchMapping
	public List<Proveedor> updateByNameUser(@RequestParam("name") String name,
			@RequestBody(required = true) final User user) {
		List<Proveedor> listUserDb = this.provService.getByName(name);
		if (!listUserDb.isEmpty()) {
			listUserDb.forEach(x -> {
				x.setName(user.getName());
				this.provService.update(x);
			});
		}
		return listUserDb;
	}

}
