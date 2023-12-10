<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="WEB-INF/cabecalho-listagem.jsp"%>

<main>
    <c:if test="${not null and not empty produto}">
    <form action="atualizarproduto" method="post">
        <label>ID:</label>
        <input type="text" name="id" value="${produto.id}" readonly>

        <label>N° de Série:</label>
        <input type="text" name="nserie" value="${produto.numeroDeSerie}">

        <label>Nome:</label>
        <input type="text" name="nome" value="${produto.nome}">

        <label>Marca:</label>
        <input type="text" name="marca" value="${produto.marca}">

        <label>Modelo:</label>
        <input type="text" name="modelo" value="${produto.modelo}">
        <input type="submit" value="Atualizar" id="cadastrar">
    </form>
    </c:if>
</main>

<%@include file="WEB-INF/rodape.jsp"%>
