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
import com.practicasjunio2022.fruteria.model.Envios;
import com.practicasjunio2022.fruteria.services.EnviosService;

@RestController
@RequestMapping("/envios")
public class EnviosRestController {
	@Autowired
	private EnviosService enviosService;

	@GetMapping("/all")
	public List<Envios> getAll() {
		return this.enviosService.getAll();
	}

	@GetMapping("/all2/{page}/{tam}")
	public Page<Envios> getAll2(@PathVariable("page") int page, @PathVariable("tam") int tam) {
		return this.enviosService.getAllSortBydireccion(page, tam);
	}

	@GetMapping("/{id}")
	public Envios getEnvios(@PathVariable("id") long id) {
		return this.enviosService.getById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteEnvios(@PathVariable("id") long id) {
		this.enviosService.delete(id);
	}

	@DeleteMapping
	public ResponseEntity<Void> customDeleteEnvios(@RequestParam(name = "id", required = false) Long id,
			@RequestParam(name = "Direccion", required = false) String Direccion) {
		if (id == null && Direccion == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		if (id != null) {
			this.enviosService.delete(id);
		} else {
			List<Envios> l = this.enviosService.getBydireccion(Direccion);
			l.forEach(x -> this.enviosService.delete(x.getId()));
		}
		return ResponseEntity.ok().build();
	}

	@PatchMapping("/{id}")
	public Envios updateEnvios(@PathVariable("id") long id, @RequestBody Envios Envios) {
		Envios EnviosDb = this.enviosService.getById(id);
		if (EnviosDb != null) {
			EnviosDb.setDireccion(Envios.getDireccion());
			
			EnviosDb = this.enviosService.update(EnviosDb);
		}
		return EnviosDb;
	}

	@PatchMapping("/Direccion/{Direccion}")
	public List<Envios> updateEnvios(@PathVariable("Direccion") String Direccion, @RequestBody final Envios Envios) {
		List<Envios> listEnviosDb = this.enviosService.getBydireccion(Direccion);
		if (!listEnviosDb.isEmpty()) {
			listEnviosDb.forEach(x -> {
				x.setDireccion(Envios.getDireccion());
				this.enviosService.update(x);
			});
		}
		return listEnviosDb;
	}

	@PatchMapping
	public List<Envios> updateByDireccionEnvios(@RequestParam("Direccion") String Direccion,
			@RequestBody(required = true) final Envios Envios) {
		List<Envios> listEnviosDb = this.enviosService.getBydireccion(Direccion);
		if (!listEnviosDb.isEmpty()) {
			listEnviosDb.forEach(x -> {
				x.setDireccion(Envios.getDireccion());
				this.enviosService.update(x);
			});
		}
		return listEnviosDb;
	}
}
