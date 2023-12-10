<%@ include file="WEB-INF/cabecalho-listagem.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<main>
    <a href="cliente-form.jsp">
        <input type="submit" name="novocliente" value="Cadastrar cliente" id="cadastrar">
    </a>
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Telefone</th>
            <th>Endereço</th>
            <th>Excluir</th>
            <th>Alterar</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="cliente" items="${clientes}">
            <tr>
                <td>${cliente.id}</td>
                <td>${cliente.nome}</td>
                <td>${cliente.telefone}</td>
                <td>${cliente.endereco}</td>
                <td>
                    <form action="deletarcliente" method="post">
                        <input type="hidden" name="id" value="${cliente.id}">
                        <input type="submit" value="Deletar">
                    </form>
                </td>
                <td>
                    <form action="alterarcliente" method="post">
                        <input type="hidden" name="id" value="${cliente.id}">
                        <input type="submit" value="Alterar" id="alterar">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
<%@ include file="WEB-INF/rodape.jsp" %>
