package br.unipar.programacaointernet.trabalho01bimestre.model;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 1000)
    private String descricao;
    @Column(length = 10)
    private String data_alteracao;
    @Column(length = 1000)
    private String observacao;
    @Column(length = 20)
    private String prioridade;
    @Column(length = 20)
    private String status;
    @ManyToOne
    private Task task;
    @ManyToOne
    private Usuario usuario;

    public Historico(String descricao, String data_alteracao, String observacao, String prioridade, String status, Task task, Usuario usuario) {
        this.descricao = descricao;
        this.data_alteracao = data_alteracao;
        this.observacao = observacao;
        this.prioridade = prioridade;
        this.status = status;
        this.task = task;
        this.usuario = usuario;
    }
    public Historico(){

    }

    @Override
    public String toString() {
        return "Historico{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", data_alteracao='" + data_alteracao + '\'' +
                ", observacao='" + observacao + '\'' +
                ", prioridade='" + prioridade + '\'' +
                ", status='" + status + '\'' +
                ", task=" + task +
                ", usuario=" + usuario +
                '}';
    }
}
