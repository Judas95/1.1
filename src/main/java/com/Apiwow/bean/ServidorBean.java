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
public class ServidorBean {
	@PersistenceContext(unitName="ApiWow")
    EntityManager em;

@SuppressWarnings("unchecked")
public List<Servidor> devolverServidor (){
	Query q = em.createNamedQuery("Servidor.findAll");
	List<Servidor> resultados = q.getResultList();
	return resultados;
	
}



public Servidor devolverpersonajeservidor (String id ){
	Query q = em.createNamedQuery("Servidor.findpj");
	q.setParameter("id_servidor", Integer.parseInt(id));
	Servidor resultados = (Servidor) q.getSingleResult();
	
	return resultados;
	
}



public void BorrarServidor (String id) {
	Query q=em.createNamedQuery("Servidor.Delete");
	q.setParameter("id_servidor", Integer.parseInt(id));
	q.executeUpdate();
	
}

public void anadirServidor (Servidor servidor) {
	
	em.persist(servidor);
	

}

public void updateServidor(Servidor servidor){      
	Query q = em.createQuery("UPDATE Servidor p SET p.capacidad = :server_capacidad, p.name = :server_name , p.region = : server_region"
			+ " WHERE p.idservidor = :server_id");
	q.setParameter("server_id", servidor.getIdservidor());
	q.setParameter("server_capacidad", servidor.getCapacidad());
	q.setParameter("server_name", servidor.getName());
	q.setParameter("server_region", servidor.getRegion());
	
	
	q.executeUpdate();	}	
}