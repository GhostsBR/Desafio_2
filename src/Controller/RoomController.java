package Controller;

import CustomExceptions.CustomException;
import Model.Room;
import Model.RoomDAO;
import Model.User;
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
        RoomDAO rd = new RoomDAO();
        UserDAO ud = new UserDAO();

        List<Room> rooms = rd.getRooms();
        List<User> us = ud.getUsers();
        for (int i=0; i < rooms.size(); i++) {
            System.out.println("Buscou sala");
            List<User> e1 = new ArrayList<User>();
            List<User> e2 = new ArrayList<User>();
            for (int n=0; n < ud.getUsers().size(); n++) {
                System.out.println("Buscou user");
                if(rooms.get(i).getIdRoom() == us.get(n).getRoom1User().getIdRoom()) {
                    e1.add(ud.getUsers().get(n));
                }
                if(rooms.get(i).getIdRoom() == us.get(n).getRoom2User().getIdRoom()) {
                    e2.add(ud.getUsers().get(n));
                }
            }
            rooms.get(i).setUsersStage1(e1);
            rooms.get(i).setUsersStage1(e2);
        }

        return rooms;
    }
}