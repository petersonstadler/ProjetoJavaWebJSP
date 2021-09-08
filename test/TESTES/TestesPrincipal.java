package TESTES;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TestesPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestarConexao();
    }
    
    private static void TestarConexao(){
        try{
            Connection conn = new Conexao().getConexao();
            conn.close();
            System.out.println("Teste de Conexão: OK!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, e.getCause());
            System.out.println("Teste de Conexão: FALHOU!");
        }
    }
    
    private static void TestarDAOClienteLISTAR(){
        DAOClienteTestes daoClientesTestes = new DAOClienteTestes();
        try {
            daoClientesTestes.testarListarClientes_QuandoHouverApenas1Registro();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getCause());
        }
    }
    
    private static void TestarBuscarClientePorID(){
        DAOClienteTestes daoClientesTestes = new DAOClienteTestes();
        try {
            daoClientesTestes.testarBuscarClientesPorID_QuandoIdIgualA4ForIgualNomeTeste();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getCause());
        }
    }
}
