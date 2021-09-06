package TESTES;
import DAO.DAOCliente;
import MODEL.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOClienteTestes {
    
    private boolean create, read, update, delete;
    
    private List<Cliente> clientesTeste = new ArrayList<>();
    
    public DAOClienteTestes(){
        Cliente cli = new Cliente();
        for(int i = 0; i < 5; i++){
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
    }
    
    public void testeSucessivoInserir(){
        
    }
}
