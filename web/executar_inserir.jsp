<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MODEL.Cliente"%>
<%@page import="DAO.DAOCliente"%>
<!DOCTYPE html>
<script>
    function mensagemSucesso(){
        alert("Inserido com sucesso!");
        window.location.href = "consultar_clientes.jsp";
    }
    function mensagemFalha(){
        alert("Falha ao inserir Cliente!");
    }
</script>
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
                    out.print("<script>mensagemSucesso()</script>");
                }
            }catch(Exception e){
                out.print("<script>mensagemFalha()</script>");
                throw new RuntimeException("Falha ao inserir Cliente!", e);
            }
        %>
    </body>
</html>
