package Model;

import CustomExceptions.CustomException;
import Database.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pela persisntência de dados da Classe Coffee.
 *
 * @author João
 * @author Thiago
 */
public class CoffeeDAO {

    //Cria uma nova entrada na tabela de Espaços de Café.
    public void createCoffee(String name) throws CustomException{
        try {
            String sql = "INSERT INTO coffees (name) VALUES (?)";
            PreparedStatement pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.execute();
        }catch (Exception error){
            throw new CustomException("Erro ao inserir um novo Espaço de Café: " + error.getMessage());
        }
    }

    /**
     * Método para registrar no banco um novo Espaço de Café.
     *
     * Cadastra um novo espaço de café no banco utilizando um objeto Coffee.
     *
     * @exception CustomException se ocorrer erro de SQL ou no PreparedStatement
     *
     * @author João
     * @author Thiago
     *
     * @param coffee Coffee
     */
    public void createCoffee(Coffee coffee) throws CustomException{
        try {
            String sql = "INSERT INTO coffees (name) VALUES (?)";
            PreparedStatement pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setString(1,coffee.getNameCoffee());
            pstmt.execute();
        }catch (Exception error){
            throw new CustomException("Erro ao inserir um novo Espaço de Café: " + error.getMessage());
        }
    }

    /**
     * Obs: no caso do DELETE, não será preciso
     * enviar um objeto Coffee como parâmetro, pois
     * somente o ID é necessário para o comando SQL.
     * Já nos métodos CREATE e UPDATE, enviar um objeto Coffe
     * facilita pois você terá certeza que todos os atributos
     * serão enviados, não precisando adicionar novos parâmetros
     * no método caso a tabela venha a ser alterada, contendo mais colunas.
     * Somente a classe Coffee precisará ser atualizada!
     *
     * @exception CustomException se ocorrer erro de SQL ou no PreparedStatement
     *
     * @author João
     * @author Thiago
     *
     * @param id Integer
     */
    public void deleteCoffee (int id) throws CustomException{
        try {
            String sql = "DELETE FROM coffees WHERE id = ?";
            PreparedStatement pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.execute();
        }catch (Exception error){
            throw new CustomException("Erro ao inserir um novo Espaço de Café: " + error.getMessage());
        }
    }

    //Atualiza uma entrada na tabela de Espaços de Café.
    public void updateCoffee (int id, String name) throws CustomException{
        try {
            // Define o comando SQL
            String sql = "UPDATE coffees SET name=? WHERE id = ?";
            // Pega uma conexão do banco e gera um PreparedStatement
            PreparedStatement pstmt = ConnectionFactory.connect().prepareStatement(sql);
            // Define os paramêtros do comando SQL
            pstmt.setString(1,name);
            // Define os paramêtros do comando SQL
            pstmt.setInt(2,id);
            // Executa o comando SQL para alterar no banco
            pstmt.execute();
        }catch (Exception error){
            throw new CustomException("Erro ao atualizar o Espaço de Café. Erro: " + error.getMessage());
        }
    }

    /**
     * Método para alterar o Espaço de Café.
     *
     * Realiza alterações dos dados de Espaço de café no banco,
     * utilizando um objeto Coffee.
     *
     * @exception CustomException se ocorrer erro de SQL ou no PreparedStatement
     *
     * @author João
     * @author Thiago
     *
     * @param coffee Coffee
     */
    public void updateCoffee (Coffee coffee) throws CustomException{
        try {
            String sql = "UPDATE coffees SET name=? WHERE id = ?";
            PreparedStatement pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setString(1,coffee.getNameCoffee());
            pstmt.setInt(2,coffee.getIdCoffee());
            pstmt.execute();
        }catch (Exception error){
            throw new CustomException("Erro ao atualizar o Espaço de Café. Erro: " + error.getMessage());
        }
    }

    /**
     * Método para retornar todos os Espaços de Café.
     *
     * Realiza a busca e retorno de todos os Espaços de café salvos no banco.
     *
     * Obs: retorna uma lista vazia caso nenhum Espaço
     * de Café seja encontrado no banco!
     *
     * @exception CustomException se ocorrer erro de SQL ou no PreparedStatement
     *
     * @author João
     * @author Thiago
     *
     * @return List<Coffee> Lista de Espaços de café
     */
    public List<Coffee> getCoffees() throws CustomException{
        List<Coffee> coffes = new ArrayList<Coffee>();
        try {
            String sql = "SELECT * FROM coffees";
            Statement stmt = ConnectionFactory.connect().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Coffee coffee = new Coffee(rs.getInt("id"), rs.getString("name"));
                coffes.add(coffee);
            }
        } catch (Exception error) {
            throw new CustomException("Erro ao selecionar o Espaço de Café: " + error.getMessage());
        }
        return coffes;
    }

    /**
     * Método para retornar um Espaço de Café.
     *
     * Realiza a busca e retorno de um Espaço de café salvo no banco através do id.
     *
     * Obs: retorna um objeto vazio caso nenhum Espaço
     * de Café seja encontrado no banco!
     *
     * @exception CustomException se ocorrer erro de SQL ou no PreparedStatement
     *
     * @author João
     * @author Thiago
     *
     * @return Coffee
     */
    public Coffee getCoffee(Integer id) throws CustomException{
        Coffee coffee = new Coffee();
        try {
            String sql = "SELECT * FROM coffees WHERE id = ?";
            PreparedStatement pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            if(rs.next()){
                coffee = new Coffee(rs.getInt("id"), rs.getString("name"));
            }
        } catch (Exception error) {
            throw new CustomException("Erro ao buscar o Espaço de Café: " + error.getMessage());
        }
        return coffee;
    }
}