package Controller;

import java.util.ArrayList;
import java.util.Collections;

public class UsersController {
    public static Object userRaffle(ArrayList<String> users, String[][] rooms, ArrayList<String> coffes) {

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
        for(int i=0; i < rooms.length; i++) {
            if(i == 0) {
                smallestRoom = Integer.parseInt(rooms[i][1]);
            } else if(Integer.parseInt(rooms[i][1]) < smallestRoom) {
                smallestRoom = Integer.parseInt(rooms[i][1]);
            }
        }

        for(int i=0; i < rooms.length; i++) {
            if(Integer.parseInt(rooms[i][1]) > smallestRoom) {
                biggestRoom++;
            }
        }

        // verifica se existem mais usuários que vagas disponíveis.
        totalRoom = ((smallestRoom * rooms.length) + biggestRoom);
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
            if(room >= rooms.length) {
                room = 0;
            }

            if(Integer.parseInt(rooms[room][1]) == smallestRoom) {
                if((Integer.parseInt(rooms[room][2]) + 1) > (smallestRoom)) {
                    room = verifyBetterRoom(rooms, room, 2, smallestRoom);
                }
            } else {
                if((Integer.parseInt(rooms[room][2]) + 1) > (Integer.parseInt(rooms[room][1]) + 1)) {
                    room = verifyBetterRoom(rooms, room, 2, smallestRoom);
                }
            }

            if(room >= rooms.length) {
                room = 0;
            }


            SelectedPeople[i][0] = users.get(i);

            SelectedPeople[i][1] = String.valueOf(room);
            rooms[room][2] = String.valueOf(Integer.parseInt(rooms[room][2]) + 1);


            room++;
        }

        /*
            Define qual o primeiro espaço de café.
            Distribuindo os usuários pelas salas disponíveis.
            Exemplo: Se existirem duas salas serão adicionados usuários na ordem: 1, 2, 1, 2...
        */
        for(int i=0; i < users.size(); i++) {
            if(coffe >= coffes.size()) {
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
            if(room2 >= rooms.length) {
                room2 = 0;
            }

            if(Integer.parseInt(rooms[room2][1]) == smallestRoom) {
                if((Integer.parseInt(rooms[room2][3]) + 1) > (smallestRoom)) {
                    room2 = verifyBetterRoom(rooms, room2, 3, smallestRoom);
                }
            } else {
                if((Integer.parseInt(rooms[room2][3]) + 1) > (Integer.parseInt(rooms[room2][1]) + 1)) {
                    room2 = verifyBetterRoom(rooms, room2, 3, smallestRoom);
                }
            }

            if(room2 >= rooms.length) {
                room2 = 0;
            }

            rooms[room2][3] = String.valueOf(Integer.parseInt(rooms[room2][3]) + 1);
            SelectedPeople[i][2] = String.valueOf(room2);
        }

        /*
            Define qual o segundo espaço de café.
            Enviando o usuário para a proxima sala, em relação a etapa anterior.
            Exemplo: Etapa anterior: 1 Etapa atual: 2.
        */
        for(int i=0; i < users.size(); i++) {
            coffe2 = Integer.parseInt(SelectedPeople[i][3]) + 1;
            if(coffe2 >= coffes.size()) {
                coffe2 = 0;
            }

            SelectedPeople[i][4] = String.valueOf(coffe2);
            System.out.println("Nome: " + SelectedPeople[i][0] + " \t|\t Primeira Sala: " + SelectedPeople[i][1] + "\t|\tPrimeiro Espaço: " + SelectedPeople[i][3] + "\t|\tSegunda Sala: " + SelectedPeople[i][2] + "\t|\tSegundo Café: " + SelectedPeople[i][4]);
        }

        System.out.println("Usuários na sala 1\n P1: " +rooms[0][2]+ " P2: " + rooms[0][3]);
        System.out.println("Usuários na sala 2:\n  P1: " +rooms[1][2]+ " P2: " + rooms[1][3]);
        System.out.println("Usuários na sala 3:\n  P1: " +rooms[2][2]+ " P2: " + rooms[2][3]);

        //Retorna a lista de usuários em forma de matriz na seguinde ordem: NOME, PRIMEIRA SALA, PRIMEIRO ESPAÇO, SEGUNDA SALA, SEGUNDO ESPAÇO.
        return SelectedPeople;
    }


    //Verifica qual é a melhor sala caso a sala selecionada esteja cheia.
    private static int verifyBetterRoom(String[][] rooms, int room, int stage, int smallestRoom) {
        int betterRoom = 0;
        for(int i=0; i < rooms.length; i++) {
            if(Integer.parseInt(rooms[i][1]) != smallestRoom) {
                if((smallestRoom + 1) > (Integer.parseInt(rooms[i][stage]))) {
                    if(((smallestRoom + 1) - Integer.parseInt(rooms[i][stage])) > betterRoom) {
                        betterRoom = i;
                    }
                }
            }
        }

        return betterRoom;
    }
}
