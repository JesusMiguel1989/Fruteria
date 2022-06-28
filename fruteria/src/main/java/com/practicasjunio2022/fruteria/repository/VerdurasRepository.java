package com.practicasjunio2022.fruteria.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.practicasjunio2022.fruteria.model.Verduras;

@RepositoryRestResource(collectionResourceRel = "verduras", path = "repositoryVerduras")
//@Repository
public interface VerdurasRepository extends PagingAndSortingRepository<Verduras, Long>{

	 List<Verduras> findByName(@Param("name") String name);
	 
	 @Query(value = "select v.codVerdura from Verduras v where v.name like ?1", nativeQuery = true)
	 List<Verduras> findLikeName(String name);
	 
	 @Query(value = "select v.codVerdura from Verduras v where v.name like :name", nativeQuery = true)
	 List<Verduras> findLikeName2(@Param("name") String name);
	 
	 @Modifying
	 @Query(value = "update Verduras v set v.name = ?2 where v.codVerdura = ?1", nativeQuery = true)
	 int updateName(long codVerdura,  String name);
	 
	 List<Verduras> findAll(Sort sort);
}
