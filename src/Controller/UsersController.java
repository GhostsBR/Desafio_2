package Controller;

import java.util.ArrayList;

public class UsersController {
    public static Object userRaffle(ArrayList<String> users, String[][] rooms, ArrayList<String> coffes) {

        int room = 0;
        int room2 = 0;
        int coffe = 0;
        int coffe2 = 0;
        String[][]SelectedPeople = new String[users.size()][5];

        for(int i=0; i < users.size(); i++) {
            if(room >= rooms.length) {
                room = 0;
            }

            SelectedPeople[i][0] = users.get(i);
            SelectedPeople[i][1] = String.valueOf(room);


            room++;
        }

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

        for(int i=0; i < users.size(); i++) {
            room2 = (Integer.parseInt(SelectedPeople[i][1]) + 1);
            if(room2 >= rooms.length) {
                room2 = 0;
            }

            SelectedPeople[i][2] = String.valueOf(room2);
            room2++;
        }

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


        return SelectedPeople;
    }
}
