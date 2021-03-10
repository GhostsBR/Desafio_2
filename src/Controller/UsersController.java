package Controller;

import java.util.ArrayList;

public class UsersController {
    public static Object userRaffle(ArrayList<String> users, String[][] rooms, ArrayList<String> coffes) {

        int room = 0;
        int room2 = 0;
        int coffe = 0;
        int coffe2 = 0;
        String[][]SelectedPeople = new String[users.size()][5];

        /*
            Define a primeira sala dos usuários.
            Distribuindo os usuários pelas salas disponíveis em ordem.
            Exemplo: Se existirem 3 salas, seram adicionados usuários na ordem: 1, 2, 3, 1, 2, 3...
        */
        for(int i=0; i < users.size(); i++) {
            if(room >= rooms.length) {
                room = 0;
            }

            SelectedPeople[i][0] = users.get(i);
            SelectedPeople[i][1] = String.valueOf(room);


            room++;
        }

        /*
            Define qual o primeiro espaço de café.
            Dividindo a lista de usuários em dois, cada parte fica em um espaço de café diferente.
            Exemplo: (6 / 2 = 3) ou seja 3 usuários no espaço 1 e 3 usuários no espaço 2.
        */
        for(int i=0; i < users.size(); i++) {
            if(i < (users.size() / 2)) {
                coffe = 0;
                coffe2 = 1;
            } else {
                coffe = 1;
                coffe2 = 0;
            }

            if(coffe >= coffes.size()) {
                coffe = 0;
            }

            SelectedPeople[i][3] = String.valueOf(coffe);
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

            SelectedPeople[i][2] = String.valueOf(room2);
            room2++;
        }

        /*
            Define qual o segundo espaço de café.
            Dividindo a lista de usuários em dois, cada parte fica em um espaço de café diferente da etapa anterior.
            Exemplo: Etapa anterior: 1 Etapa atual: 2.
        */
        for(int i=0; i < users.size(); i++) {
            if(i < (users.size() / 2)) {
                coffe2 = 1;
            } else {
                coffe2 = 0;
            }

            if(coffe2 >= coffes.size()) {
                coffe2 = 0;
            }

            SelectedPeople[i][4] = String.valueOf(coffe2);
            System.out.println("Nome: " + SelectedPeople[i][0] + " \t|\t Primeira Sala: " + SelectedPeople[i][1] + "\t|\tPrimeiro Espaço: " + SelectedPeople[i][3] + "\t|\tSegunda Sala: " + SelectedPeople[i][2] + "\t|\tSegundo Café: " + SelectedPeople[i][4]);
        }

        //Retorna a lista de usuários em forma de matriz na seguinde ordem: NOME, PRIMEIRA SALA, PRIMEIRO ESPAÇO, SEGUNDA SALA, SEGUNDO ESPAÇO.
        return SelectedPeople;
    }
}
