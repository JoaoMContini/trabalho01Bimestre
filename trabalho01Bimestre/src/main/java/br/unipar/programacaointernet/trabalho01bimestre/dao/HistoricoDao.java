package br.unipar.programacaointernet.trabalho01bimestre.dao;

import br.unipar.programacaointernet.trabalho01bimestre.model.Historico;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
@Stateless
public class HistoricoDao {
    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Historico> listarHistoricos(){
        String jpql = "SELECT h FROM Historico h";
        return em.createQuery(jpql, Historico.class).getResultList();
    }
    public void cadastrarHistorico(Historico historico) throws Exception {
        try {
            em.persist(historico);
        } catch (Exception ex) {
            throw new Exception("O histórico não pode ser criado");
        }
    }
}
