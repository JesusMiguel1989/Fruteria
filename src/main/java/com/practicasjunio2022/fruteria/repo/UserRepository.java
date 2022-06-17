package com.practicasjunio2022.fruteria.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practicasjunio2022.fruteria.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	List<User> findByName(String name);
	/*
	@Query(value = "select * from Users :u", nativeQuery = true)
	User findByOtraCosa( String h)
*/
}
