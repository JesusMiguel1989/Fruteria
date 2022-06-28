package com.practicasjunio2022.fruteria.repository;

import java.util.List;


import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.practicasjunio2022.fruteria.model.Fruta;


@RepositoryRestResource(collectionResourceRel = "fruta", path = "repositoryFruta")
//@Repository
public interface FrutaRepository extends PagingAndSortingRepository<Fruta, Long>{

	 List<Fruta> findByName(@Param("name") String name);
	 
	 @Query(value = "select f.cod_fruta from fruta f where f.name like ?1", nativeQuery = true)
	 List<Fruta> findLikeName(String name);
	 
	 @Query(value = "select f.cod_fruta from Fruta f where f.name like :name", nativeQuery = true)
	 List<Fruta> findLikeName2(@Param("name") String name);
	 
	 @Modifying
	 @Query(value = "update Fruta f set f.fruta = ?2 where f.cod_fruta = ?1", nativeQuery = true)
	 int updateName(long id,  String name);
	 
	 
	 List<Fruta> findAll(Sort sort);
	 
	 
}
