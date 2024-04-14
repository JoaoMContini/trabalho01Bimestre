package br.unipar.programacaointernet.trabalho01bimestre.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 1000)
    private String descricao;
    @Column(length = 1000)
    private String observacao;
    @Column(length = 10)
    private String data_previsao;
    @Column(length = 20)
    private String prioridade;
    @Column(length = 20)
    private String status;
    @Column(length = 10)
    private String data_inicio;
    @Column(length = 10)
    private String data_fim;
    @ManyToOne
    private Usuario usuario;

    public Task(String descricao, String observacao, String data_previsao, String prioridade, String status, String data_inicio, String data_fim, Usuario usuario) {
        this.descricao = descricao;
        this.observacao = observacao;
        this.data_previsao = data_previsao;
        this.prioridade = prioridade;
        this.status = status;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.usuario = usuario;
    }
    public Task(){

    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", observacao='" + observacao + '\'' +
                ", data_previsao='" + data_previsao + '\'' +
                ", prioridade='" + prioridade + '\'' +
                ", status='" + status + '\'' +
                ", data_inicio='" + data_inicio + '\'' +
                ", data_fim='" + data_fim + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
