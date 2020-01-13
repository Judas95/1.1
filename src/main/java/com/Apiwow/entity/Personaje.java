package com.Apiwow.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the personaje database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Personaje.findAll", query="SELECT p FROM Personaje p"),
	@NamedQuery(name="Personaje.Delete", query ="Delete from Personaje p where p.idpersonaje = :id_personaje")
})


public class Personaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idpersonaje;

	@Column(name="class")
	private String class_;

	private String level;

	private String name;

	private String race;

	//bi-directional many-to-one association to Usuario
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="usuario_id_usuario")
	private Usuario usuario;

	//bi-directional many-to-many association to Servidor
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="personaje_servidor"
		, joinColumns={
			@JoinColumn(name="personaje_id_personaje")
			}
		, inverseJoinColumns={
			@JoinColumn(name="servidor_id_servidor")
			}
		)
	private List<Servidor> servidors;

	public Personaje() {
	}

	public int getIdpersonaje() {
		return this.idpersonaje;
	}

	public void setIdpersonaje(int idpersonaje) {
		this.idpersonaje = idpersonaje;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return this.race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Servidor> getServidors() {
		return this.servidors;
	}

	public void setServidors(List<Servidor> servidors) {
		this.servidors = servidors;
	}

}