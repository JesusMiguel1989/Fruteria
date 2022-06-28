package com.loxasoft.eureka.model;

import lombok.Data;

@Data
public class Verduras{

	private long codVerdura;

	private String name;

	private String familia;

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

	@Override
	public String toString() {
		return "Verduras [codVerdura=" + codVerdura + ", name=" + name + ", familia=" + familia + "]";
	}
	
}
