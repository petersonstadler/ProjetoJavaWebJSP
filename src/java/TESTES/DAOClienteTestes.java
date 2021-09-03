package TESTES;
import DAO.DAOCliente;
import MODEL.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOClienteTestes {
    
    public void testarListarClientes(){
        
        DAOCliente daoCliente = new DAOCliente();
        List<Cliente> clientes = daoCliente.listarClientes();
        
        
        Cliente cli = clientes.get(0);
                
                
        if(cli.getNome() == "teste" && cli.getEmail() == "teste" && cli.getId() == 4){
            System.out.println("Teste listar clientes: ok!");
        }else{
            Cliente cl2 = clientes.get(0);
            System.out.println("Teste listar clientes: falhou! " + cli.getNome() + cli.getEmail() + cli.getId());
        }
    }
    
}
