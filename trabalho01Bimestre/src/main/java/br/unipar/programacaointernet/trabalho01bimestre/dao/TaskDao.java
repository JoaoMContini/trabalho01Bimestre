package br.unipar.programacaointernet.trabalho01bimestre.dao;

import br.unipar.programacaointernet.trabalho01bimestre.model.Task;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class TaskDao {
     @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Task> listarTasks(){
        String jpql = "SELECT t FROM Task t";
        return em.createQuery(jpql, Task.class).getResultList();
    }

    public Task buscarTaskPorId(Integer id) {
        return em.find(Task.class, id);
    }

    public void atualizarTask(Task task) {
        em.merge(task);
    }

    public void cadastrarTask(Task task) throws Exception{
        try {
            em.persist(task);
        }catch(Exception ex){
            throw  new Exception("Task não pode ser cadastrado.");
        }
    }
}
