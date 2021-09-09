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
        <h1>Editar Cliente</h1>
        <form method="post" action="executar_editar_cliente.jsp">
            <%
                DAOCliente cli = new DAOCliente();
                try{
                    Cliente cliente = cli.buscarClientePorID(Integer.parseInt(request.getParameter("id")));
                    out.print("<form>");
                    out.print("</form>");
                }catch(Exception e){
                    throw new RuntimeException("Erro no editar cliente!" + e);
                }
            %>
        </form>
    </body>
</html>
