<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MODEL.Cliente"%>
<%@page import="DAO.DAOCliente"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Cliente</title>
    </head>
    <body style="justify-content: center;">
        <h1>Alterar Cliente</h1>
        <fieldset>
            <form method="get" action="executar_alterar.jsp">
                <label for="id">ID</label><br>
                <input type="text" name="id" value="<%=request.getParameter("id")%>" required readonly/><br><br>
                <label for="nome">NOME</label><br>
                <input type="text" name="nome" value="<%=request.getParameter("nome")%>" required/><br><br>
                <label for="email">EMAIL</label><br>
                <input type="text" name="email" value="<%=request.getParameter("email")%>" required/><br><br>
                <a style="margin-right: 80px;" href="consultar_clientes.jsp" title="Voltar">Voltar</a>
                <input type="submit" value="Alterar">
            </form>
        </fieldset>
    </body>
</html>
