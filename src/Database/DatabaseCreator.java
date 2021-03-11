package Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe responsável por criar o banco de dados caso ele não exista
 * @author João, Gustavo, Thiago
 */
public class DatabaseCreator {

    /**
     * Método para gerar o banco de dados
     *
     * Obs: para criar os relacionamentos, é necessário criar as tabelas em ordem,
     * pois tabelas que estarão sendo relacionandas precisam ser criadas antes.
     *
     * Se a tabela Users for criada antes da tabela Rooms, não será possível
     * fazer o relacionamento entre elas, pois a tabela Users não conhece
     * a tabela Rooms!
     *
     * @author João, Gustavo, Thiago
     */
    public void createDatabase(){
        PreparedStatement pstmt = null;
        try{
            // Define o comando SQL para criar o banco de dados
            String sql = "CREATE DATABASE IF NOT EXISTS event DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci";
            // Pega uma conexão ao MySQL e prepara o comando SQL
            pstmt = ConnectionFactory.preConnect().prepareStatement(sql);
            // Executa o comando SQL
            pstmt.execute();

            // Define o comando SQL para criar a tabela das Salas
            sql = "CREATE TABLE IF NOT EXISTS rooms (" +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(50) NOT NULL, " +
                    "capacity INT NOT NULL" +
                    ")";
            // Pega uma conexão ao banco de dados e prepara o comando SQL
            pstmt = ConnectionFactory.connect().prepareStatement(sql);
            // Executa o comando SQL
            pstmt.execute();

            // Define o comando SQL para criar a tabela dos Espaços de Café
            sql = "CREATE TABLE IF NOT EXISTS coffees (" +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(50) NOT NULL)";
            // Pega uma conexão ao banco de dados e prepara o comando SQL
            pstmt = ConnectionFactory.connect().prepareStatement(sql);
            // Executa o comando SQL
            pstmt.execute();

            // Define o comando SQL para criar a tabela das Pessoas
            sql = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(50) NOT NULL, " +
                    "id_room1 INT NOT NULL, " +
                    "id_room2 INT NOT NULL, " +
                    "id_coffee1 INT NOT NULL, " +
                    "id_coffee2 INT NOT NULL, " +
                    // Define o relacionamento entre Users e Rooms para a etapa 1
                    "CONSTRAINT fk_Room1 FOREIGN KEY (id_room1) REFERENCES rooms (id), " +
                    // Define o relacionamento entre Users e Rooms para a etapa 2
                    "CONSTRAINT fk_Room2 FOREIGN KEY (id_room2) REFERENCES rooms (id), " +
                    // Define o relacionamento entre Users e Coffees para a etapa 1
                    "CONSTRAINT fk_Coffee1 FOREIGN KEY (id_coffee1) REFERENCES coffees (id), " +
                    // Define o relacionamento entre Users e Coffees para a etapa 1
                    "CONSTRAINT fk_Coffee2 FOREIGN KEY (id_coffee2) REFERENCES coffees (id)" +
                    ")";
            // Pega uma conexão ao banco de dados e prepara o comando SQL
            pstmt = ConnectionFactory.connect().prepareStatement(sql);
            // Executa o comando SQL
            pstmt.execute();

        }catch (Exception error){
            System.out.println(error.getMessage());
        } finally{
            try{
                // Finaliza o PrepareStatement
                pstmt.close();
            } catch (Exception error){
                System.out.println(error.getMessage());
            }

            // Fecha a conexão com o MySQL
            ConnectionFactory.closeConnectionMySQL();

            // Fecha a conexão com o banco de dados
            ConnectionFactory.closeConnectionDatabase();
        }
    }
}
