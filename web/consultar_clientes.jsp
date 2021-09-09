<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MODEL.Cliente"%>
<%@page import="DAO.DAOCliente"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Clientes</title>
    </head>
    <body style="justify-content: center;">
        <h1>Consultar Clientes</h1>
        <%
            out.print("<table border='l'>");
            out.print("<tr>");
                out.print("<th>ID</th>");
                out.print("<th>NOME</th>");
                out.print("<th>EMAIL</th>");
                out.print("<th>EDITAR</th>");
                out.print("<th>EXCLUIR</th>");
            out.print("</tr>");
            
            
            DAOCliente cli = new DAOCliente();
            ArrayList<Cliente> lista = cli.listarClientes();
            for(int i = 0; i < lista.size(); i++){
                //request.setAttribute("id", lista.get(i).getId());
                
                out.print("<tr>");
                    out.print("<td>"+ lista.get(i).getId() +"</td>");
                    out.print("<td>"+ lista.get(i).getNome() +"</td>");
                    out.print("<td>"+ lista.get(i).getEmail() +"</td>");
                    out.print("<td><a href=\"editar_cliente.jsp?id="+ lista.get(i).getId() + "\">EDITAR</a></td>");
                    out.print("<td>EXCLUIR</td>");
                out.print("</tr>");
            }
            out.print("</table>");
        %>
    </body>
</html>
