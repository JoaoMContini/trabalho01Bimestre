package br.unipar.programacaointernet.trabalho01bimestre.service;

import br.unipar.programacaointernet.trabalho01bimestre.dao.HistoricoDao;
import br.unipar.programacaointernet.trabalho01bimestre.model.Historico;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class HistoricoService {
    @Inject
    private HistoricoDao historicoDao;

    public List<Historico>listarHistoricos(){
        return historicoDao.listarHistoricos();
    }
}
