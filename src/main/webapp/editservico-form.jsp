<%@ page import="com.example.osprojeto.model.Produto" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="WEB-INF/cabecalho-listagem.jsp"%>

<main>


        <form action="atualizarservico" method="post">
            <label>ID:</label>
            <input type="text" name="id" value="${servico.id}" readonly>

            <label>Nome:</label>
            <input type="text" name="nome" value="${servico.nome}">

            <label>Descrição:</label>
            <input type="text" name="descricao" value="${servico.descricao}">

            <label>Valor:</label>
            <input type="text" name="valor" value="${servico.valor}">

            <input type="submit" value="Atualizar" id="cadastrar">
        </form>
</main>

<%@include file="WEB-INF/rodape.jsp"%>
