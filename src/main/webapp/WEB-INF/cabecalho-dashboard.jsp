<%@ page import="com.example.osprojeto.model.Usuario" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="estilo-dashboard.css">
</head>
<body>
<header>
    <% if(session.getAttribute("usuario")!=null) {
        out.print("<h2>Olá "+((Usuario)session.getAttribute("usuario")).getLogin()+"</h2>");
    }%>

</header>


