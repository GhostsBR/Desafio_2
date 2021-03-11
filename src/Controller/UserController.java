package Controller;

import Model.Room;

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
     * Método responsável por selecionar os salas e espaços dos jogadores.
     *
     * São inseridas as salas, espaços e jogadores, o algoritmo seleciona as salas e espaços
     * nas duas estapas, em seguida armazena os dados em um objeto e retorna.
     *
     * @param users
     * @param rooms
     * @param coffees
     * @return
     */
    public static Object userRaffle(ArrayList<String> users, List<Room> rooms, ArrayList<String> coffees) {
        Collections.shuffle(users); // Embaralhar ordem da lista de usuários

        int room = 0;
        int room2 = 0;
        int coffe = 0;
        int coffe2 = 0;
        int smallestRoom = 0;
        int biggestRoom = 0;
        int totalRoom = 0;
        String[][]SelectedPeople = new String[users.size()][5];

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


            SelectedPeople[i][0] = users.get(i);

            SelectedPeople[i][1] = String.valueOf(room);
            rooms.get(room).setQuantity1(rooms.get(room).getQuantity1() + 1);


            room++;
        }

        /*
            Define qual o primeiro espaço de café.
            Distribuindo os usuários pelas salas disponíveis.
            Exemplo: Se existirem duas salas serão adicionados usuários na ordem: 1, 2, 1, 2...
        */
        for(int i=0; i < users.size(); i++) {
            if(coffe >= coffees.size()) {
                coffe = 0;
            }

            SelectedPeople[i][3] = String.valueOf(coffe);
            coffe++;
        }

        /*
            Define a segunda sala dos usuários
            Distribuindo os usuários pelas salas disponíveis, sempre começando da proxima sala em consideração a sala da primeira etapa.
            Exemplo: Etapa 1: Sala 3 Etapa 2: Sala 4.
         */
        for(int i=0; i < users.size(); i++) {
            room2 = (Integer.parseInt(SelectedPeople[i][1]) + 1);
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

            System.out.println("Inserindo: " + (rooms.get(room2).getQuantity2() + 1));
            rooms.get(room2).setQuantity2(rooms.get(room2).getQuantity2() + 1);
            SelectedPeople[i][2] = String.valueOf(room2);
        }

        /*
            Define qual o segundo espaço de café.
            Enviando o usuário para a proxima sala, em relação a etapa anterior.
            Exemplo: Etapa anterior: 1 Etapa atual: 2.
        */
        for(int i=0; i < users.size(); i++) {
            coffe2 = Integer.parseInt(SelectedPeople[i][3]) + 1;
            if(coffe2 >= coffees.size()) {
                coffe2 = 0;
            }

            SelectedPeople[i][4] = String.valueOf(coffe2);
            System.out.println("Nome: " + SelectedPeople[i][0] + " \t|\t Primeira Sala: " + SelectedPeople[i][1] + "\t|\tPrimeiro Espaço: " + SelectedPeople[i][3] + "\t|\tSegunda Sala: " + SelectedPeople[i][2] + "\t|\tSegundo Café: " + SelectedPeople[i][4]);
        }

        System.out.println("Usuários na sala 1\n P1: " + rooms.get(0).getQuantity1() + " P2: " + rooms.get(0).getQuantity2());
        System.out.println("Usuários na sala 2:\n  P1: " +rooms.get(1).getQuantity1()+ " P2: " + rooms.get(1).getQuantity2());

        //Retorna a lista de usuários em forma de matriz na seguinde ordem: NOME, PRIMEIRA SALA, PRIMEIRO ESPAÇO, SEGUNDA SALA, SEGUNDO ESPAÇO.
        return SelectedPeople;
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
