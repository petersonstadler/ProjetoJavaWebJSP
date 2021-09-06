<%-- 
    Document   : login
    Created on : 06/09/2021, 17:33:16
    Author     : Peterson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="estilos/login.css">
    </head>
    <body>
        <div>
            <h1>Login</h1>
            <p>Digite usuário e email</p>
            <br>
        </div>
        
        <form>
            <fieldset>
                
                <div>
                    <label>Nome</label>
                    <input type="text" name="nome" id="nome">
                </div>
                
                <div>
                    <label>Email</label>
                    <input type="email" name="email" id="email">
                </div>
                
            </fieldset>
            
        </form>
    </body>
</html>
