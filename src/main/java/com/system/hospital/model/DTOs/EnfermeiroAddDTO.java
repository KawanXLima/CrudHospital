package com.system.hospital.model.DTOs;

public class EnfermeiroAddDTO {
    private String nome;
    private Integer idade;
    private String cpf;
    private String num_carteira;
    private Integer hospital_id;

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

    public Integer getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(Integer hospital_id) {
        this.hospital_id = hospital_id;
    }
}
