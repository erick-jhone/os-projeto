<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>
<main>
    <h2>Cadastrar</h2>
    <form action="cadastrar" method="post">
        <label>login
            <input type="text" name="login" placeholder="Login">
        </label>
        <label>Senha
            <input type="password" name="senha" placeholder="Senha">
        </label>
        <input type="submit" value="Cadastrar">
    </form>
    <h2>Logar</h2>
    <form action="logar" method="post">
        <label>login
            <input type="text" name="login" placeholder="Login">
        </label>
        <label>Senha
            <input type="password" name="senha" placeholder="Senha">
        </label>
        <input type="submit" value="Logar">
    </form>
</main>
<%@include file="WEB-INF/rodape.jsp"%>
