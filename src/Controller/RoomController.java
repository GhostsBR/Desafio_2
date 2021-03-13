package Controller;

import CustomExceptions.CustomException;
import Model.Room;
import Model.RoomDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo controle de salas.
 *
 * @author Gustavo Lemos
 */
public class RoomController {
    /**
     * Método responsável por separar e enviar as salas para serem inseridas no banco de dados.
     *
     * Apôs o recebimento de uma lista de objetos, o método separa as salas
     * e realiza o envio ao método responsável por inserir no banco de dados.
     *
     * @exception CustomException se ocorrer erro ao salvar no banco
     *
     * @param rooms List<Room> Lista de objetos de salas.
     */
    public static void insertRoom(List<Room> rooms) throws CustomException{
        try{
            for(Room r : rooms) {
                if (r.getIdRoom() == null){
                    new RoomDAO().createRoom(r);
                } else{
                    new RoomDAO().updateRoom(r);
                }
            }
        } catch(Exception error){
            throw new CustomException("Erro ao enviar as Salas para salvar no banco de dados: " + error.getMessage());
        }
    }
    
    public static List<Room> findRooms() throws CustomException{
        List<Room> rooms;
        try{
            rooms = new RoomDAO().getRooms();
        } catch(Exception error){
            throw new CustomException("Erro ao consultar no banco de dados: " + error.getMessage());
        }
        return rooms;
    }
}