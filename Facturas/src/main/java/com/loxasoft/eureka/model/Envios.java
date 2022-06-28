package com.loxasoft.eureka.model;


import lombok.Data;

@Data
public class Envios{


	public Envios() {

	}

	private long id;

	private String direccion;

	private String fecha;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Envios [id=" + id + ", direccion=" + direccion + ", fecha=" + fecha + "]";
	}




}
