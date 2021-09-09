<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOCliente"%>

<script>
    function mensagemSucesso(){
        alert("Excluido com sucesso!");
        window.location.href = "consultar_clientes.jsp";
    }
    function mensagemFalha(){
        alert("Falha ao excluir!");
    }
</script>
<%
    DAOCliente cld = new DAOCliente();
    try{
        cld.deletarClientePorID(Integer.parseInt(request.getParameter("id")));
        out.print("<script>mensagemSucesso();</script>");
    }catch(Exception e){
        out.print("<script>mensagemFalha();</script>");
        throw new RuntimeException("Erro ao deletar Cliente! " + e);
    }
    
%>
