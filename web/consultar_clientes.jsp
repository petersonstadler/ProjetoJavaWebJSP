<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MODEL.Cliente"%>
<%@page import="DAO.DAOCliente"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Clientes</title>
        <link href="estilos/normalizar.css" rel="stylesheet" type="text/css"/>
        <link href="estilos/consultar_cliente.css" rel="stylesheet" type="text/css"/>
        <script>
            function confirmar(id, cliente){
                var excluir = confirm("Deseja realmente excluir cliente: " + cliente + "?");
                if(excluir){
                    window.location.href = "executar_excluir.jsp?id=" + id;
                }
            }
        </script>
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
                out.print("<tr>");
                    out.print("<td>"+ lista.get(i).getId() +"</td>");
                    out.print("<td>"+ lista.get(i).getNome() +"</td>");
                    out.print("<td>"+ lista.get(i).getEmail() +"</td>");
                    out.print("<td><a href=\"editar_cliente.jsp?id="+ lista.get(i).getId() +"&nome="+ lista.get(i).getNome() +"&email="+ lista.get(i).getEmail() + "\">EDITAR</a></td>");
                    out.print("<td><input type=\"button\" value=\"Excluir\" onclick=\"confirmar("
                            + lista.get(i).getId() + 
                            ", '" + lista.get(i).getNome() + "'" +
                            ");\"></td>");
                out.print("</tr>");
            }
            out.print("</table>");
        %>
        <a href="index.jsp">voltar</a>
    </body>
</html>