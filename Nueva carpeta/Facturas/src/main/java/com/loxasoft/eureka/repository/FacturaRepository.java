package com.loxasoft.eureka.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.loxasoft.eureka.model.Factura;

@Repository
public interface FacturaRepository extends PagingAndSortingRepository<Factura, Long>{
	List<Factura> findById(@Param("idUsuarioFact") long idUsuarioFact);
	 
	@Query(value = "select idUsuarioFact from factura where fechaFact like :fecha", nativeQuery = true)
	List<Factura> findLikeDate(@Param("fecha") String fecha);
	 
	@Query(value = "select idUsuarioFact from factura where producto like :prod", nativeQuery = true)
	List<Factura> findLikeProduct(@Param("prod") String prod);
	
	//@Modifying
	//@Query(value = "update User u set u.user = ?2 where u.id = ?1", nativeQuery = true)
	//int updateName(long id,  String name);
	
	List<Factura> findAll(Sort sort);
	
	@Modifying
	@Query(value = "delete facturas where idUsuarioFact = :id and fechaFact like :date", nativeQuery = true)
	void delete(@Param("id") long id, @Param("date") String date);
}
