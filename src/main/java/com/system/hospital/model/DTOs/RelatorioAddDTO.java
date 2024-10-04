package com.system.hospital.model.DTOs;

public class RelatorioAddDTO {
    private Integer enfermeiro_id;
    private String observacao;

    public Integer getEnfermeiro_id() {
        return enfermeiro_id;
    }

    public void setEnfermeiro_id(Integer enfermeiro_id) {
        this.enfermeiro_id = enfermeiro_id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
