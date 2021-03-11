package Model;

import Database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO{
    //Cria uma nova entrada na tabela de Salas.
    public static void createRoom(Room room){
        try {
            //Define o comando de SQL.
            String sql = "INSERT INTO rooms (name, capacity) VALUES (?,?)";
            //Cria uma conexão com o banco e gera um PreparedStatement.
            PreparedStatement pstsm = ConnectionFactory.connect().prepareStatement(sql);
            //Defininfo os parâmetros de comando SQL.
            pstsm.setString(1, room.getNameRoom());
            pstsm.setInt(2,room.getCapacityRoom());
            //Executa o comando SQL, salvando no banco de dados
            pstsm.execute();
        }catch (Exception error){
            System.out.println("Falha ao cadastrar a Sala. Erro: " + error.getMessage());
        }
    }

    //Deleta uma entrada na tabela de Sala.
    public static void deleteRoom (int id){
        try {
            String sql = "DELETE FROM rooms WHERE id = ?";
            PreparedStatement pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.execute();
        }catch (Exception error){
            System.out.println("Falha ao deletar a Sala. Erro: " + error.getMessage());
        }
    }

    //Atualiza uma Sala.
    public static void updateRoom(Room room){
        try {
            String sql = "UPDATE rooms SET name=?,capacity=? WHERE id=?";
            PreparedStatement pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setString(1,room.getNameRoom());
            pstmt.setInt(2,room.getCapacityRoom());
            pstmt.setInt(3,room.getIdRoom());
            pstmt.execute();
        }catch (Exception error){
            System.out.println("Falha ao atualizar a tabela de Salas. Erro: " + error.getMessage());
        }
    }

    //Retorna todos as Salas
    public static List<Room> getRooms(){
        //Cria uma lista de objetos Room vazia
        List<Room> rooms = new ArrayList<>();
        try {
            //Define o comando de SQL
            String sql = "SELECT * FROM rooms";
            //Cria conexão com o banco de dados
            Statement stmt = ConnectionFactory.connect().createStatement();
            //Executa o comando SQL e recebe os dados via ResultSet
            ResultSet rs = stmt.executeQuery(sql);

            //Loop para criação da lista.
            while (rs.next()){
                Room room = new Room(rs.getInt("id"), rs.getString("name"), rs.getInt("quantity"));
                rooms.add(room);
            }
        }catch (Exception error){
            System.out.println("Falha ao selecionar as Salas. Erro: "+ error.getMessage());
        }
        //Retorna Lista
        return rooms;
    }
}
