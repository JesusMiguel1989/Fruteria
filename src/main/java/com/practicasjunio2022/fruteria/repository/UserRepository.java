package com.practicasjunio2022.fruteria.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.practicasjunio2022.fruteria.model.User;

@RepositoryRestResource(collectionResourceRel = "users", path = "repositoryUsers")
//@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>{

	 List<User> findByName(@Param("name") String name);
	 
	 @Query(value = "select u.id from User u where u.name like ?1", nativeQuery = true)
	 List<User> findLikeName(String name);
	 
	 @Query(value = "select u.id from User u where u.name like :name", nativeQuery = true)
	 List<User> findLikeName2(@Param("name") String name);
	 
	 @Modifying
	 @Query(value = "update User u set u.user = ?2 where u.id = ?1", nativeQuery = true)
	 int updateName(long id,  String name);
	 
	 
	 List<User> findAll(Sort sort);
	 
	 
}
