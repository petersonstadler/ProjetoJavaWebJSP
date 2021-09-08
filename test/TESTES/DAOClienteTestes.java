package TESTES;
import DAO.DAOCliente;
import MODEL.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOClienteTestes {
    
    //Variáveis para checkar os testes sucessivos(dependentes entre si)
    private boolean create, read, update, delete;

    public boolean isCreate() {
        return create;
    }

    public boolean isRead() {
        return read;
    }

    public boolean isUpdate() {
        return update;
    }

    public boolean isDelete() {
        return delete;
    }
    
    private List<Cliente> clientesTeste = new ArrayList<>();
    
    public DAOClienteTestes(){
        for(int i = 0; i < 5; i++){
            Cliente cli = new Cliente();
            cli.setNome("teste" + i);
            cli.setEmail("testeemail" + i);
            clientesTeste.add(cli);
        }
    }
    
    //o registro será id = 4, nome = teste, email = teste.
    public void testarListarClientes_QuandoHouverApenas1Registro() throws SQLException{
        final int IDCLIENTE = 4;
        DAOCliente daoCliente = new DAOCliente();
        List<Cliente> clientes = daoCliente.listarClientes();
        Cliente cli = clientes.get(0);
                
        if(cli.getNome().equals("teste") && cli.getEmail().equals("teste") && cli.getId() == IDCLIENTE){
            System.out.println("Teste listar clientes: OK!");
        }else{
            System.out.println("Teste listar clientes: FALHOU!");
        }
        daoCliente.closeConnections();
    }
    
    public void testarBuscarClientesPorID_QuandoIdIgualA4ForIgualNomeTeste() throws SQLException{
        Cliente resultadoEsperado = new Cliente();
        resultadoEsperado.setId(4);
        resultadoEsperado.setNome("teste");
        resultadoEsperado.setEmail("teste");
        
        DAOCliente daoCliente = new DAOCliente();
        Cliente teste = daoCliente.buscarClientePorID(4);
        
        if(teste.getNome().equals(resultadoEsperado.getNome()) && 
           teste.getEmail().equals(resultadoEsperado.getEmail()) && 
           teste.getId() == resultadoEsperado.getId()){
            System.out.println("Teste Buscar Cliente por ID: OK!");
        }else{
            System.out.println("Teste Buscar Cliente por ID: FALHOU!");
        }
        daoCliente.closeConnections();
    }
    
    public void testeSucessivoInserir(){
        DAOCliente dc = new DAOCliente();
        try{
            for(int i = 0; i < clientesTeste.size(); i++){
                dc.inserirCliente(clientesTeste.get(i));
            }
            create = true;
            System.out.println("Teste sucessivo 01: Inserir - OK!");
        }catch(Exception e){
            create = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, e.getCause());
            System.out.println("Teste sucessivo 01: Inserir - FALHOU!");
        }
        dc.closeConnections();
    }
    
    public void testeSucessivoListar(){
        DAOCliente dc = new DAOCliente();
        try{
            List<Cliente> clientes = dc.listarClientes();
            for(int i = 0; i < clientes.size(); i++){
                System.out.println("id: " + clientes.get(i).getId() + ", Nome: " + clientes.get(i).getNome() + ", Email: " + clientes.get(i).getEmail());
            }
            read = true;
        }catch(Exception e){
            read = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, e.getCause());
            System.out.println("Teste sucessivo 02: Listar - FALHOU!");
        }
        dc.closeConnections();
    }
    
    public void testeSucessivoAlterar(){
        DAOCliente dc = new DAOCliente();
        try{
            List<Cliente> clientes = dc.listarClientes();
            System.out.println("-------------------------Alterando testes----------------------");
            for(int i = 0; i < clientes.size(); i++){
                Cliente cli = new Cliente();
                cli.setNome("testeAlterado" + i);
                cli.setEmail("testeAlteradoEmail" + i);
                cli.setId(clientes.get(i).getId());
                dc.alterarCliente(cli);
            }
            update = true;
        }catch(Exception e){
            update = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, e.getCause());
            System.out.println("Teste sucessivo 03: Alterar - FALHOU!");
            throw new RuntimeException("", e);
        }
        dc.closeConnections();
    }
    
    public void testeSucessivoDeletar(){
        DAOCliente dc = new DAOCliente();
        try{
            List<Cliente> clientes = dc.listarClientes();
            System.out.println("-------------------------Deletando----------------------");
            for(int i = 0; i < clientes.size(); i++){
                dc.deletarClientePorID(clientes.get(i).getId());
                System.out.println(clientes.get(i).getNome() + " deletado com sucesso!");
            }
            delete = true;
        }catch(Exception e){
            delete = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, e.getCause());
            System.out.println("Teste sucessivo 04: Deletar - FALHOU!");
            throw new RuntimeException("", e);
        }
        dc.closeConnections();
    }
}
