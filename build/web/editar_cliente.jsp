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
            <%--<%
                DAOCliente cli = new DAOCliente();
                try{
                    Cliente cliente = cli.buscarClientePorID(Integer.parseInt(request.getParameter("id")));
                    out.print("<form>");
                        out.print("");
                        out.print("");
                        out.print("");
                    out.print("</form>");
                }catch(Exception e){
                    throw new RuntimeException("Erro no editar cliente!" + e);
                }
            %>--%>
            <form method="get" action="executar_alterar.jsp">
                <label for="id">ID</label>
                <input type="text" name="id" value="<%=request.getParameter("id")%>" required readonly/><br><br>
                <label for="nome">NOME</label>
                <input type="text" name="nome" value="<%=request.getParameter("nome")%>" required/><br><br>
                <label for="email">EMAIL</label>
                <input type="text" name="email" value="<%=request.getParameter("email")%>" required/><br><br>
                <input type="submit" value="Alterar">
            </form>
    </body>
</html>
