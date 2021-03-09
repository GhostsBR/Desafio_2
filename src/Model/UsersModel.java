package Model;

import Controller.DatabaseController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsersModel {
    //Cria uma nova entrada na tabela de Clientes.
    public void createUser(String name){
        try {
            String sql = "INSERT INTO users (name) VALUES (?)";
            PreparedStatement pstmt = DatabaseController.connect().prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.execute();
        }catch (Exception error){
            System.out.println("Falha ao cadastrar o Usuário. Erro: " + error.getMessage());
        }
    }

    //Deleta uma entrada na tabela de Clientes.
    public void deleteUser (int id){
        try {
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement pstmt = DatabaseController.connect().prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.execute();
        }catch (Exception error){
            System.out.println("Falha ao deletar o Usuário. Erro: " + error.getMessage());
        }
    }

    //Atualiza uma entrada na tabela de Clientes.
    public void updateUser (int id, String name){
        try {
            String sql = "UPDATE users SET name = ? WHERE id = ?";
            PreparedStatement pstmt = DatabaseController.connect().prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setInt(2,id);
            pstmt.execute();
        }catch (Exception error){
            System.out.println("Falha ao atualizar o Usuário. Erro: " + error.getMessage());
        }

    }

    //Retorna todas as entradas da tabela de Clientes.
    public static String[] getUsers() {
        try {
            String sql = "SELECT * FROM users";
            Statement stmt = DatabaseController.connect().createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                System.out.println("\nID do usuário:" + rs.getString("id"));
                System.out.println("Nome do usuário:" + rs.getString("name"));
                System.out.println("Primeira etapa:\nSala: " + rs.getString("room1") + ".\nEspaço de Café: " + rs.getString("coffee1")+".");
                System.out.println("\nSegunda etapa:\nSala: " + rs.getString("room2") + ".\nEspaço de Café: " + rs.getString("coffee2")+".");
            }

            return null;
        } catch (Exception e) {
            System.out.println("Falha ao selecionas Usuário:" + e.getMessage());
        }

        return null;
    }
}
