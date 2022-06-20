package com.practicasjunio2022.fruteria.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Fruteria")
public class Fruta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9091892231815355962L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cod_fruta;
	
	@Column(name="name")
	private String name;
	@Column(name="family")
	private String family;
	
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column
//	private Date date;
	
//	@Transient
//	private String name2;

	public long getcod_fruta() {
		return cod_fruta;
	}

	public void setcod_fruta(long cod_fruta) {
		this.cod_fruta = cod_fruta;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getfamily() {
		return family;
	}
	public void setfamilia(String family) {
		this.family=family;
	}
}
