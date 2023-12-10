<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>

<main>
    <h2>Ordem de Serviço</h2>
    <form action="gravarordemservico" method="get">
        <label>Cliente:
            <select name="cliente" required="true">
                <c:forEach var="cliente" items="${clientes}">
                    <option value="${cliente.id}">${cliente.nome}</option>
                </c:forEach>
            </select>

        </label>
        <label>Produto:
            <select name="produto" required="true">
                <c:forEach var="produto" items="${produtos}">
                    <option value="${produto.id}">${produto.nome}</option>
                </c:forEach>
            </select>
        </label>
        <label>Observação:
            <input type="text" name="observacao" required="true" placeholder="observacao">
        </label>
        <label> Serviços:
            <select name="servicos" required="true" multiple size="${servicos.size()}">
                <c:forEach var="servico" items="${servicos}">
                    <option value="${servico.id}">${servico.nome}</option>
                </c:forEach>
            </select>
        </label>

        <label> Data Entrada:
            <input type="date" name="dataentrada" required="true" placeholder="Data de Entrada">
        </label>

        <label> Data Saida:
            <input type="date" name="datasaida" required="true" placeholder="Data de Saída">
        </label>

        <label>Valor
            <input type="number" name="valor" required="true" placeholder="Valor">
        </label>
        <input type="submit" value="Finalizar ordem de serviço">

    </form>



</main>

