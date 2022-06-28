package com.loxasoft.eureka.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.loxasoft.eureka.entity.Factura;

//RepositoryRestResource(collectionResourceRel = "facturas", path = "repositoryFacturas")
@Repository
public interface FacturaRepository extends CrudRepository<Factura, Long>{
	
	 List<Factura> findAll(Sort sort);
	 
	 @Query(value = "select f.id from factura f where f.id like ?1", nativeQuery = true)
	 List<Factura> findByNumberInvoice (@Param("id") long id);
	 
}
