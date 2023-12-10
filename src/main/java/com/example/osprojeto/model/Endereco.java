package com.example.osprojeto.model;

public class Endereco {

    Integer id;
    String logradouro;
    String numero;
    String complemento;
    String CEP;


    public Endereco(Integer id, String logradouro, String numero, String complemento, String CEP) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.CEP = CEP;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }




}
