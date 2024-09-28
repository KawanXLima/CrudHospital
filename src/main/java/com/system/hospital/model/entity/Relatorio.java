package com.system.hospital.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_relatorio")
public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Integer id;
//    @OneToOne
//    @Column(nullable = false, length = 160)
//    private Hospital hospital;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Enfermeiro enfermeiro;

    @Column(nullable = false, length = 250)
    private String observacao;

    public Relatorio() {
    }

    public Relatorio(Integer id, Enfermeiro enfermeiro, String observacao) {
        this.id = id;
        this.enfermeiro = enfermeiro;
        this.observacao = observacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Hospital getHospital() {
//        return hospital;
//    }
//
//    public void setHospital(Hospital hospital) {
//        this.hospital = hospital;
//    }

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
}
