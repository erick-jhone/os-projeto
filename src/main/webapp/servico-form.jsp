<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>
<main>
    <h2>Cadastrar</h2>
    <form action="cadastrarservico" method="post">
        <label>Nome do Serviço
            <input type="text" name="nome" placeholder="Nome">
        </label>
        <label>Descrição
            <input type="text" name="descricao" placeholder="Descrição">
        </label>
        <label>Valor
            <input type="number" name="valor" placeholder="Valor">
        </label>

        <input type="submit" value="Cadastrar">
    </form>



</main>

