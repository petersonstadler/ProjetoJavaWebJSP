package TESTES;

import DAO.DAOCliente;
import MODEL.Cliente;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TestesIsolados {

    public static void main(String[] args) {
        DAOClienteTestes dcTestes = new DAOClienteTestes();
        dcTestes.testeSucessivoInserir();
        dcTestes.testeSucessivoListar();
        dcTestes.testeSucessivoAlterar();
        dcTestes.testeSucessivoListar();
    }
    
}
