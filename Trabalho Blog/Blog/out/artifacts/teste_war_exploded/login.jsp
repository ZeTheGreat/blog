<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String contexto = request.getContextPath();
    if (!contexto.equals(""))
        contexto = contexto + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${contexto}static/css/estilos.css">
    <title>Login</title>
</head>
<body>
<form class="baseForm" action="Validador" method="post">
    <label class="formLabel">
        Nome de Usuário:
        <input name="nomeUsuario" type="text" required class="formInput formTextInput">
    </label>
    <label class="formLabel">
        Senha:
        <input name="senha" type="password" required class="formInput formTextInput">
    </label>
    <input type="submit" value="Entrar" class="submitButton">
    <a href="cadastro.jsp">Cadastrar</a>
</form>
</body>
</html>
