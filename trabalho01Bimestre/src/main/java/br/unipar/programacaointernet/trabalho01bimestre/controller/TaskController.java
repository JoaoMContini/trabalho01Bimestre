package br.unipar.programacaointernet.trabalho01bimestre.controller;


import br.unipar.programacaointernet.trabalho01bimestre.model.Task;
import br.unipar.programacaointernet.trabalho01bimestre.service.TaskService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
@Path("/task")
public class TaskController {
    @Inject
    private TaskService taskService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarTasks(){
        return Response.ok(taskService.listarTasks()).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastraTask(Task task){
        try {
            taskService.cadastrarTask(task);
            taskService.cadastrarHistorico(task);
            return Response.status(201).entity("Cadastrado com sucesso!!").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response atualizaTask(Task task){
        try {
            taskService.cadastrarTask(task);
            taskService.cadastrarHistorico(task);
            return Response.status(201).entity("Cadastrado com sucesso!!").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarTask(@PathParam("id") Integer id, Task task) {
        try {
        Task taskExistente = taskService.buscarTaskPorId(id);
        if (taskExistente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        task.setId(id);
        taskService.atualizaTask(task);
        taskService.cadastrarHistorico(task);
        return Response.status(201).entity("Cadastrado com sucesso!!").build();
    }catch (Exception ex){
        return Response.status(403).entity(ex.getMessage()).build();
    }
    }
}
