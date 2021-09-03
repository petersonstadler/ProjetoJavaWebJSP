package TESTES;
import DAO.Conexao;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class TestesPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestarConexao();
        TestarDAOClienteLISTAR();
    }
    
    private static void TestarConexao(){
        try{
            Connection conn = new Conexao().getConexao();
            System.out.println("Teste de Conexão: passou!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, e.getCause());
            System.out.println("Teste de Conexão: não passou!");
        }
    }
    
    private static void TestarDAOClienteLISTAR(){
        DAOClienteTestes daoClientesTestes = new DAOClienteTestes();
        daoClientesTestes.testarListarClientes_QuandoHouverApenas1Registro();
    }
}
