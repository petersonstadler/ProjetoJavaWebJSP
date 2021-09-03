package TESTES;
import DAO.DAOCliente;
import MODEL.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOClienteTestes {
    
    //o registro será id = 4, nome = teste, email = teste.
    public void testarListarClientes_QuandoHouverApenas1Registro(){
        final int IDCLIENTE = 4;
        DAOCliente daoCliente = new DAOCliente();
        List<Cliente> clientes = daoCliente.listarClientes();
        Cliente cli = clientes.get(0);
                
        if(cli.getNome().equals("teste") && cli.getEmail().equals("teste") && cli.getId() == IDCLIENTE){
            System.out.println("Teste listar clientes: ok!");
        }else{
            System.out.println("Teste listar clientes: falhou!");
        }
    }
}
