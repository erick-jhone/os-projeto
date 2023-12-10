<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="WEB-INF/cabecalho-listagem.jsp"%>
<main>
    <a href="servico-form.jsp">
        <input type="submit" name="novoservico" value="Cadastrar serviço" id="cadastrar">
    </a>
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Valor</th>
            <th>Deletar</th>
            <th>Alterar</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="servico" items="${servicos}">
            <tr>
                <td>${servico.id}</td>
                <td>${servico.nome}</td>
                <td>${servico.descricao}</td>
                <td>${servico.valor}</td>
                <td>
                    <form action="deletarservico" method="post">
                        <input type="hidden" name="id" value="${servico.id}">
                        <input type="submit" value="Deletar">
                    </form>
                </td>
                <td>
                    <form action="alterarservico" method="post">
                        <input type="hidden" name="id" value="${servico.id}">
                        <input type="submit" value="Alterar" id="alterar">
                    </form>
                </td>


            </tr>


        </c:forEach>

        </tbody>
    </table>
</main>
<%@include file="WEB-INF/rodape.jsp"%>