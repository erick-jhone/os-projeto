<%--
  Created by IntelliJ IDEA.
  User: Erick
  Date: 02/12/2023
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="WEB-INF/cabecalho-dashboard.jsp"%>
<main>
    <div class="card" onclick="location.href='iniciarordemservico';">
        <h3>Ordem de Serviço</h3>
        <p>Clique para criar uma nova Ordem de Serviço.</p>
    </div>

    <div class="card" onclick="location.href='redirecionarrelatorioclientes';">
        <h3>Clientes</h3>
        <p>Clique para visualizar e gerenciar clientes</p>
    </div>

    <div class="card" onclick="location.href='redirecionarrelatorioprodutos';">
        <h3>Produtos</h3>
        <p>Clique para visualizar e gerenciar produtos.</p>
    </div>

    <div class="card" onclick="location.href='redirecionarrelatorioservicos';">
        <h3>Serviços</h3>
        <p>Clique para visualizar e gerenciar serviços.</p>
    </div>

    <div class="card" onclick="location.href='sair.jsp';">
        <h3>Sair</h3>
        <p>Clique para sair do sistema.</p>
    </div>
</main>


