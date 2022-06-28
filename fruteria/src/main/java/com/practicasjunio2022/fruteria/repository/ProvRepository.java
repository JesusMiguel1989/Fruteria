package com.practicasjunio2022.fruteria.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.practicasjunio2022.fruteria.model.Proveedor;

@RepositoryRestResource(collectionResourceRel = "proveedores", path = "repositoryProveedores")
//@Repository
public interface ProvRepository extends PagingAndSortingRepository<Proveedor, Long>{

	 List<Proveedor> findByName(@Param("name") String name);
	 
	 @Query(value = "select p.id from proveedores p where p.name like ?1", nativeQuery = true)
	 List<Proveedor> findLikeName(String name);
	 
	 @Query(value = "select p.id from proveedores p where p.name like :name", nativeQuery = true)
	 List<Proveedor> findLikeName2(@Param("name") String name);
	 
	 @Modifying
	 @Query(value = "update proveedores p set p.user = ?2 where p.id = ?1", nativeQuery = true)
	 int updateName(long id,  String name);
	 
	 
	 List<Proveedor> findAll(Sort sort);

	 List<Proveedor> findByAddres(String addres);
	 
	 
}
