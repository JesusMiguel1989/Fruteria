package com.practicasjunio2022.fruteria.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "VERDURAS")
public class Verduras implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9091892231815355962L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codVerdura;

	@Column(name="name")
	private String name;
	
	@Column(name="familia")
	private String familia;
	
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column
//	private Date date;
	
//	@Transient
//	private String name2;

	public long getCodVerdura() {
		return codVerdura;
	}

	public void setCodVerdura(long codVerdura) {
		this.codVerdura = codVerdura;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}
}
