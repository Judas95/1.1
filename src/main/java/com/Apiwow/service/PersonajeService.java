package com.Apiwow.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.Apiwow.bean.PersonajeBean;
import com.Apiwow.bean.UsuarioBean;
import com.Apiwow.entity.Personaje;
import com.Apiwow.entity.Servidor;
import com.Apiwow.entity.Usuario;

@Path("personajes")
public class PersonajeService {
	
	@EJB
	PersonajeBean personajebean;
	
	@EJB
	UsuarioBean usuariobean;
	
	private final String status = "{\"status\":\"ok\"}";
	
	@GET
    @Path("getPersonajes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Personaje> getUsuarioJSON() {
        List<Personaje> users = personajebean.devolverPersonaje();
        return users;
    }
	
	@DELETE
	@Path("deletePersonaje")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteShelter(
            @QueryParam("id")String id	            
			){
		personajebean.BorrarPj(id);
        return Response.status(200).entity(status).build();
	}
	
	@POST
	@Path("anadirPersonaje")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response anadirPersonaje (Personaje personaje, @QueryParam("id") String idusuario) {				
		personaje.setUsuario(usuariobean.buscarusuario(idusuario));
		personajebean.añadirPj(personaje);
		return Response.status(200).entity(personaje).build();
	}
	
	@PUT
	@Path("updatePersonaje")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePersonaje(Personaje personaje) {
		personajebean.updatePersonaje(personaje);
		return Response.status(200).entity(personaje).build();
	}
	
}

