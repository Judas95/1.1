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

import com.Apiwow.bean.UsuarioBean;
import com.Apiwow.entity.Personaje;
import com.Apiwow.entity.Usuario;



@Path("usuario")
public class UsuarioService {
	@EJB
	UsuarioBean usuariobean;
	
	private final String status = "{\"status\":\"ok\"}";
	
	@GET
    @Path("getUsuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getUsuarioJSON() {
        List<Usuario> users = usuariobean.devolverUsuarios();
        return users;
    }
	
	@DELETE
	@Path("deleteUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUsuario(
            @QueryParam("id")String id	            
			){
		usuariobean.borrarusuario(id);
        return Response.status(200).entity(status).build();
	}
	
	@POST
	@Path("anadirUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response anadirUsuario (Usuario usuario) {				
	
		usuariobean.anadirUsuario(usuario);
		return Response.status(200).entity(usuario).build();
	}
	
	@PUT
	@Path("updateUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUsuario(Usuario usuario) {
		usuariobean.updateUsuario(usuario);
		return Response.status(200).entity(usuario).build();
	}

}
