<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOCliente"%>
<%@page import="MODEL.Cliente"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Buscar Cliente</title>
    </head>
    <body style="display: grid; justify-content: center;">
        <h1 style="text-align: center">Busca Cliente por id</h1>
        <form action="buscar_cliente.jsp">
            <label for="id">Busca</label>
            <input type="text" name="id" required>
            <input type="submit" value="Buscar">
        </form>
        <br><a href="index.jsp" title="Voltar">Voltar</a>
        <%
            String id = request.getParameter("id");
            if(id != null){
                try{
                    Cliente cli = new DAOCliente().buscarClientePorID(Integer.parseInt(id));
                    if(cli != null){
                        response.sendRedirect("editar_cliente.jsp?id="+ cli.getId() + "&nome=" + cli.getNome() + "&email=" + cli.getEmail());
                    }else{
                        out.println("<p>Cliente não encontrado!</p>");
                    }
                }catch(Exception e){
                    out.println("<script>");
                    out.println("alert('"+ e +"');");
                    out.println("</script>");
                }
            }
        %>
    </body>
</html>
