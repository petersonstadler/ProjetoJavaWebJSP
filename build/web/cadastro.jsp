<%--
    SENHA JAVA DB
    LOGIN PETERSON
    SENHA 123
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Clientes</title>
        <link rel="stylesheet" href="estilos/cadastro.css">
    </head>
    <body style="justify-content: center;">
        <form style="margin: 15% 35%; height: 200px; background-color: darkgrey;" method="post" action="executar_inserir.jsp">
            <h1 style="text-align: center;">Cadastro de Clientes</h1>
            <label class="centerinform" for="nome">NOME</label>
            <input class="inputform" type="text" name="nome" required/><br><br>
            <label class="centerinform" for="email">EMAIL</label>
            <input class="inputform" type="text" name="email" required/><br><br>
            <input id="inputbutton" type="submit" value="ENVIAR">
        </form>
        <a href="index.jsp" title="Voltar" style="float: right; margin-right: 50%">Voltar</a>
    </body>
</html>
