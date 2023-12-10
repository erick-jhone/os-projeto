<%@ include file="WEB-INF/cabecalho-listagem.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<main>
    <c:if test="${not empty cliente}">
        <form action="atualizarcliente" method="post">
            <label>ID:</label>
            <input type="text" name="id" value="${cliente.id}" readonly>

            <label>Nome:</label>
            <input type="text" name="nome" value="${cliente.nome}">

            <label>Telefone:</label>
            <input type="text" name="telefone" value="${cliente.telefone}">

            <label>Endereço:</label>
            <input type="text" name="endereco" value="${cliente.endereco}">

            <input type="submit" value="Atualizar" id="cadastrar">
        </form>
    </c:if>
</main>

<%@ include file="WEB-INF/rodape.jsp" %>
