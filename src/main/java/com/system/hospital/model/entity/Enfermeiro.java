package com.system.hospital.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "tb_enfermeiro")

public class Enfermeiro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private Integer id;

    @Column(nullable = false, length = 160)
    @NotNull
    private String nome;

    @Column (nullable = false)
    @NotNull
    private Integer idade;

    @Column (nullable = false, length = 11)
    @NotNull
    private String cpf;

    @Column (nullable = false, length = 8)
    @NotNull
    private String num_carteira;

    //@Column
    //private Hospital hospital; (Entidade hospital ainda não existente)

    //(Lista de Relatórios ainda não existente)

    public Enfermeiro(Integer id, String nome, Integer idade, String cpf, String num_carteira) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.num_carteira = num_carteira;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNum_carteira() {
        return num_carteira;
    }

    public void setNum_carteira(String num_carteira) {
        this.num_carteira = num_carteira;
    }
}




