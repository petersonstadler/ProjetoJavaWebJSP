package DAO;
import MODEL.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOCliente {
    
    private Connection conn;
    private PreparedStatement stmt;
    
    public DAOCliente(){
        conn = new Conexao().getConexao();
    }
    
    public void inserirCliente(Cliente cliente){
        
        String sql = "INSERT INTO tb_clientes (nome, email) " + "VALUES (?, ?)";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.execute();
            stmt.close();
        }catch(Exception e){
            throw new RuntimeException("Erro ao inserir Cliente!", e);
        }
    }
    
    public List<Cliente> listarClientes(){
        List<Cliente> clientes = new ArrayList<>();
        try{
            String sql = "SELECT id, nome, email FROM tb_clientes";
            stmt = conn.prepareStatement(sql);
            ResultSet result = (ResultSet) stmt.executeQuery();
            while(result.next()){
                Cliente cliente = new Cliente();
                cliente.setId(result.getInt("id"));
                cliente.setNome(result.getString("nome"));
                cliente.setEmail(result.getString("email"));
                clientes.add(cliente);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, e.getCause());
            throw new RuntimeException("Erro ao listar clientes!", e);
        }
        return clientes;
    }
}
