package Model;

import Database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *Classe responsável pela persistência de dados da Classe User
 */
public class UserDAO {

    /**
     * Método para registrar no banco um novo Usuário,
     * utilizando um objeto User, que será recebido somente com
     * os valores de "name"
     * @param user User
     */
    public void createUser(User user){
        try{
            String sql = "INSERT INTO users VALUES (?)";
            PreparedStatement pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setString(1,user.getNameUser());
            pstmt.execute();
        }catch (Exception error){
            System.out.println("Falha ao cadastrar o Usuário. Erro: "+error.getMessage());
        }
    }

    /**
     * Método para deletar um Usuário do banco de dados
     * Neste caso, somente é requerido um ID para o comando
     * do SQL, portanto não é necessário passar um objeto.
     * @param id Integer
     */
    public void deleteUser(int id){
        try{
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.execute();
        }catch (Exception error){
            System.out.println("Falha ao deleter o usuário. Erro: "+error.getMessage());
        }
    }

    /**
     * Método para atualizar o nome de um Usuário
     * utilizando um objeto User, onde o idUser será
     * o ID da entrada da Tabela a ser atualizado, e nameUser será
     * o novo nome desta entrada da tabela.
     * @param user User
     */
    public void updateUser(User user){
        try {
            String sql = "UPDATE users SET name=? WHERE id = ?";
            PreparedStatement pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setString(1,user.getNameUser());
            pstmt.setInt(2,user.getIdUser());
            pstmt.execute();
        }catch (Exception error){
            System.out.println("Falha ao atualizar o nome do Usuário. Erro: "+error.getMessage());
        }
    }

    /**
     * Método para atualizar as Salas e Espaços de um Usuário
     * utilizando um objeto User, onde o idUser será utilizado para
     * controlar qual Usuário será modificado
     * @param user User
     */
    public void updateRoomCoffeeUser(User user){
        try {
            String sql = "UPDATE users SET room1 = ?, room2 = ?, coffee1 = ?, coffee2 = ? WHERE id = ?";
            PreparedStatement pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setString(1,user.getRoom1User());
            pstmt.setString(2,user.getRoom2User());
            pstmt.setString(3,user.getCoffee1User());
            pstmt.setString(4,user.getCoffee2User());
            pstmt.execute();
        }catch (Exception error){
            System.out.println("Falha ao atualizar as Salas e Espaços de Café do Usuário. Erro: "+error.getMessage());
        }
    }

    /**
     * Método para retornar todos os Usuários cadastrados no
     * banco de dados em uma lista de objetos User
     * Obs: Retorna uma lista vazia caso nenhum Usuário esteja cadastrado.
     * Obs2: Retornará os valores de null para as entradas de Salas e
     * Espaços de Café que não sejam cadastrados
     * @return List<User>
     */
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM users";
            Statement stmt = ConnectionFactory.connect().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                User user = new User(rs.getInt("id"), rs.getString("name"),
                        rs.getString("room1"),rs.getString("room2"),
                        rs.getString("coffee1"), rs.getString("coffee2"));
                users.add(user);
            }
        }catch (Exception error){
            System.out.println("Falha ao selecionar os Usuários. Erro: " + error.getMessage());
        }
        return users;
    }
}