<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="WEB-INF/cabecalho-listagem.jsp"%>
<main>
    <a href="iniciarordemservico">
        <input type="submit" name="novaos" value="Realizar nova ordem de serviço" id="cadastrar">
    </a>
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Cliente</th>
            <th>Observação</th>
            <th>Data de Entrada</th>
            <th>Data de saída</th>
            <th>Excluir</th>
            <th>Alterar</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ordemservico" items="${ordensdeservico}">
            <tr>
                <td>${ordemservico.id}</td>
                <td>${ordemservico.cliente.nome}</td>
                <td>${ordemservico.observacao}</td>
                <td>${ordemservico.dataEntrada}</td>
                <td>${ordemservico.dataSaida}</td>
                <td>
                    <form action="deletarordemservico" method="post">
                        <input type="hidden" name="id" value="${ordemservico.id}">
                        <input type="submit" value="Deletar">
                    </form>
                </td>
                <td>
                    <form action="alterarordemservico" method="post">
                        <input type="hidden" name="id" value="${ordemservico.id}">
                        <input type="submit" value="Alterar" id="alterar">
                    </form>
                </td>


            </tr>


        </c:forEach>

        </tbody>
    </table>
</main>
<%@include file="WEB-INF/rodape.jsp"%>