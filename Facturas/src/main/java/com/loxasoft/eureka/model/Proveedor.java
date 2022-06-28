package com.loxasoft.eureka.model;



import lombok.Data;

@Data
public class Proveedor{

	
	private long id_prov;


	
	private String name;
	

	
	private String addres;



	public Proveedor() {

	}



	public long getId_prov() {
		return id_prov;
	}



	public void setId_prov(long id_prov) {
		this.id_prov = id_prov;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddres() {
		return addres;
	}



	public void setAddres(String addres) {
		this.addres = addres;
	}



	@Override
	public String toString() {
		return "Proveedor [id_prov=" + id_prov + ", name=" + name + ", addres=" + addres + "]";
	}
	
	
	
}
