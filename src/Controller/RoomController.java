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
     * @author Gustavo Lemos
     * @param rooms List<Room> Lista de objetos de salas.
     * @throws CustomException se ocorrer erro ao salvar no banco
     */
    public static void insertRooms(List<Room> rooms){
        try{
            for(Room r : rooms) {
                if (r.getIdRoom() == null){
                    new RoomDAO().createRoom(r);
                }
            }
        } catch(Exception error){
            System.out.println("Não foi possível cadastrar as salas!");
            System.out.println(error.getMessage());
        }
    }

    /**
     * Método responsável retornar a lista de salas.
     *
     * Retorna uma lista de salas com uma lista de usuários presentes em cada turno.
     *
     * @author Gustavo Lemos
     * @return List<Room> Lista de Salas
     */
    public static List<Room> findRooms(){
        List<Room> rooms;
        RoomDAO rd = new RoomDAO();
        UserDAO ud = new UserDAO();
        try {
            rooms = rd.getRooms();
            for (int i=0; i < rooms.size(); i++) {
                rooms.get(i).setUsersStage1(ud.getUsersRoom("id_room1", rooms.get(i).getIdRoom()));
                rooms.get(i).setUsersStage2(ud.getUsersRoom("id_room2", rooms.get(i).getIdRoom()));
            }
        } catch (CustomException error) {
            System.out.println(error.getMessage());
            rooms = new ArrayList<Room>();
        }
        return rooms;
    }

    /**
     * Método para retornar uma sala.
     *
     * Retorna uma lista de salas com uma lista de usuários presentes em cada turno.
     *
     * @return Room Sala
     */
    public static Room findRoom(Integer id){
        Room room;
        try {
            RoomDAO rd = new RoomDAO();
            UserDAO ud = new UserDAO();
            room = rd.getRoom(id);
            room.setUsersStage1(ud.getUsersRoom("id_room1", room.getIdRoom()));
            room.setUsersStage2(ud.getUsersRoom("id_room2", room.getIdRoom()));
        } catch (CustomException error) {
            System.out.println(error.getMessage());
            room = new Room();
        }
        return room;
    }

    /**
     * Método para excluir uma sala.
     *
     * @param room Room
     */
    public static void removeRoom(Room room){
        try{
            new RoomDAO().deleteRoom(room.getIdRoom());
        } catch(CustomException error){
            System.out.println(error.getMessage());
        }
    }
}