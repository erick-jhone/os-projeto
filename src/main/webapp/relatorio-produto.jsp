<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="WEB-INF/cabecalho-listagem.jsp"%>
<main>
    <a href="produto-form.jsp">
        <input type="submit" name="novoproduto" value="Cadastrar produto" id="cadastrar">
    </a>
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>N° de Série</th>
            <th>Nome</th>
            <th>Marca</th>
            <th>Modelo</th>
            <th>Deletar</th>
            <th>Alterar</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="produto" items="${produtos}">
         <tr>
             <td>${produto.id}</td>
             <td>${produto.numeroDeSerie}</td>
             <td>${produto.nome}</td>
             <td>${produto.modelo}</td>
             <td>${produto.marca}</td>
             <td>
                 <form action="deletarproduto" method="post">
                     <input type="hidden" name="id" value="${produto.id}">
                     <input type="submit" value="Deletar">
                 </form>
             </td>
             <td>
                 <form action="alterarproduto" method="post" >
                     <input type="hidden" name="id" value="${produto.id}">
                     <input type="submit" value="Alterar" id="alterar">
                 </form>
         </tr>
        </c:forEach>

        </tbody>
    </table>
</main>
<%@include file="WEB-INF/rodape.jsp"%>