package br.unipar.programacaointernet.trabalho01bimestre.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 100)
    private String nome;
    @Column(length = 100)
    private String cargo;

    public Usuario(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
