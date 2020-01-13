package com.Apiwow.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.Apiwow.entity.Personaje;
import com.Apiwow.entity.Usuario;

@Stateless
public class UsuarioBean {
	
	 @PersistenceContext(unitName="ApiWow")
	    EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Usuario> devolverUsuarios (){
		Query q = em.createNamedQuery("Usuario.findAll");
		List<Usuario> resultados = q.getResultList();
		return resultados;
		
	}
	
	public Usuario buscarusuario(String id) {
		Query q = em.createNamedQuery("Usuario.findbyid");
		q.setParameter("usuarioid", Integer.parseInt(id));
		Usuario resultado = (Usuario) q.getSingleResult();
		return resultado;
		
	}
	
	public void borrarusuario(String id) {
		Query q = em.createNamedQuery("Usuario.Delete");
		q.setParameter("id_usuario", Integer.parseInt(id));
		q.executeUpdate();
		
	}
	
	public void anadirUsuario (Usuario usuario) {
		
		em.persist(usuario);
	}
	
	public void updateUsuario(Usuario usuario){      
		Query q = em.createQuery("UPDATE Usuario p SET p.correo = :user_correo, p.tag = :user_tag WHERE p.id = :user_id");
		q.setParameter("user_id", usuario.getIdusuario());
		q.setParameter("user_correo", usuario.getCorreo());
		q.setParameter("user_tag", usuario.getTag());
		
		
		q.executeUpdate();		
    }

}

