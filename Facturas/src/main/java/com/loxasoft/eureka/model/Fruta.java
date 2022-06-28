package com.loxasoft.eureka.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Fruta{

	private long cod_fruta;

	private String name;

	private String family;

	public long getCod_fruta() {
		return cod_fruta;
	}

	public void setCod_fruta(long cod_fruta) {
		this.cod_fruta = cod_fruta;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	@Override
	public String toString() {
		return "Fruta [cod_fruta=" + cod_fruta + ", name=" + name + ", family=" + family + "]";
	}
	
}
