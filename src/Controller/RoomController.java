package Controller;

import CustomExceptions.CustomException;
import Model.Room;
import Model.RoomDAO;
import Model.UserDAO;

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
     * @author Gustavo
     * @param rooms List<Room> Lista de objetos de salas.
     * @throws CustomException se ocorrer erro ao salvar no banco
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

    /**
     * Método responsável retornar a lista de salas.
     *
     * Retorna uma lista de salas com uma lista de usuários presentes em cada turno.
     *
     * @author Gustavo
     * @return List<Room> Lista de Salas
     * @throws CustomException
     */
    public static List<Room> findRooms() throws CustomException{
        try {
            RoomDAO rd = new RoomDAO();
            UserDAO ud = new UserDAO();

            List<Room> rooms = rd.getRooms();
            for (int i=0; i < rooms.size(); i++) {
                rooms.get(i).setUsersStage1(ud.getUsersRoom("id_room1", rooms.get(i).getIdRoom()));
                rooms.get(i).setUsersStage2(ud.getUsersRoom("id_room2", rooms.get(i).getIdRoom()));
            }

            return rooms;
        } catch (CustomException error) {
            throw new CustomException("ERRO: " + error.getMessage());
        }
    }
}