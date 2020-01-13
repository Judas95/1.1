package com.Apiwow.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQueries ({@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u"),
	@NamedQuery(name="Usuario.findbyid", query = "Select u From Usuario u Where u.idusuario = :usuarioid "),
	@NamedQuery(name="Usuario.Delete",query="Delete from Usuario p where p.idusuario = :id_usuario")})

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idusuario;

	private String correo;

	private String tag;

	//bi-directional many-to-one association to Personaje
	
	@OneToMany(mappedBy="usuario",fetch=FetchType.EAGER)
	private List<Personaje> personajes;

	public Usuario() {
	}

	public int getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public List<Personaje> getPersonajes() {
		return this.personajes;
	}

	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}

	public Personaje addPersonaje(Personaje personaje) {
		getPersonajes().add(personaje);
		personaje.setUsuario(this);

		return personaje;
	}

	public Personaje removePersonaje(Personaje personaje) {
		getPersonajes().remove(personaje);
		personaje.setUsuario(null);

		return personaje;
	}

}