<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MODEL.Cliente"%>
<%@page import="DAO.DAOCliente"%>
<!DOCTYPE html>
<html>
    <body>
        <%
            try{
                Cliente cli = new Cliente();
                DAOCliente cld = new DAOCliente();
                String nome = request.getParameter("nome");
                String email = request.getParameter("email");
                if(nome.equals(null) || email.equals(null)){
                    response.sendRedirect("index.jsp");
                    out.println("<br><br>Os campos precisam ser preenchidos");
                }else{
                    cli.setNome(nome);
                    cli.setEmail(email);
                    cld.inserirCliente(cli);
                    out.print("<script>alert(\"Inserido com sucesso!\")</script>");
                    response.sendRedirect("index.jsp");
                }
            }catch(Exception e){
                throw new RuntimeException("Falha ao inserir Cliente!", e);
            }
        %>
    </body>
</html>
