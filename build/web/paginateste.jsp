<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOCliente"%>
<%@page import="MODEL.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%
    DAOCliente dc = new DAOCliente();
%>
<script>
    class Cliente{
        
        setId(intId){
            this.id = intId;
        }
        
        getId(){
            return this.id;
        }
        
        setNome(stringNome){
            this.nome = stringNome;
        }
        
        getNome(){
            return this.nome;
        }
        
        setEmail(stringEmail){
            this.email = stringEmail;
        }
        
        getEmail(){
            return this.email;
        }
    }
    
    var listaClientes = [];
    
    function listarClientes(cliId, cliNome, cliEmail) {
        document.write(cliId + " " + cliNome + " " + cliEmail);
    }
    
    function pushCliente(intId, stringNome, stringEmail) {
        let cliente = new Cliente();
        cliente.setId(intId);
        cliente.setNome(stringNome);
        cliente.setEmail(stringEmail);
        listaClientes.push(cliente);
    }
    
    function tableFill(listaDeClientes){
        for(let i = 0; listaDeClientes.length; i++){
            let cliente = new Cliente();
            cliente = listaDeClientes[i];
            document.writeln("<tr>");
                document.writeln("<td>"+ cliente.getId() +"</td>");
                document.writeln("<td>"+ cliente.getNome() +"</td>");
                document.writeln("<td>"+ cliente.getEmail() +"</td>");
            document.writeln("</tr>");
        }
    }
    
    function teste(){
        for(let i = 0; i < 5; i++){
            let cli = new Cliente();
            cli.setId(i+1);
            cli.setNome('teste' + (i+1));
            cli.setEmail('teste' + (i+1) + '@teste');
            listaClientes.push(cli);
        }
        console.log(listaClientes);
    }
    
</script>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina teste</title>
    </head>
    <body style="display: grid; justify-content: center;">
        <h1>Essa pagina foi consebida para executar testes(aprender xD)</h1>
        <script>
            listarClientes(1, 'teste', 'teste@teste');
        </script>
        <br>
        <%
            ArrayList<Cliente> lista = dc.listarClientes();
            out.println("<script>");
            for(int i = 0; i < lista.size(); i++){
                Cliente cli = lista.get(i);
                out.println("pushCliente("+ cli.getId() + ", '"+ cli.getNome() +"', '"+ cli.getEmail() +"')");
            }
            out.println("</script>");
        %>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>NOME</th>
                <th>EMAIL</th>
            </tr>
            <script>
                tableFill(listaClientes);
            </script>
        </table>
    </body>
</html>
