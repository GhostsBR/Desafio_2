package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe representativa dos usuários lotados na sala.
 */
public class UsersInRoom {

    private Room room;
    private List<User> usersStage1;
    private List<User> usersStage2;

    public UsersInRoom(){
        this.room = null;
        this.usersStage1 = new ArrayList<User>();
        this.usersStage2 = new ArrayList<User>();
    }

    public UsersInRoom(Room room, List<User> usersStage1, List<User> usersStage2){
        this.room = room;
        this.usersStage1 = usersStage1;
        this.usersStage2 = usersStage2;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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