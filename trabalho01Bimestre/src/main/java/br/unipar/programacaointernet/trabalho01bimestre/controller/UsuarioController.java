package br.unipar.programacaointernet.trabalho01bimestre.controller;

import br.unipar.programacaointernet.trabalho01bimestre.model.Usuario;
import br.unipar.programacaointernet.trabalho01bimestre.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuario")
public class UsuarioController {
    @Inject
    private UsuarioService usuarioService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarUsuarios(){
        return Response.ok(usuarioService.listarUsuarios()).build();
    }
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarUsuario(Usuario usuario){
        try {
            usuarioService.cadastrarUsuario(usuario);
            return Response.status(201).entity("Cadastrado com sucesso!!").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
}
