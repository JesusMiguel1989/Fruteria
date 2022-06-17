package com.practicasjunio2022.fruteria.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "proveedores")
public class Proveedor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID=1L ;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_prov;

	@Column
	private String name;
	private String addres;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column
//	private Date date;
	
//	@Transient
//	private String name2;

	
}
