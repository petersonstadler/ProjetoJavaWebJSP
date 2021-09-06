package TESTES;

public class TesteCRUD {

    public static void main(String[] args) {
        DAOClienteTestes dcTestes = new DAOClienteTestes();
        dcTestes.testeSucessivoInserir();
        dcTestes.testeSucessivoListar();
        dcTestes.testeSucessivoAlterar();
        dcTestes.testeSucessivoListar();
        dcTestes.testeSucessivoDeletar();
        
        if(dcTestes.isCreate() && dcTestes.isRead()
           && dcTestes.isUpdate() && dcTestes.isDelete()){
            System.out.println("Teste de CRUD: OK!");
        }else{
            System.out.println("Teste de CRUD: falhou!");
        }
    }
}
