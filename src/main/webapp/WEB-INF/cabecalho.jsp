<%@ page import="java.util.Set" %>
<%@ page import="com.example.osprojeto.model.Usuario" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="estilo.css">
</head>
<body>
<%
    String mensagem = request.getParameter("mensagem");
    if (mensagem != null) {
        if (mensagem.equals("loginousenhaincorretos")) {
%>
<script>
    alert("Login ou senha incorretos");
</script>
<%
} else if (mensagem.equals("faltadados")) {
%>
<script>
    alert("Você precisa informar todos os dados no formulário");
</script>
<%
} else if (mensagem.equals("usuariojaexiste")) {
%>
<script>
    alert("Usuário já existente");
</script>
<%
} else if (mensagem.equals("erroaotentarcadastrar")) {
%>
<script>
    alert("Erro ao tentar cadastrar");
</script>
<%
        }
    }
%>

<header>
    <% if(session.getAttribute("usuario") != null) { %>
    <!-- Se precisar imprimir alguma coisa aqui, adicione o código necessário -->
    <% } %>
</header>
<!-- Restante do seu código HTML aqui -->
</body>
</html>
