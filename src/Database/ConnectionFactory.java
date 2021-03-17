package Database;

import CustomExceptions.CustomException;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe responsável por disponibilizar conexões com o banco de dados.
 *
 * Utiliza o padrão Factory.
 *
 * @author João
 * @author Gustavo
 * @author Thiago
 */
public class ConnectionFactory {

    /**
     * Objeto Connection para conexão com o MySQL fornecido pela classe.
     */
    private static Connection connectMySQL = null;

    /**
     * Objeto Connection para conexão com o banco de dados fornecido pela classe.
     */
    private static Connection connectDatabase = null;

    /**
     * Objeto Connection para conexão extra com o banco de dados fornecido pela classe.
     */
    private static Connection connectDatabaseExtra = null;

    /**
     * URL para criar a conexão com o MySQL.
     */
    private static String urlMySQL = "jdbc:mysql://localhost:3306";

    /**
     * URL para criar a conexão com o Banco de dados.
     */
    private static String urlDatabase = "jdbc:mysql://localhost:3306/event";

    /**
     * Nome do user utilizado para criar as conexões.
     */
    private static String user = "root";

    /**
     * Senha utilizado para criar as conexões.
     */
    private static String password = "";

    /**
     * Método para criar uma conexão com o MySQL e permitir criar o banco de dados.
     *
     * Verifica se o objeto Connection da classe referente ao acesso ao MySQL é nulo,
     * para então criar uma nova conexão e retorná-la. Caso não for nulo, verifica
     * se a conexão já está aberta, retornando-a em caso positivo. Caso esta não
     * esteja aberta, cria uma nova conexão e a retorna.
     *
     * @author João
     * @author Thiago
     *
     * @return Connection nova conexão com o MySQL
     * @throws CustomException se connectMySQL for nulo
     */
    public static Connection preConnect() throws CustomException {
        if (connectMySQL == null){
            newConnectionMySQL();
        } else {
            try{
                if (connectMySQL.isClosed()){
                    newConnectionMySQL();
                }
            } catch(Exception error){
                throw new CustomException("Erro ao verificar se a conexão ao MySQL está fechada: " + error.getMessage());
            }
        }
        return connectMySQL;
    }

    /**
     * Método para criar uma conexão com o banco de dados.
     *
     * Verifica se o objeto Connection da classe referente ao acesso ao banco de dados
     * "event" é nulo, para então criar uma nova conexão e retorná-la. Caso não for nulo,
     * verifica se a conexão já está aberta, retornando-a em caso positivo. Caso esta
     * não esteja aberta, cria uma nova conexão e a retorna.
     *
     * @author João
     * @author Thiago
     *
     * @return Connection nova conexão com o banco de dados
     * @throws CustomException se connectDatabase for nulo
     */
    public static Connection connect() throws CustomException{
        if (connectDatabase == null){
            newConnectionDatabase();
        } else {
            try{
                if (connectDatabase.isClosed()){
                    newConnectionDatabase();
                }
            } catch(Exception error){
                throw new CustomException("Erro ao verificar se a conexão ao banco está fechada: " + error.getMessage());
            }
        }
        return connectDatabase;
    }

    /**
     * Método para criar uma conexão com o banco de dados.
     *
     * Verifica se o objeto Connection da classe referente ao acesso ao banco de dados
     * "event" é nulo, para então criar uma nova conexão e retorná-la. Caso não for nulo,
     * verifica se a conexão já está aberta, retornando-a em caso positivo. Caso esta
     * não esteja aberta, cria uma nova conexão e a retorna.
     *
     * @author João
     * @author Thiago
     *
     * @return Connection nova conexão extra com o banco de dados
     * @throws CustomException se connectDatabase for nulo
     */
    public static Connection connectExtra() throws CustomException{
        if (connectDatabaseExtra == null){
            newConnectionDatabaseExtra();
        } else {
            try{
                if (connectDatabaseExtra.isClosed()){
                    newConnectionDatabaseExtra();
                }
            } catch(Exception error){
                throw new CustomException("Erro ao verificar se a conexão ao banco está fechada: " + error.getMessage());
            }
        }
        return connectDatabaseExtra;
    }

    /**
     * Método interno para gerar uma nova conexão ao MySQL.
     *
     * Gera uma nova conexão ao MySQL através dos dados da URL,
     * usuário e senha.
     *
     * @author Thiago
     * @throws CustomException se ocorrer erros de acesso ao MySQL
     */
    private static void newConnectionMySQL() throws CustomException{
        try {
            connectMySQL = DriverManager.getConnection(urlMySQL,user,password);
        }catch (Exception error){
            throw new CustomException("Erro ao solicitar uma nova conexão ao MySQL: " + error.getMessage());
        }
    }

    /**
     * Método interno para gerar uma nova conexão ao banco de dados.
     *
     * Gera uma nova conexão ao banco de dados através dos dados da URL,
     * usuário e senha.
     *
     * @author Thiago
     * @throws CustomException se ocorrer erros de acesso ao banco de dados
     */
    private static void newConnectionDatabase() throws CustomException{
        try {
            connectDatabase = DriverManager.getConnection(urlDatabase,user,password);
        }catch (Exception error){
            throw new CustomException("Erro ao solicitar uma nova conexão ao banco de dados: " + error.getMessage());
        }
    }

    /**
     * Método interno para gerar uma nova conexão ao banco de dados.
     *
     * Gera uma nova conexão ao banco de dados através dos dados da URL,
     * usuário e senha.
     *
     * @author Thiago
     * @throws CustomException se ocorrer erros de acesso ao banco de dados
     */
    private static void newConnectionDatabaseExtra() throws CustomException{
        try {
            connectDatabaseExtra = DriverManager.getConnection(urlDatabase,user,password);
        }catch (Exception error){
            throw new CustomException("Erro ao solicitar uma nova conexão ao banco de dados: " + error.getMessage());
        }
    }

    /**
     * Método para fechar a conexão com o MySQL.
     *
     * Deve ser chamado toda vez que finalizar o processo de utilização
     * da conexão ao MySQL.
     *
     * @author Thiago
     * @throws CustomException se connectMySQL for nulo
     */
    public static void closeConnectionMySQL() throws CustomException{
        try{
            connectMySQL.close();
        } catch(Exception error){
            throw new CustomException("Erro ao fechar a conexão ao MySQL: " + error.getMessage());
        }
    }

    /**
     * Método para fechar a conexão com o banco de dados.
     *
     * Deve ser chamado toda vez que finalizar o processo de utilização
     * da conexão ao banco de dados.
     *
     * @author Thiago
     * @throws CustomException se connectMySQL for nulo
     */
    public static void closeConnectionDatabase() throws CustomException{
        try{
            connectDatabase.close();
        } catch(Exception error){
            throw new CustomException("Erro ao fechar a conexão ao MySQL: " + error.getMessage());
        }
    }

    /**
     * Método para fechar a conexão com o banco de dados.
     *
     * Deve ser chamado toda vez que finalizar o processo de utilização
     * da conexão ao banco de dados.
     *
     * @author Thiago
     * @throws CustomException se connectMySQL for nulo
     */
    public static void closeConnectionDatabaseExtra() throws CustomException{
        try{
            connectDatabaseExtra.close();
        } catch(Exception error){
            throw new CustomException("Erro ao fechar a conexão ao MySQL: " + error.getMessage());
        }
    }
}