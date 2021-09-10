package DAO;
import MODEL.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOCliente {
    
    private final Connection conn;
    private PreparedStatement stmt;
    
    public DAOCliente(){
        conn = new Conexao().getConexao();
    }
    
    public void closeConnections(){
        try {
            if(stmt != null){
                stmt.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar conexões!" + ex);
        }
    }
    
    public void inserirCliente(Cliente cliente) throws SQLException{
        
        String sql = "INSERT INTO tb_clientes (nome, email) " + "VALUES (?, ?)";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.execute();
        }catch(Exception e){
            throw new RuntimeException("Erro ao inserir Cliente!" + e);
        }
    }
    
    public ArrayList<Cliente> listarClientes() throws SQLException{
        ArrayList<Cliente> clientes = new ArrayList<>();
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
            throw new RuntimeException("Erro ao listar clientes!" + e);
        }
        return clientes;
    }
    
    public ArrayList<Cliente> listarClientePorNome(String nome){
        ArrayList<Cliente> clientes = new ArrayList<>();
        try{
            String sql = "SELECT id, nome, email FROM tb_clientes WHERE LOWER(nome) LIKE LOWER('%"+nome+"%')";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = (ResultSet) stmt.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                clientes.add(cliente);
            }
            return clientes;
        }catch(Exception e){
            throw new RuntimeException("Erro ao listar Cliente por nome! " + e.getMessage());
        }
    }
    
    public Cliente buscarClientePorID(int id) throws SQLException{
        Cliente cliente = new Cliente();
        try{
            String sql = "SELECT id, nome, email FROM tb_clientes WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet result = (ResultSet) stmt.executeQuery();
            
            result.next();
            cliente.setId(result.getInt("id"));
            cliente.setNome(result.getString("nome"));
            cliente.setEmail(result.getString("email"));
        }catch(Exception e){
            throw new RuntimeException("Erro ao Buscar Cliente pelo ID" + e);
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
            throw new RuntimeException("Erro ao tentar deletar cliente!" + e);
        }
    }
    
    public void alterarCliente(Cliente cliente) throws SQLException{
        String sql = "UPDATE tb_clientes SET nome = ?, email = ? WHERE id = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setInt(3, cliente.getId());
            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao tentar alterar cliente!" + ex);
        }
    }
}
