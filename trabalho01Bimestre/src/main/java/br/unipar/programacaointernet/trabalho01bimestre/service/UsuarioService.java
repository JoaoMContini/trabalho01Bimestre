package br.unipar.programacaointernet.trabalho01bimestre.service;

import br.unipar.programacaointernet.trabalho01bimestre.dao.UsuarioDao;
import br.unipar.programacaointernet.trabalho01bimestre.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
@Stateless
public class UsuarioService {
    @Inject
    private UsuarioDao usuarioDao;


    public List<Usuario> listarUsuarios(){
        return usuarioDao.listarUsuarios();
    }

    public void cadastrarUsuario(Usuario usuario) throws Exception{
        usuarioDao.cadastrarUsuario(usuario);
    }
}
