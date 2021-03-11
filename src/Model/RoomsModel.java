package Model;

import Database.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RoomsModel {
    //Cria uma nova entrada na tabela de Salas.
    public void createRoom(String name, int capacity){
        try {
            String sql = "INSERT INTO rooms (name, capacity) VALUES (?,?)";
            PreparedStatement pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setInt(2,capacity);
            pstmt.execute();
        }catch (Exception error){
            System.out.println("Falha ao cadastrar a Sala. Erro: " + error.getMessage());
        }
    }

    //Deleta uma entrada na tabela de Salas.
    public void deleteRoom(int id){
        try {
            String sql = "DELETE FROM rooms WHERE id = ?";
            PreparedStatement pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.execute();
        }catch (Exception error){
            System.out.println("Falha ao deletar a Sala. Erro: " + error.getMessage());
        }
    }

    //Atualiza o "NOME" de uma entrada na tabela de Salas.
    public void updateRoom (int id, String name){
        try {
            String sql = "UPDATE rooms SET name = ? WHERE id = ?";
            PreparedStatement pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setInt(2,id);
            pstmt.execute();
        }catch (Exception error){
            System.out.println("Falha ao atualizar a Sala. Erro: " + error.getMessage());
        }

    }

    //Atualiza a "CAPACIDADE" de uma entrada na tabela de Salas.
    public void updateRoom (int id, int capacity){
        try {
            String sql = "UPDATE rooms SET capacity = ? WHERE id = ?";
            PreparedStatement pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setInt(1,capacity);
            pstmt.setInt(2,id);
            pstmt.execute();
        }catch (Exception error){
            System.out.println("Falha ao atualizar a Sala. Erro: " + error.getMessage());
        }

    }

    //Atualiza o "NOME" e a "CAPACIDADE" de uma entrada na tabela de Salas.
    public void updateRoom (int id, String name, int capacity){
        try {
            String sql = "UPDATE rooms SET name=?,capacity = ? WHERE id = ?";
            PreparedStatement pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setInt(2,capacity);
            pstmt.setInt(3,id);
            pstmt.execute();
        }catch (Exception error){
            System.out.println("Falha ao atualizar a Sala. Erro: " + error.getMessage());
        }

    }

    //Retorna todas as entradas da tabela de Salas.
    public static String[] getRooms() {
        try {
            String sql = "SELECT * FROM rooms";
            Statement stmt = ConnectionFactory.connect().createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                System.out.println("\nID da Sala:\t\t\t" + rs.getString("id"));
                System.out.println("Nome da Sala:\t\t" + rs.getString("name"));
                System.out.println("Capacidade da Sala: " + rs.getString("capacity"));
            }


            return null;
        } catch (Exception e) {
            System.out.println("Falha ao selecionas os Espaços de Café:" + e.getMessage());
        }

        return null;
    }
}
