package Controller;

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
     * @param rooms List<Room> Lista de objetos de salas.
     */
    public static void insertRoom(List<Room> rooms) {
        for(int i=0; i < rooms.size(); i++) {
            new RoomDAO().createRoom(rooms.get(i));
        }
    }
}
