package DAO;
import MODEL.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCliente {
    
    private final Connection conn;
    private PreparedStatement stmt;
    
    public DAOCliente(){
        conn = new Conexao().getConexao();
    }
    
    public void inserirCliente(Cliente cliente) throws SQLException{
        
        String sql = "INSERT INTO tb_clientes (nome, email) " + "VALUES (?, ?)";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.execute();
        }catch(Exception e){
            throw new RuntimeException("Erro ao inserir Cliente!", e);
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
    public List<Cliente> listarClientes() throws SQLException{
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
        }catch(SQLException e){
            throw new RuntimeException("Erro ao listar clientes!", e);
        }finally{
            stmt.close();
            conn.close();
        }
        return clientes;
    }
    
    public Cliente buscarClientePorID(int id) throws SQLException{
        Cliente cliente = new Cliente();
        try{
            String sql = "SELECT id, nome, email FROM tb_clientes WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet result = (ResultSet) stmt.executeQuery();
            
            while(result.next()){
                cliente.setId(result.getInt("id"));
                cliente.setNome(result.getString("nome"));
                cliente.setEmail(result.getString("email"));
            }
        }catch(Exception e){
            throw new RuntimeException("Erro ao Buscar Cliente pelo ID", e);
        }finally{
            stmt.close();
            conn.close();
        }
        return cliente;
    }
    
    public void deletarClientePorID(int id) throws SQLException{
        try{
            String sql = "DELETE FROM tb_clientes WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch(Exception e){
            throw new RuntimeException("Erro ao tentar deletar cliente!", e);
        }finally{
            stmt.close();
            conn.close();
        }
    }
}
