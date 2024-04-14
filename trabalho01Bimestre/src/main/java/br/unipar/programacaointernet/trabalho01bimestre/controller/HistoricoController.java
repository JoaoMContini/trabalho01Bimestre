package br.unipar.programacaointernet.trabalho01bimestre.controller;

import br.unipar.programacaointernet.trabalho01bimestre.service.HistoricoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/historico")
public class HistoricoController {
    @Inject
    private HistoricoService historicoService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarHistoricos(){
        return Response.ok(historicoService.listarHistoricos()).build();
    }
}
