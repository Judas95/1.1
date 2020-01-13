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
import com.Apiwow.bean.ServidorBean;
import com.Apiwow.entity.Personaje;
import com.Apiwow.entity.Servidor;
import com.Apiwow.entity.Usuario;

@Path("servidor")
public class ServidorService {
	@EJB
	ServidorBean servidorbean;
	
	private final String status = "{\"status\":\"ok\"}";
	
	@GET
    @Path("getServidores")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Servidor> getUsuarioJSON() {
        List<Servidor> users = servidorbean.devolverServidor();
        return users;
    }
	
	@DELETE
	@Path("deleteservidor")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteServidor(
            @QueryParam("id")String id	            
			){
		servidorbean.BorrarServidor(id);
        return Response.status(200).entity(status).build();
	}
	
	@POST
	@Path("anadirServidor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response anadirUsuario (Servidor servidor) {				
	
		servidorbean.anadirServidor(servidor);
		return Response.status(200).entity(servidor).build();
	}
	
	@PUT
	@Path("updateServidor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateServidor(Servidor servidor) {
		servidorbean.updateServidor(servidor);
		return Response.status(200).entity(servidor).build();
	}
	
	@GET
	@Path("getpersonajesbyid")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Servidor getPersonajebyidJSON(
			@QueryParam("id")String id	            
			){
		 
        Servidor users = (Servidor) servidorbean.devolverpersonajeservidor(id);
        return users;
    }

}
