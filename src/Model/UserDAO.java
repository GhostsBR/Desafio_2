package Model;

import CustomExceptions.CustomException;
import Database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe responsável pela persistência de dados da Classe User.
 *
 * @author João
 */
public class UserDAO {

    /**
     * Objeto PreparedStatement usado no DAO.
     *
     * Definido objeto PreparedStatement utilizado pelo DAO,
     * facilitando seu uso e fechamento.
     */
    private PreparedStatement pstmt = null;

    /**
     * Método para registrar um novo Usuário.
     *
     * Cadastra um novo usuário no banco utilizando um objeto User.
     *
     * @exception CustomException se ocorrer erro de SQL ou no PreparedStatement
     *
     * @author João
     *
     * @param user User
     */
    public void createUser(User user) throws CustomException{
        try{
            System.out.println(user.getRoom1User().getNameRoom());
            System.out.println(user.getRoom2User().getNameRoom());
            String sql = "INSERT INTO users VALUES (?,?,?,?,?)";
            pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setString(1,user.getNameUser());
            pstmt.setInt(2,user.getRoom1User().getIdRoom());
            pstmt.setInt(3,user.getRoom2User().getIdRoom());
            pstmt.setInt(4,user.getCoffee1User().getIdCoffee());
            pstmt.setInt(5,user.getCoffee2User().getIdCoffee());
            pstmt.execute();
        }catch (Exception error){
            throw new CustomException("Erro ao inserir novo usuário: " + error.getMessage());
        } finally{
            try{
                if (pstmt != null){
                    pstmt.close();
                }
            } catch (Exception error){}
            ConnectionFactory.closeConnectionDatabase();
        }
    }

    /**
     * Método para deletar um Usuário do banco de dados
     * Neste caso, somente é requerido um ID para o comando
     * do SQL, portanto não é necessário passar um objeto.
     *
     * @exception CustomException se ocorrer erro de SQL ou no PreparedStatement
     *
     * @param id Integer
     */
    public void deleteUser(int id) throws CustomException{
        try{
            String sql = "DELETE FROM users WHERE id = ?";
            pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.execute();
        }catch (Exception error){
            throw new CustomException("Erro ao excluir o usuário: " + error.getMessage());
        } finally{
            try{
                if (pstmt != null){
                    pstmt.close();
                }
            } catch (Exception error){}
            ConnectionFactory.closeConnectionDatabase();
        }
    }

    /**
     * Método para atualizar o nome de um Usuário
     * utilizando um objeto User, onde o idUser será
     * o ID da entrada da Tabela a ser atualizado, e nameUser será
     * o novo nome desta entrada da tabela.
     *
     * @exception CustomException se ocorrer erro de SQL ou no PreparedStatement
     *
     * @param user User
     */
    public void updateUser(User user) throws CustomException{
        try {
            String sql = "UPDATE users SET name=? WHERE id = ?";
            pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setString(1,user.getNameUser());
            pstmt.setInt(2,user.getIdUser());
            pstmt.execute();
        }catch (Exception error){
            throw new CustomException("Erro ao alterar o usuário: " + error.getMessage());
        } finally{
            try{
                if (pstmt != null){
                    pstmt.close();
                }
            } catch (Exception error){}
            ConnectionFactory.closeConnectionDatabase();
        }
    }

    /**
     * Método para atualizar as Salas e Espaços de um Usuário
     * utilizando um objeto User, onde o idUser será utilizado para
     * controlar qual Usuário será modificado
     *
     * @exception CustomException se ocorrer erro de SQL ou no PreparedStatement
     *
     * @param user User
     */
    public void updateRoomCoffeeUser(User user) throws CustomException{
        try {
            String sql = "UPDATE users SET name=?, id_room1=?, id_room2=?, id_coffee1=?, id_coffee1=? WHERE id = ?";
            pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setString(1,user.getNameUser());
            pstmt.setInt(2,user.getRoom1User().getIdRoom());
            pstmt.setInt(3,user.getRoom2User().getIdRoom());
            pstmt.setInt(4,user.getCoffee1User().getIdCoffee());
            pstmt.setInt(5,user.getCoffee2User().getIdCoffee());
            pstmt.setInt(6,user.getIdUser());

            pstmt.execute();
        }catch (Exception error){
            throw new CustomException("Erro ao alterar o usuário: " + error.getMessage());
        } finally{
            try{
                if (pstmt != null){
                    pstmt.close();
                }
            } catch (Exception error){}
            ConnectionFactory.closeConnectionDatabase();
        }
    }

    /**
     * Método para retornar todos os Usuários.
     *
     * Realiza a busca e retorno de todos os Espaços de café salvos no banco.
     * Já realiza a busca das salas e espaços da cada usuário em cada etapa.
     *
     * Obs: Retorna uma lista vazia caso nenhum Usuário esteja cadastrado.
     *
     * @exception CustomException se ocorrer erro de SQL ou no PreparedStatement
     *
     * @author João
     * @author Thiago
     *
     * @return List<User> Lista de usuários
     */
    public List<User> getUsers() throws CustomException{
        List<User> users = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        Integer id;
        String nome;
        Integer room1;
        Integer room2;
        Integer coffee1;
        Integer coffee2;
        try {
            String sql = "SELECT * FROM users";
            stmt = ConnectionFactory.connectExtra().createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                id = rs.getInt("id");
                nome = rs.getString("name");
                room1 = rs.getInt("id_room1");
                room2 = rs.getInt("id_room2");
                coffee1 = rs.getInt("id_coffee1");
                coffee2 = rs.getInt("id_coffee2");
                User user = new User( id, nome,
                        new RoomDAO().getRoom(room1),
                        new RoomDAO().getRoom(room2),
                        new CoffeeDAO().getCoffee(coffee1),
                        new CoffeeDAO().getCoffee(coffee2));
                users.add(user);
            }
        }catch (Exception error){
            throw new CustomException("Erro ao selecionar os Usuários: " + error.getMessage());
        } finally{
            try{
                if (stmt != null && !stmt.isClosed()){
                    stmt.close();
                }
                if (rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (Exception error){}
            ConnectionFactory.closeConnectionDatabase();
        }
        return users;
    }
}