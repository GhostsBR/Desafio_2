package Database;

import CustomExceptions.CustomException;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe responsável por criar o banco de dados.
 *
 * Utilizado para automatizar a criação do banco de dados caso ele não exista.
 *
 * @author João
 * @author Gustavo
 * @author Thiago
 */
public class DatabaseCreator {

    /**
     * Método para gerar o banco de dados.
     *
     * Cria um objeto PreparedStatement usado no método, permitindo fecha-lo ao final do processo.
     * Solicita-se uma conexão com o MySQL pelo ConnectionFactory para gerar o banco de dados.
     * Após gerar o banco, solicita-se uma conexão com o banco de dados pelo ConnectionFactory
     * para gerar a tabela "rooms", que representa a classe Model.Room. Em seguida, solicita-se
     * uma conexão com o banco de dados pelo ConnectionFactory para gerar a tabela "coffees",
     * que representa a classe Model.Coffee. Com essas duas tabelas geradas no banco, pode-se
     * gerar a tabela "users" e criar os relacionamentos entre ela e as tabelas "rooms" e "coffees".
     * Ao final, fecha as conexões com o MySQL e com o banco de dados.
     *
     * @exception CustomException se ocorrer erros de acesso ao banco de dados
     *
     * @author João
     * @author Gustavo
     * @author Thiago
     */
    public void createDatabase() throws CustomException{
        PreparedStatement pstmt = null;
        try{
            String sql = "CREATE DATABASE IF NOT EXISTS event " +
                    "DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci";
            pstmt = ConnectionFactory.preConnect().prepareStatement(sql);
            pstmt.execute();

            sql = "CREATE TABLE IF NOT EXISTS rooms (" +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(50) NOT NULL, " +
                    "capacity INT NOT NULL" +
                    ")";
            pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.execute();

            sql = "CREATE TABLE IF NOT EXISTS coffees (" +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(50) NOT NULL" +
                    ")";
            pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.execute();

            sql = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(50) NOT NULL, " +
                    "id_room1 INT NOT NULL, " +
                    "id_room2 INT NOT NULL, " +
                    "id_coffee1 INT NOT NULL, " +
                    "id_coffee2 INT NOT NULL, " +
                    "CONSTRAINT fk_Room1 FOREIGN KEY (id_room1) REFERENCES rooms (id), " +
                    "CONSTRAINT fk_Room2 FOREIGN KEY (id_room2) REFERENCES rooms (id), " +
                    "CONSTRAINT fk_Coffee1 FOREIGN KEY (id_coffee1) REFERENCES coffees (id), " +
                    "CONSTRAINT fk_Coffee2 FOREIGN KEY (id_coffee2) REFERENCES coffees (id)" +
                    ")";
            pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.execute();

        }catch (Exception error){
            throw new CustomException("Erro ao criar o banco de dados: " + error.getMessage());
        } finally{
            try{
                if (pstmt != null){
                    pstmt.close();
                }
            } catch (Exception error){
                throw new CustomException("Erro ao fechar o PrepareStatement: " + error.getMessage());
            }
            ConnectionFactory.closeConnectionMySQL();
            ConnectionFactory.closeConnectionDatabase();
        }
    }
}