<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="estilos/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div>
            <h1>Login</h1>
            <p>Digite usuário e senha</p>
            <br>
        </div>
        
        <form>
            <fieldset>
                
                <div>
                    <label>Nome</label>
                    <input type="text" name="nome" id="nome">
                </div>
                
                <div>
                    <label>Senha</label>
                    <input type="password" name="email" id="email">
                </div>
                
            </fieldset>
        </form>
        <a href="index.jsp">voltar</a>
    </body>
</html>
