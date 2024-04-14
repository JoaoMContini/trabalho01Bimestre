package br.unipar.programacaointernet.trabalho01bimestre.service;

import br.unipar.programacaointernet.trabalho01bimestre.dao.HistoricoDao;
import br.unipar.programacaointernet.trabalho01bimestre.dao.TaskDao;
import br.unipar.programacaointernet.trabalho01bimestre.model.Historico;
import br.unipar.programacaointernet.trabalho01bimestre.model.Task;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.List;


@Stateless
public class TaskService {
    @Inject
    private TaskDao taskDao;
    @Inject
    private HistoricoDao historicoDao;


    public List<Task> listarTasks(){
        return taskDao.listarTasks();
    }

    public Task buscarTaskPorId(Integer id){
         return taskDao.buscarTaskPorId(id);
    }

    public void cadastrarTask(Task task) throws Exception{
        taskDao.cadastrarTask(task);
    }
    public void atualizaTask(Task task){
        taskDao.atualizarTask(task);
    }
    public void cadastrarHistorico(Task task) throws Exception{
        Historico historico = new Historico(task.getDescricao(),
                                            LocalDate.now().toString(),
                                            task.getObservacao(),
                                            task.getPrioridade(),
                                            task.getStatus(),
                                            task,
                                            task.getUsuario());

        historicoDao.cadastrarHistorico(historico);
    }
}
