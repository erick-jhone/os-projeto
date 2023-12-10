package com.example.osprojeto.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OrdemServico implements Comparable {

    Integer id;
    Cliente cliente;

    Produto produto;
    String observacao;
    List<Servico> servicos;
    Date dataEntrada;
    Date dataSaida;

    BigInteger valorTotal;

    public OrdemServico() {

    }

    public OrdemServico(Integer id, Cliente cliente, Produto produto, String observacao, List<Servico> servicos, Date dataEntrada, Date dataSaida, BigInteger valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.produto = produto;
        this.observacao = observacao;
        this.servicos = servicos;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valorTotal = valorTotal;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public java.util.Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public BigInteger getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigInteger valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemServico that = (OrdemServico) o;
        return Objects.equals(id, that.id);
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
