package com.practicasjunio2022.fruteria.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practicasjunio2022.fruteria.repo.UserRepository;

@RestController 
@RequestMapping("/users")
public class UsersRestController {
	
	@Autowired
	private UserRepository userRepository;
	//@RequestMapping(path = "%all", method = RequestMethod.POST)
	//@RequestMapping("/users/all")
	@GetMapping("/all")
	public String getUsers() {
		this.userRepository.
		//System.out.println("getusers funciona");
		return "getusers funciona";
	}
	
	@GetMapping("/get/{id}")
	public String getUserById(@PathVariable(name = "id") int id) {
		
		//System.out.println("getusers funciona");
		return "getUser funciona"+id;
	}
}
