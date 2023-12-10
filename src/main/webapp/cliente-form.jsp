
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>
<main>
    <h2>Cadastrar</h2>
    <form action="cadastrarcliente" method="post">
        <label>Nome
            <input type="text" name="nome" placeholder="Nome">
        </label>
        <label>Telefone
            <input type="text" name="telefone" placeholder="Telefone">
        </label>
        <label>Endereço
            <input type="text" name="endereco" placeholder="Endereço">
        </label>

        <input type="submit" value="Cadastrar Cliente">
    </form>



</main>

