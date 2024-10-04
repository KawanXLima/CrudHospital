package com.system.hospital.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_relatorio")
public class Relatorio implements Serializable {

    @Serial
    private static final long serialVersionUID = -8654891696196923215L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Integer id;

    @Column(nullable = false, length = 250)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "enfermeiro_id")
    @JsonIgnore
    private Enfermeiro enfermeiro;

    public Relatorio() {
    }

    public Relatorio(Integer id, String observacao, Enfermeiro enfermeiro) {
        this.id = id;
        this.observacao = observacao;
        this.enfermeiro = enfermeiro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Enfermeiro getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relatorio relatorio = (Relatorio) o;
        return Objects.equals(id, relatorio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
