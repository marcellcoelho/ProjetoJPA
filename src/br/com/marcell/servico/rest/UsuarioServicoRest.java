package br.com.marcell.servico.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.marcell.entidade.Usuario;
import br.com.marcell.servico.UsuarioServico;

@Path("/usuario")
public class UsuarioServicoRest {

	@Inject
	private UsuarioServico usuarioServico;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		try {
			return Response.status(Response.Status.OK).entity(usuarioServico.getAll()).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvar(Usuario usuario) {
		try {
			return Response.status(Response.Status.OK).entity(usuarioServico.salvar(usuario)).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	

}
