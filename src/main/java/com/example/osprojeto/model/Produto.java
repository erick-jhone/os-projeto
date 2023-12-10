package com.example.osprojeto.model;

import java.util.Objects;

public class Produto implements Comparable {

    Integer id;
    String numeroDeSerie;
    String nome;
    String modelo;
    String marca;

    public Produto(){}
    public Produto(String numeroDeSerie, String nome, String modelo, String marca) {
        this.numeroDeSerie = numeroDeSerie;
        this.nome = nome;
        this.modelo = modelo;
        this.marca = marca;
    }

    public Produto(Integer id, String numeroDeSerie, String nome, String modelo, String marca) {
        this.id = id;
        this.numeroDeSerie = numeroDeSerie;
        this.nome = nome;
        this.modelo = modelo;
        this.marca = marca;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(String numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
