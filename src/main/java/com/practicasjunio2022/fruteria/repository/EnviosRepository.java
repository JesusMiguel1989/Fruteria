package com.practicasjunio2022.fruteria.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.practicasjunio2022.fruteria.model.Envios;

@RepositoryRestResource(collectionResourceRel = "envios", path = "repositoryEnvios")
//@Repository
public interface EnviosRepository extends PagingAndSortingRepository<Envios, Long>{
 List<Envios> findBydireccion(@Param("direccion") String direccion);
	 
	 @Query(value = "select u.id from Envios u where u.direccion like ?1", nativeQuery = true)
	 List<Envios> findLikedireccion(String direccion);
	 
	 @Query(value = "select u.id from Envios u where u.direccion like :direccion", nativeQuery = true)
	 List<Envios> findLikedireccion2(@Param("direccion") String direccion);
	 
	 @Modifying
	 @Query(value = "update Envios u set u.Envios = ?2 where u.id = ?1", nativeQuery = true)
	 int updatedireccion(long id,  String direccion, String fecha);
	 
	 
	 List<Envios> findAll(Sort sort);
	 
}
