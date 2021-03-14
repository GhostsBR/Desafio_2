package Controller;

import CustomExceptions.CustomException;
import Model.Coffee;
import Model.Room;
import Model.User;
import Model.UserDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe responsável pelo controle dos usuários.
 *
 * @author Gustavo Lemos
 */
public class UserController {

    /**
     * Método responsável por separar e enviar os usuários para serem inseridos no banco de dados.
     *
     * Apôs o recebimento de uma lista de objetos, o método separa os usuários
     * e realiza o envido ao método responsável por inserir no banco de dados.
     *
     * @param users List<User> Lista de usuários
     */
    public static void insertUser(List<User> users) throws CustomException {
        try {
            for (User c : users) {
                if(c.getIdUser() == null) {
                    new UserDAO().createUser(c);
                } else {
                    new UserDAO().updateUser(c);
                }
            }
        } catch (Exception error) {
            throw new CustomException("Erro ao enviar pessoas para salvar no banco: " + error.getMessage());
        }
    }

    /**
     * Método responsável por selecionar os salas e espaços dos jogadores.
     *
     * São inseridas as salas, espaços e jogadores, o algoritmo seleciona as salas e espaços
     * nas duas estapas, em seguida armazena os dados em uma lista objetos e retorna.
     *
     * @param users List<User> Lista de usuários
     * @param rooms List<Room> Lista de salas
     * @param coffees List<Coffee> Lista de espaços
     * @return List<User> Lista de usuários com as salas e espaços definidas
     */
    public static List<User> userRaffle(List<User> users, List<Room> rooms, List<Coffee> coffees) throws CustomException{
        Collections.shuffle(users);

        int room = 0;
        int room2 = 0;
        int coffee = 0;
        int coffee2 = 0;
        int smallestRoom = 0;
        int biggestRoom = 0;
        int totalRoom = 0;

        for(int i=0; i < rooms.size(); i++) {
            if(i == 0) {
                smallestRoom = rooms.get(i).getCapacityRoom();
            } else if(rooms.get(i).getCapacityRoom() < smallestRoom) {
                smallestRoom = rooms.get(i).getCapacityRoom();
            }
        }

        for(int i=0; i < rooms.size(); i++) {
            if(rooms.get(i).getCapacityRoom() > smallestRoom) {
                biggestRoom++;
            }
        }

        totalRoom = ((smallestRoom * rooms.size()) + biggestRoom);
        if(users.size() > totalRoom) {
            throw new CustomException("ERRO: Foi adicionado mais usuários do que possível!");
        }

        for(int i=0; i < users.size(); i++) {
            if(room >= rooms.size()) {
                room = 0;
            }

            if(rooms.get(room).getCapacityRoom() == smallestRoom) {
                if((rooms.get(room).getQuantity1() + 1) > (smallestRoom)) {
                    room = verifyBetterRoom(rooms, 1, smallestRoom);
                }
            } else {
                if((rooms.get(room).getQuantity1() + 1) > (rooms.get(room).getCapacityRoom() + 1)) {
                    room = verifyBetterRoom(rooms, 1, smallestRoom);
                }
            }

            if(room >= rooms.size()) {
                room = 0;
            }


            try {
                users.get(i).setRoom1User(rooms.get(room));
            } catch (CustomException error) {
                System.out.println("Erro ao definir o número de usuários na sala 1: " + error.getMessage());
            }
            users.get(i).setPositionRoom(room);
            users.get(i).setIdTemp(i);
            rooms.get(room).setUsers(users.get(i));
            rooms.get(room).setQuantity1(rooms.get(room).getQuantity1() + 1);


            room++;
        }


        for(int i=0; i < users.size(); i++) {
            if(coffee >= coffees.size()) {
                coffee = 0;
            }

            try {
                users.get(i).setCoffee1User(coffees.get(coffee));
            } catch (CustomException error) {
                System.out.println("Erro ao definir o número de usuários da espaço 1: " + error.getMessage());
            }
            users.get(i).setPositionCoffee(coffee);
            coffee++;
        }

        /*
        for(int i=0; i < users.size(); i++) {
            room2 = (users.get(i).getPositionRoom() + 1);
            if(room2 >= rooms.size()) {
                room2 = 0;
            }

            if(rooms.get(room2).getCapacityRoom() == smallestRoom) {
                if((rooms.get(room2).getQuantity2() + 1) > (smallestRoom)) {
                    room2 = verifyBetterRoom(rooms,2, smallestRoom);
                }
            } else {
                if((rooms.get(room2).getQuantity2() + 1) > (rooms.get(room2).getCapacityRoom() + 1)) {
                    room2 = verifyBetterRoom(rooms, 2, smallestRoom);
                }
            }

            if(room2 >= rooms.size()) {
                room2 = 0;
            }

            rooms.get(room2).setQuantity2(rooms.get(room2).getQuantity2() + 1);
            try {
                users.get(i).setRoom2User(rooms.get(room2));
            } catch (CustomException error) {
                System.out.println("Erro ao definir o número de usuários na sala 2: " + error.getMessage());
            }
        }

         */

        for (int i=0; i < rooms.size(); i++) {
            room2++;
            for (int n=0; n < rooms.get(i).getUsers().size(); n++) {
                if(room2 >= rooms.size()) {
                    room2 = 0;
                }

                /*
                if(rooms.get(room2).getCapacityRoom() == smallestRoom) {
                    if((rooms.get(room2).getQuantity2() + 1) > (smallestRoom)) {
                        room2 = verifyBetterRoom(rooms,2, smallestRoom);
                    }
                } else {
                    if((rooms.get(room2).getQuantity2() + 1) > (rooms.get(room2).getCapacityRoom() + 1)) {
                        room2 = verifyBetterRoom(rooms, 2, smallestRoom);
                    }
                }

                 */

                if(room2 >= rooms.size()) {
                    room2 = 0;
                }


                rooms.get(room2).setQuantity2(rooms.get(room2).getQuantity2() + 1);

                try {
                    users.get(rooms.get(i).getUsers().get(n).getIdTemp()).setRoom2User(rooms.get(room2));
                } catch (CustomException error) {
                    System.out.println("Erro ao definir o número de usuários na sala 2: " + error.getMessage());
                }

                room2++;
            }
        }


        for(int i=0; i < users.size(); i++) {
            coffee2 = (users.get(i).getPosictonCoffee() + 1);
            if(coffee2 >= coffees.size()) {
                coffee2 = 0;
            }

            try {
                users.get(i).setCoffee2User(coffees.get(coffee2));
            } catch (CustomException error) {
                System.out.println("Erro ao definir o número de usuários no espaço 2: " + error.getMessage());
            }
            System.out.println("Nome: " + users.get(i).getNameUser() + "\t|\t Primeira Sala: " +users.get(i).getRoom1User().getIdRoom() + "\t|\t Primeiro Espaço: " +users.get(i).getCoffee1User().getIdCoffee() + "\t|\t Segunda Sala: " +users.get(i).getRoom2User().getIdRoom() + "\t|\t Segundo Espaço: " +users.get(i).getCoffee2User().getIdCoffee());
        }

        for(int i=0; i < rooms.size(); i++) {
            System.out.println("Usuários na sala " + (i + 1) + "\n P1: " + rooms.get(i).getQuantity1() + " P2: " + rooms.get(i).getQuantity2());
        }

        return users;
    }


    /**
     * Método responsável por selecionar a melhor sala.
     *
     * Caso a sala atual esteja cheia, é selecionada a sala com mais espaços livres.
     *
     * @param rooms List<Room> Lista de salas
     * @param stage int Informa qual etapa está sendo analisada.
     * @param smallestRoom int Informal qual a menor sala.
     * @return int Retorna o ID da melhor sala
     */
    private static int verifyBetterRoom(List<Room> rooms, int stage, int smallestRoom) {
        int betterRoom = 0;
        for(int i=0; i < rooms.size(); i++) {
            if(stage == 1) {
                if(rooms.get(i).getCapacityRoom() != smallestRoom) {
                    if((smallestRoom + 1) > (rooms.get(i).getQuantity1())) {
                        if(((smallestRoom + 1) - rooms.get(i).getQuantity1()) > betterRoom) {
                            betterRoom = i;
                        }
                    }
                }
            } else {
                if(rooms.get(i).getCapacityRoom() != smallestRoom) {
                    if((smallestRoom + 1) > (rooms.get(i).getQuantity2())) {
                        if(((smallestRoom + 1) - rooms.get(i).getQuantity2()) > betterRoom) {
                            betterRoom = i;
                        }
                    }
                }
            }
        }
        return betterRoom;
    }
}