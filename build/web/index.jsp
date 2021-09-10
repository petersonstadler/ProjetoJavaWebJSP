<%-- 
    Document   : index
    Created on : 03/09/2021, 13:11:41
    Author     : Peterson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estudos JavaWeb e CRUD</title>
        <link rel="stylesheet" type="text/css" href="estilos/normalizar.css">
        <link href="estilos/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header style="display: flex; justify-content: center; background-color: darkgrey; width: 100%; height: 90px; margin: 0;">
            <div>
                <ul style="display: flex; position: absolute; right: 1%;">
                    <li style="margin-top: 20px; margin-right: 50px"><a href="cadastro.jsp" title="Cadastrar">Cadastrar</a></li>
                    <li style="margin-top: 20px; margin-right: 50px"><a href="buscar_cliente.jsp" title="Buscar Cliente">Buscar Cliente</a></li>
                    <li style="margin-top: 20px; margin-right: 50px"><a href="consultar_clientes.jsp" title="Consultar Clientes">Consultar Clientes</a></li>
                </ul>
            </div>
        </header>
        <h1>Ola, bem vindo!</h1>
        <div style="background-color: lightgrey; width: 600px; height: 600px; margin: 0 35%;">
            <p style="text-align: center;">Seja bem-vindo ao meu projeto de aprendizado JavaWeb+JSP+HTML+CSS. Aqui estarei estudando conceitos como DAO e CRUD.</p>
        </div>
    </body>
</html>
