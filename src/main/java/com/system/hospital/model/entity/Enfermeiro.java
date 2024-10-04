package com.system.hospital.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_enfermeiro")
public class Enfermeiro implements Serializable {

    @Serial
    private static final long serialVersionUID = -8654891696196923215L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private Integer id;

    @Column(nullable = false, length = 160)
    private String nome;

    @Column (nullable = false)
    private Integer idade;

    @Column (nullable = false, length = 11)
    private String cpf;

    @Column (nullable = false, length = 8)
    private String num_carteira;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    @JsonIgnore
    private Hospital hospital;
    @OneToMany(mappedBy = "enfermeiro", fetch = FetchType.LAZY)
    private List<Relatorio> relatorioList = new ArrayList<Relatorio>();

    public Enfermeiro() {
    }

    public Enfermeiro(Integer id, String nome, Integer idade, String cpf, String num_carteira, Hospital hospital) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.num_carteira = num_carteira;
        this.hospital = hospital;
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

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public List<Relatorio> getRelatorioList() {
        return relatorioList;
    }

    public void setRelatorioList(Relatorio relatorio) {
        this.relatorioList.add(relatorio);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enfermeiro that = (Enfermeiro) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}




