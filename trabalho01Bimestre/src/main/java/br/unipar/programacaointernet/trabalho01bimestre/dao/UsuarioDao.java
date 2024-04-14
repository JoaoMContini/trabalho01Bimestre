package br.unipar.programacaointernet.trabalho01bimestre.dao;


import br.unipar.programacaointernet.trabalho01bimestre.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
@Stateless
public class UsuarioDao {
    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Usuario> listarUsuarios(){
        String jpql = "SELECT u FROM Usuario u";
        return em.createQuery(jpql, Usuario.class).getResultList();
    }


    public void cadastrarUsuario(Usuario usuario) throws Exception {
        try {
            em.persist(usuario);
        } catch (Exception ex) {
            throw new Exception("O Usuario não pode ser criado");
        }
    }
}
