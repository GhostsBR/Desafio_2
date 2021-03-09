package Model;

import Controller.DatabaseController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CoffeeModel {
    //Cria uma nova entrada na tabela de Espaços de Café.
    public void createCoffee(String name){
        try {
            String sql = "INSERT INTO coffee (name) VALUES (?)";
            PreparedStatement pstmt = DatabaseController.connect().prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.execute();
        }catch (Exception error){
            System.out.println("Falha ao cadastrar o Espaço de Café. Erro: " + error.getMessage());
        }
    }

    //Deleta uma entrada na tabela de Espaços de Café.
    public void deleteCoffee (int id){
        try {
            String sql = "DELETE FROM coffee WHERE id = ?";
            PreparedStatement pstmt = DatabaseController.connect().prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.execute();
        }catch (Exception error){
            System.out.println("Falha ao deletar o Espaço de Café. Erro: " + error.getMessage());
        }
    }

    //Atualiza uma entrada na tabela de Espaços de Café.
    public void updateCoffee (int id, String name){
        try {
            String sql = "UPDATE coffee SET name=? WHERE id = ?";
            PreparedStatement pstmt = DatabaseController.connect().prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setInt(2,id);
            pstmt.execute();
        }catch (Exception error){
            System.out.println("Falha ao atualizar o Espaço de Café. Erro: " + error.getMessage());
        }

    }

    //Retorna todas as entradas da tabela de Espaços de Café.
    public static String[] getCoffee() {
        try {
            String sql = "SELECT * FROM coffee";
            Statement stmt = DatabaseController.connect().createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                System.out.println("\nID do Espaço de Café:\t" + rs.getString("id"));
                System.out.println("Nome do Espaço de Café:\t" + rs.getString("name"));
            }


            return null;
        } catch (Exception e) {
            System.out.println("Falha ao selecionas os Espaços de Café:" + e.getMessage());
        }

        return null;
    }
}
