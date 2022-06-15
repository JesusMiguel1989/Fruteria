package com.practicasjunio2022.fruteria.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="usuarios")

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4806920792104736164L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id=0;
	private String name="sergio";
	/*
	public User (String name, long id) {
		this.id=id;
		this.name=name;
	}
	*/
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
}
