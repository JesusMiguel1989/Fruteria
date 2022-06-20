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

import com.practicasjunio2022.fruteria.model.User;
import com.practicasjunio2022.fruteria.services.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {

	@Autowired
	private UserService userService;

	@GetMapping("/all")
	public List<User> getAll() {
		return this.userService.getAll();
	}

	@GetMapping("/all2/{page}/{tam}")
	public Page<User> getAll2(@PathVariable("page") int page, @PathVariable("tam") int tam) {
		return this.userService.getAllSortByname(page, tam);
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") long id) {
		return this.userService.getById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		this.userService.delete(id);
	}

	@DeleteMapping
	public ResponseEntity<Void> customDeleteUser(@RequestParam(name = "id", required = false) Long id,
			@RequestParam(name = "name", required = false) String name) {
		if (id == null && name == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		if (id != null) {
			this.userService.delete(id);
		} else {
			List<User> l = this.userService.getByName(name);
			l.forEach(x -> this.userService.delete(x.getId()));
		}
		return ResponseEntity.ok().build();
	}

	@PatchMapping("/{id}")
	public User updateUser(@PathVariable("id") long id, @RequestBody User user) {
		User userDb = this.userService.getById(id);
		if (userDb != null) {
			userDb.setName(user.getName());
			userDb = this.userService.update(userDb);
		}
		return userDb;
	}

	@PatchMapping("/name/{name}")
	public List<User> updateUser(@PathVariable("name") String name, @RequestBody final User user) {
		List<User> listUserDb = this.userService.getByName(name);
		if (!listUserDb.isEmpty()) {
			listUserDb.forEach(x -> {
				x.setName(user.getName());
				this.userService.update(x);
			});
		}
		return listUserDb;
	}

	@PatchMapping
	public List<User> updateByNameUser(@RequestParam("name") String name,
			@RequestBody(required = true) final User user) {
		List<User> listUserDb = this.userService.getByName(name);
		if (!listUserDb.isEmpty()) {
			listUserDb.forEach(x -> {
				x.setName(user.getName());
				this.userService.update(x);
			});
		}
		return listUserDb;
	}

}
