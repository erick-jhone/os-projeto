
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>
<main>
    <h2>Cadastrar Produto (Aparelho) </h2>
    <form action="cadastrarproduto" method="post">
        <label>Número de série
            <input type="number" name="nserie" placeholder="Nº Série">
        </label>
        <label>Nome
            <input type="text" name="nome" placeholder="nome">
        </label>
        <label>Marca
            <input type="text" name="marca" placeholder="marca">
        </label>
        <label>Modelo
            <input type="text" name="modelo" placeholder="modelo">
        </label>
        <input type="submit" value="Cadastrar">
    </form>

</main>

