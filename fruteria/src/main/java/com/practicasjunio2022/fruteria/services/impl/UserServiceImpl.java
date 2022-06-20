package com.practicasjunio2022.fruteria.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.practicasjunio2022.fruteria.model.User;
import com.practicasjunio2022.fruteria.repository.UserRepository;
import com.practicasjunio2022.fruteria.services.UserService;

@Component
//@Service
public class UserServiceImpl implements UserService {

	//@Qualifier(value = "nombre")
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> getAll() {
		return (List<User>) this.userRepo.findAll();
	}
	
	@Override
	public Page<User> getAllSortByname(int page, int size) {
		return this.userRepo.findAll(PageRequest.of(page, size, Sort.by("id")));
	}

	@Override
	public User getById(long id) {
		Optional<User> ou = this.userRepo.findById(id);
		return ou.isPresent() ? ou.get() : null;
	}

	@Override
	public List<User> getByName(String name) {
		List<User> listUsers = this.userRepo.findByName(name);
		if(listUsers.isEmpty()) {
			listUsers = this.userRepo.findLikeName(name);
		}
		return listUsers;
	}

	@Override
	public User update(User user) {
		return this.userRepo.save(user);
	}

	@Override
	public void delete(long id) {
		this.userRepo.deleteById(id);
	}

}
