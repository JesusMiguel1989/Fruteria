package com.loxasoft.eureka.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "factura")
@Table
public class Factura implements Serializable{

	private static final long serialVersionUID = 9091892231815355962L;
	
	@Id
	@Column(name="idUsuarioFact")
	private long idUsuarioFact;
	
	@Column(name="fechaFact")
	private String fechaFact;
	
	@Column(name="producto")
	private String producto;

	public long getIdUsuarioFact() {
		return idUsuarioFact;
	}

	public void setIdUsuarioFact(long idUsuarioFact) {
		this.idUsuarioFact = idUsuarioFact;
	}

	public String getFechaFact() {
		return fechaFact;
	}

	public void setFechaFact(String fechaFact) {
		this.fechaFact = fechaFact;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}
}
