package com.Apiwow.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.Apiwow.entity.Personaje;
import com.Apiwow.entity.Servidor;
import com.Apiwow.entity.Usuario;

@Stateless

public class PersonajeBean {
	@PersistenceContext(unitName="ApiWow")
    EntityManager em;

@SuppressWarnings("unchecked")
public List<Personaje> devolverPersonaje (){
	Query q = em.createNamedQuery("Personaje.findAll");
	List<Personaje> resultados = q.getResultList();
	return resultados;
	
}





public void BorrarPj (String id) {
	Query q=em.createNamedQuery("Personaje.Delete");
	q.setParameter("id_personaje", Integer.parseInt(id));
	q.executeUpdate();
	
}

public void añadirPj (Personaje personaje) {
	
	em.persist(personaje);
}

public void updatePersonaje(Personaje personaje){      
	Query q = em.createQuery("UPDATE Personaje p SET p.class_ = :pj_class_ , p.level = :pj_level , p.name = :pj_name , p.race = :pj_race"
			+ " WHERE p.idpersonaje = :pj_id");
	q.setParameter("pj_id", personaje.getIdpersonaje());
	q.setParameter("pj_class_", personaje.getClass_());
	q.setParameter("pj_level", personaje.getLevel());
	q.setParameter("pj_name", personaje.getName());
	q.setParameter("pj_race", personaje.getRace());
	
	
	q.executeUpdate();	}	

}
