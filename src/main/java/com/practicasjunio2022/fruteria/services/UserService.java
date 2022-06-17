package com.practicasjunio2022.fruteria.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.practicasjunio2022.fruteria.model.User;

public interface UserService {

	List<User> getAll();
	
	User getById(long id);
	
	List<User> getByName(String name);
	
	User update(User user);
	
	void delete(long id);
	
	Page<User> getAllSortByname(int page, int size);
	
}
