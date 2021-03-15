package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe representativa dos usuários lotados no Espaço de Café.
 */
public class UsersInCoffee {
    private Coffee coffee;
    private List<User> usersStage1;
    private List<User> usersStage2;

    public UsersInCoffee(){
        this.coffee = null;
        this.usersStage1 = new ArrayList<User>();
        this.usersStage2 = new ArrayList<User>();
    }

    public UsersInCoffee(Coffee coffee, List<User> usersStage1, List<User> usersStage2){
        this.coffee = coffee;
        this.usersStage1 = usersStage1;
        this.usersStage2 = usersStage2;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public List<User> getUsersStage1() {
        return usersStage1;
    }

    public void setUsersStage1(List<User> usersStage1) {
        this.usersStage1 = usersStage1;
    }

    public List<User> getUsersStage2() {
        return usersStage2;
    }

    public void setUsersStage2(List<User> usersStage2) {
        this.usersStage2 = usersStage2;
    }

    public String usersStage1ToString (){
        String users = "";
        for (User u: usersStage1) {
            users += u.getNameUser() + ", ";
        }
        users = users.substring(0, users.length() - 3);
        return users;
    }

    public String usersStage2ToString (){
        String users = "";
        for (User u: usersStage2) {
            users += u.getNameUser() + ", ";
        }
        users = users.substring(0, users.length() - 3);
        return users;
    }
}