package com.practicasjunio2022.fruteria.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class UsersRestController {
	@RequestMapping(path = "%all", method = RequestMethod.GET)
	public void getUsers() {
		
		System.out.println("getusers funciona");
		
	}
}
