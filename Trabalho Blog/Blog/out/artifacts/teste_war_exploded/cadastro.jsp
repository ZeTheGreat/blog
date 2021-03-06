<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro</title>
    <link rel="stylesheet" type="text/css" href="${contexto}static/css/estilos.css">
</head>
<body>
<form class="baseForm" action="Cadastro" method="post">
    <label class="formLabel">
        Nome:
        <input name="nomeUsuario" type="text" required class="formInput formTextInput">
    </label>

    <label class="formLabel">
        Login:
        <input name="apelidoUsuario" type="text" required class="formInput formTextInput">
    </label>

    <label class="formLabel">
        Email:
        <input name="emailUsuario" type=email required class="formInput formTextInput">
    </label>

    <label class="formLabel">
        Senha:
        <input name="senha" type="password" required class="formInput formTextInput">
    </label>
    <input type="submit" value="Cadastrar" class="submitButton">
</form>

</body>
</html>
