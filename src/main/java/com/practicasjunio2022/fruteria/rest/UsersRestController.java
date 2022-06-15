package com.practicasjunio2022.fruteria.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/users")
public class UsersRestController {
	@RequestMapping(path = "/all")
	public void getUsers() {
		System.out.println("getusers funciona");
		
	}
}
