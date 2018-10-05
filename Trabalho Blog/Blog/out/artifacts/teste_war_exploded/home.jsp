<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import="br.com.MW.Blog.Modelo.Usuario"%>
<%@page import="br.com.MW.Blog.Modelo.Papel"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/estilos.css">
    <title>Home</title>

</head>
<body>

<%Usuario usuario = (Usuario) request.getAttribute("usuarioLogado");%>
<div class="conteudo">
    <p>Olá usuário <%=usuario.BuscarNome()%></p>
    <p>Seu e-mail cadastrado é: <%=usuario.BuscarEmail()%></p>
    <p>Sua senha cadastrada é: <%=usuario.BuscarSenha()%></p>
    <p>Você tem privilégios de: </p>
    <ul>
            <% for(Papel p: usuario.BuscarPapeis() ){ %>
            <li><%= p.BuscarDescricao().toString() %></li>
            <%} %>
    </ul>


</div>
</body>
</html>
