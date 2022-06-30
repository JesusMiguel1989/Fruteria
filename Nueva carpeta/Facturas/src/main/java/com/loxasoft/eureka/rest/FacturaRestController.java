package com.loxasoft.eureka.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.loxasoft.eureka.model.Factura;
import com.loxasoft.eureka.services.FacturaService;

@RestController
@RequestMapping("/facturas")
public class FacturaRestController {

		@Autowired(required=true)
		private FacturaService facturaService;

		@GetMapping("/all")
		public List<Factura> getAll() {
			return this.facturaService.getAll();
		}

		@GetMapping("/all2/{page}/{tam}")
		public Page<Factura> getAll2(@PathVariable("page") int page, @PathVariable("tam") int tam) {
			return this.facturaService.getAllSortByDate(page, tam);
		}

		@GetMapping("/{id}")
		public List<Factura> getFactura(@PathVariable("id") long id) {
			return this.facturaService.getById(id);
		}

		@DeleteMapping("/{id}/{date}")
		public void deleteFactura(@PathVariable("id") long id, @PathVariable("date") String date) {
			this.facturaService.delete(id,date);
		}

		@DeleteMapping
		public ResponseEntity<Void> customDeleteFactura(@RequestParam(name = "id", required = false) Long id,
				@RequestParam(name = "date", required = false) String date) {
			if (id == null && date == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			if (id != null) {
				this.facturaService.delete(id, date);
			} else {
				List<Factura> l = this.facturaService.getByDate(date);
				l.forEach(x -> this.facturaService.delete(x.getIdUsuarioFact(),x.getFechaFact()));
			}
			return ResponseEntity.ok().build();
		}

		/*
		@PatchMapping("/{id}")
		public Factura updateactura(@PathVariable("id") long id, @RequestBody Factura user) {
			Factura userDb = this.facturaService.getById(id);
			if (userDb != null) {
				userDb.setName(user.getName());
				userDb = this.facturaService.update(userDb);
			}
			return userDb;
		}

		@PatchMapping("/name/{name}")
		public List<Factura> updateFactura(@PathVariable("name") String name, @RequestBody final Factura user) {
			List<Factura> listUserDb = this.facturaService.getByName(name);
			if (!listUserDb.isEmpty()) {
				listUserDb.forEach(x -> {
					x.setName(user.getName());
					this.facturaService.update(x);
				});
			}
			return listUserDb;
		}
		
		
		@PatchMapping
		public List<Factura> updateByNameFactura(@RequestParam("name") String name,
				@RequestBody(required = true) final Factura user) {
			List<Factura> listUserDb = this.facturaService.getByName(name);
			if (!listUserDb.isEmpty()) {
				listUserDb.forEach(x -> {
					x.setName(user.getName());
					this.facturaService.update(x);
				});
			}
			return listUserDb;
		}
		*/
}
