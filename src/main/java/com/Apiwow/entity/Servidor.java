package com.Apiwow.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the servidor database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Servidor.findAll", query="SELECT s FROM Servidor s"),
	@NamedQuery(name="Servidor.Delete", query ="Delete from Servidor p where p.idservidor = :id_servidor"),
	@NamedQuery(name="Servidor.findpj", query ="Select p from Servidor p where p.idservidor = :id_servidor")})

public class Servidor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idservidor;

	private int capacidad;

	private String name;

	private String region;
	
	private String img;

	//bi-directional many-to-many association to Personaje
	
	@ManyToMany(mappedBy="servidors", fetch=FetchType.EAGER)
	private List<Personaje> personajes;
	
	public Servidor() {
	}

	public String getimg() {
		return this.img;
	}
	
	public void setimg(String img) {
		this.img = img;
	}
	
	public int getIdservidor() {
		return this.idservidor;
	}

	public void setIdservidor(int idservidor) {
		this.idservidor = idservidor;
	}

	public int getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public List<Personaje> getPersonajes() {
		return this.personajes;
	}

	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}

}