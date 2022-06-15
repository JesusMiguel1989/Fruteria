package com.practicasjunio2022.fruteria.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practicasjunio2022.fruteria.model.User;
import com.practicasjunio2022.fruteria.repo.UserRepository;

@RestController 
@RequestMapping("/users")
public class UsersRestController  {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/all")
	public String getUsers() {
		

		return userRepository.findAll().toString();
	}
	
	@GetMapping("/get/{id}")
	public String getUserById(@PathVariable(name = "id") int id) {
		

		return userRepository.findById((long) id).toString();
		
	}/*
	@RequestMapping(value="/nuevo/{nombre}", method=RequestMethod.GET)
	public String nuevo(ModelMap mp, String nombre){
	    //mp.put("", new User());
		User x =new User();
	    userRepository.save(x);
	    return mp.toString();
	}
	*/
	@RequestMapping("/crear")
	public String crear( BindingResult bindingResult, ModelMap mp){
		User x =new User();
	    if(bindingResult.hasErrors()){
	                mp.put("usuarios", userRepository.findAll());
	        return "/crud/lista";
	    }else{
	    	userRepository.save(x);
	        mp.put("usuario", x);
	        return "crud/creado";
	    }
	}
}
