package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseController {
    public static Connection preConnect(){
        Connection connect = null;
        try {
            String url = "jdbc:mysql://localhost";
            String user = "root";
            String password = "";
            connect = DriverManager.getConnection(url,user,password);
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
        return connect;
    }

    public static Connection connect(){
        Connection connect = null;

        try {
            String url = "jdbc:mysql://localhost/event";
            String user = "root";
            String password = "";
            connect = DriverManager.getConnection(url,user,password);
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
        return connect;
    }
}
