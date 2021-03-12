package Model;

import CustomExceptions.CustomException;
import Database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pela persisntência de dados da Classe Room.
 *
 * @author João
 * @author Thiago
 */
public class RoomDAO{

    /**
     * Objeto PreparedStatement usado no DAO.
     *
     * Definido objeto PreparedStatement utilizado pelo DAO,
     * facilitando seu uso e fechamento.
     */
    private PreparedStatement pstmt = null;

    /**
     * Método para registrar no banco uma nova Sala.
     *
     * Cadastra uma nova sala no banco utilizando um objeto Room.
     *
     * @exception CustomException se ocorrer erro de SQL ou no PreparedStatement
     *
     * @author João
     * @author Thiago
     *
     * @param room Room
     */
    public void createRoom(Room room) throws CustomException{
        try {
            String sql = "INSERT INTO rooms (name, capacity) VALUES (?,?)";
            pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setString(1, room.getNameRoom());
            pstmt.setInt(2,room.getCapacityRoom());
            pstmt.execute();
        }catch (Exception error){
            throw new CustomException("Erro ao inserir uma nova Sala: " + error.getMessage());
        } finally{
            try{
                if (pstmt != null){
                    pstmt.close();
                }
            } catch (Exception error){}
            ConnectionFactory.closeConnectionDatabase();
        }
    }

    /**
     * Método para excluir uma Sala
     *
     * Exclui uma Sala do banco de dados usando o ID.
     *
     * @exception CustomException se ocorrer erro de SQL ou no PreparedStatement
     *
     * @author João
     * @author Thiago
     *
     * @param id Integer
     */
    public void deleteRoom (int id) throws CustomException{
        try {
            String sql = "DELETE FROM rooms WHERE id = ?";
            pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.execute();
        }catch (Exception error){
            throw new CustomException("Erro ao excluir uma Sala: " + error.getMessage());
        } finally{
            try{
                if (pstmt != null){
                    pstmt.close();
                }
            } catch (Exception error){}
            ConnectionFactory.closeConnectionDatabase();
        }
    }

    /**
     * Método para alterar a Sala.
     *
     * Realiza alterações dos dados da Sala no banco, utilizando um objeto Room.
     *
     * @exception CustomException se ocorrer erro de SQL ou no PreparedStatement
     *
     * @author João
     * @author Thiago
     *
     * @param room Room
     */
    public void updateRoom(Room room) throws CustomException{
        try {
            String sql = "UPDATE rooms SET name=?,capacity=? WHERE id=?";
            pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setString(1,room.getNameRoom());
            pstmt.setInt(2,room.getCapacityRoom());
            pstmt.setInt(3,room.getIdRoom());
            pstmt.execute();
        }catch (Exception error){
            throw new CustomException("Erro ao atualizar a Sala: " + error.getMessage());
        } finally{
            try{
                if (pstmt != null){
                    pstmt.close();
                }
            } catch (Exception error){}
            ConnectionFactory.closeConnectionDatabase();
        }
    }

    /**
     * Método para retornar todas as Salas.
     *
     * Realiza a busca e retorno de todas as Salas salvas no banco.
     *
     * Obs: retorna uma lista vazia caso nenhuma Sala seja encontrada no banco!
     *
     * @exception CustomException se ocorrer erro de SQL ou no Statement
     *
     * @author João
     * @author Thiago
     *
     * @return List<Room> Lista de Salas
     */
    public List<Room> getRooms() throws CustomException{
        List<Room> rooms = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM rooms";
            stmt = ConnectionFactory.connect().createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                Room room = new Room(rs.getInt("id"), rs.getString("name"), rs.getInt("capacity"));
                rooms.add(room);
            }
        }catch (Exception error){
            throw new CustomException("Erro ao selecionar as Salas: " + error.getMessage());
        } finally{
            try{
                if (stmt != null){
                    stmt.close();
                }
                if (rs != null){
                    rs.close();
                }
            } catch (Exception error){}
            ConnectionFactory.closeConnectionDatabase();
        }
        return rooms;
    }

    /**
     * Método para retornar uma Sala.
     *
     * Realiza a busca e retorno de uma Sala salva no banco através do id.
     *
     * Obs: retorna um objeto vazio caso nenhuma Sala seja encontrada no banco!
     *
     * @exception CustomException se ocorrer erro de SQL ou no PreparedStatement
     *
     * @author João
     * @author Thiago
     *
     * @return Room
     */
    public Room getRoom(Integer id) throws CustomException{
        Room room = new Room();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM rooms WHERE id = ?";
            pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.execute();
            rs = pstmt.getResultSet();
            if(rs.next()){
                room = new Room(rs.getInt("id"), rs.getString("name"), rs.getInt("capacity"));
            }
        } catch (Exception error) {
            throw new CustomException("Erro ao buscar a Sala: " + error.getMessage());
        } finally{
            try{
                if (pstmt != null){
                    pstmt.close();
                }
                if (rs != null){
                    rs.close();
                }
            } catch (Exception error){}
            ConnectionFactory.closeConnectionDatabase();
        }
        return room;
    }
}