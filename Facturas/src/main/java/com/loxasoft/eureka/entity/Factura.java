package com.loxasoft.eureka.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.loxasoft.eureka.model.Envios;
import com.loxasoft.eureka.model.Fruta;

//import org.springframework.data.annotation.Transient;

//import com.loxasoft.eureka.model.Fruta;


import lombok.Data;
@Data
@Entity
@Table
public class Factura{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	 
    @Column(name = "numero_factura")
    private long numberInvoice;
	
	@Column(name="fechaFact")
	private String fechaFact;
	@Transient
	private Envios producto;


	public Factura(Long id,  Envios producto) {

		this.id = id;
		this.setProducto(producto);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getFechaFact() {
		return fechaFact;
	}

	public void setFechaFact(String fechaFact) {
		this.fechaFact = fechaFact;
	}

	public Envios getProducto() {
		return producto;
	}

	public void setProducto(Envios producto) {
		this.producto = producto;
	}





	

    
}
