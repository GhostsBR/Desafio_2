package Database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe responsável por disponibilizar conexões com o banco de dados
 * @author João, Gustavo, Thiago
 */
public class ConnectionFactory {

    // Objeto Connection para conexão com o MySQL fornecido pela classe
    private static Connection connectMySQL = null;

    // Objeto Connection para conexão com o banco de dados fornecido pela classe
    private static Connection connectDatabase = null;

    // URL para criar a conexão com o MySQL
    private static String urlMySQL = "jdbc:mysql://localhost:3306";

    // URL para criar a conexão com o Banco de dados
    private static String urlDatabase = "jdbc:mysql://localhost:3306/event";

    // Nome do user utilizado para criar as conexões
    private static String user = "root";

    // Senha utilizado para criar as conexões
    private static String password = "";

    /**
     * Método para criar uma conexão com o MySQL e permitir
     * criar o banco de dados
     * @return Connection
     */
    public static Connection preConnect(){
        // Verifica se a conexão é nula
        if (connectMySQL == null){
            // Cria uma nova conexão com o MySQL
            newConnectionMySQL();
        } else {
            try{
                // Verifica se a conexão está fechada
                if (connectMySQL.isClosed()){
                    // Cria uma nova conexão com o MySQL
                    newConnectionMySQL();
                }
            } catch(Exception error){
                System.out.println(error.getMessage());
            }
        }
        // Retorna um conexão, seja ela nova ou uma já aberta
        return connectMySQL;
    }

    /**
     * Método para criar uma conexão com o banco de dados
     * @return Connection
     */
    public static Connection connect(){
        // Verifica se a conexão é nula
        if (connectDatabase == null){
            // Cria uma nova conexão com o banco de dados
            newConnectionDatabase();
        } else {
            try{
                // Verifica se a conexão está fechada
                if (connectDatabase.isClosed()){
                    // Cria uma nova conexão com o MySQL
                    newConnectionDatabase();
                }
            } catch(Exception error){
                System.out.println(error.getMessage());
            }
        }
        // Retorna um conexão, seja ela nova ou uma já aberta
        return connectDatabase;
    }

    /**
     * Método interno para gerar uma nova conexão ao MySQL
     * @author Thiago
     */
    private static void newConnectionMySQL(){
        try {
            // Pega uma nova conexão ao MySQL
            connectMySQL = DriverManager.getConnection(urlMySQL,user,password);

            //Mostra qual conexão foi criada
            System.out.println("Nova conexão criada: " + urlMySQL);
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }

    /**
     * Método interno para gerar uma nova conexão ao MySQL
     * @author Thiago
     */
    private static void newConnectionDatabase(){
        try {
            // Pega uma nova conexão ao banco de dados
            connectDatabase = DriverManager.getConnection(urlDatabase,user,password);

            //Mostra qual conexão foi criada
            System.out.println("Nova conexão criada: " + urlDatabase);
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }

    /**
     * Método para fechar a conexão com o MySQL
     * @author Thiago
     */
    public static void closeConnectionMySQL(){
        try{
            // Fecha a conexão
            connectMySQL.close();

            //Mostra que a conexão foi fechada
            System.out.println("Conexão fechada!");
        } catch(Exception error){
            System.out.println(error.getMessage());
        }
    }

    /**
     * Método para fechar a conexão com o banco de dados
     * @author Thiago
     */
    public static void closeConnectionDatabase(){
        try{
            // Fecha a conexão
            connectDatabase.close();

            //Mostra que a conexão foi fechada
            System.out.println("Conexão fechada!");
        } catch(Exception error){
            System.out.println(error.getMessage());
        }
    }
}