package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseController {
    //Cria a pré conexão.
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

    //Cria a conexão com o banco de dados.
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
