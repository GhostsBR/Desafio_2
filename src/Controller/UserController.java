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
     * @param users List<User> Lista de objetos de usuários.
     */
    public static void insertUser(List<User> users) throws CustomException {
        for(int i=0; i < users.size(); i++) {
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
    }

    /**
     * Método responsável por selecionar os salas e espaços dos jogadores.
     *
     * São inseridas as salas, espaços e jogadores, o algoritmo seleciona as salas e espaços
     * nas duas estapas, em seguida armazena os dados em uma lista objetos e retorna.
     *
     * @param users
     * @param rooms List<Room> Lista de objetos de sala.
     * @param coffees List<Coffee> Lista de objetos de espaços.
     * @return
     */
    public static Object userRaffle(List<User> users, List<Room> rooms, List<Coffee> coffees) {
        Collections.shuffle(users); // Embaralhar ordem da lista de usuários

        int room = 0;
        int room2 = 0;
        int coffee = 0;
        int coffee2 = 0;
        int smallestRoom = 0;
        int biggestRoom = 0;
        int totalRoom = 0;

        // Verifica qual é a menor sala.
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

        // verifica se existem mais usuários que vagas disponíveis.
        totalRoom = ((smallestRoom * rooms.size()) + biggestRoom);
        if(users.size() > totalRoom) {
            System.out.println("ERRO: Foi adicionado mais usuários do que possível!");
            return null;
        }

        System.out.println("Lotação máxima: " + totalRoom);

        /*
            Define a primeira sala dos usuários.
            Distribuindo os usuários pelas salas disponíveis em ordem.
            Exemplo: Se existirem 3 salas, serão adicionados usuários na ordem: 1, 2, 3, 1, 2, 3...
        */
        for(int i=0; i < users.size(); i++) {
            if(room >= rooms.size()) {
                room = 0;
            }

            if(rooms.get(room).getCapacityRoom() == smallestRoom) {
                if((rooms.get(room).getQuantity1() + 1) > (smallestRoom)) {
                    room = verifyBetterRoom(rooms, room, 1, smallestRoom);
                }
            } else {
                if((rooms.get(room).getQuantity1() + 1) > (rooms.get(room).getCapacityRoom() + 1)) {
                    room = verifyBetterRoom(rooms, room, 1, smallestRoom);
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
            rooms.get(room).setQuantity1(rooms.get(room).getQuantity1() + 1);


            room++;
        }

        /*
            Define qual o primeiro espaço de café.
            Distribuindo os usuários pelas salas disponíveis.
            Exemplo: Se existirem duas salas serão adicionados usuários na ordem: 1, 2, 1, 2...
        */
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
            Define a segunda sala dos usuários
            Distribuindo os usuários pelas salas disponíveis, sempre começando da proxima sala em consideração a sala da primeira etapa.
            Exemplo: Etapa 1: Sala 3 Etapa 2: Sala 4.
         */
        for(int i=0; i < users.size(); i++) {
            room2 = (users.get(i).getPositionRoom() + 1);
            if(room2 >= rooms.size()) {
                room2 = 0;
            }

            if(rooms.get(room2).getCapacityRoom() == smallestRoom) {
                if((rooms.get(room2).getQuantity2() + 1) > (smallestRoom)) {
                    room2 = verifyBetterRoom(rooms, room2, 2, smallestRoom);
                }
            } else {
                if((rooms.get(room2).getQuantity2() + 1) > (rooms.get(room2).getCapacityRoom() + 1)) {
                    room2 = verifyBetterRoom(rooms, room2, 2, smallestRoom);
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

        /*
            Define qual o segundo espaço de café.
            Enviando o usuário para a proxima sala, em relação a etapa anterior.
            Exemplo: Etapa anterior: 1 Etapa atual: 2.
        */
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

        //Retorna a lista de usuários em forma de matriz na seguinde ordem: NOME, PRIMEIRA SALA, PRIMEIRO ESPAÇO, SEGUNDA SALA, SEGUNDO ESPAÇO.
        return users;
    }


    /**
     * Método responsável por selecionar a melhor sala.
     *
     * Caso a sala atual esteja cheia, é selecionada a sala com mais espaços livres.
     *
     * @param rooms
     * @param room
     * @param stage
     * @param smallestRoom
     * @return
     */
    private static int verifyBetterRoom(List<Room> rooms, int room, int stage, int smallestRoom) {
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