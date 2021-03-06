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

    /**
     * Objeto PreparedStatement usado no DAO.
     *
     * Definido objeto PreparedStatement utilizado pelo DAO,
     * facilitando seu uso e fechamento.
     */
    private PreparedStatement pstmt = null;

    /**
     * Método para registrar no banco um novo Espaço de Café.
     *
     * Cadastra um novo espaço de café no banco utilizando um objeto Coffee.
     *
     * @author João
     * @author Thiago
     *
     * @param coffee Coffee
     * @throws CustomException se ocorrer erro de SQL ou no PreparedStatement
     */
    public void createCoffee(Coffee coffee) throws CustomException{
        try {
            int quantidadeEspacosSalvos = getCoffees().size();
            if (quantidadeEspacosSalvos < 2){
                String sql = "INSERT INTO coffees (name) VALUES (?)";
                pstmt = ConnectionFactory.connect().prepareStatement(sql);
                pstmt.setString(1,coffee.getNameCoffee());
                pstmt.execute();
            } else{
                throw new CustomException("Erro: Limite de espaços de café cadastrados atingido!");
            }
        }catch (Exception error){
            throw new CustomException("Erro ao inserir um novo Espaço de Café: " + error.getMessage());
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
     * Método para excluir um Espaço de café
     *
     * Exclui um Espaço de café do banco de dados usando o ID.
     *
     * @author João
     * @author Thiago
     *
     * @param id Integer
     * @throws CustomException se ocorrer erro de SQL ou no PreparedStatement
     */
    public void deleteCoffee (int id) throws CustomException{
        try {
            String sql = "DELETE FROM coffees WHERE id = ?";
            pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.execute();
        }catch (Exception error){
            throw new CustomException("Erro ao excluir um Espaço de Café: " + error.getMessage());
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
     * Método para alterar o Espaço de Café.
     *
     * Realiza alterações dos dados de Espaço de café no banco,
     * utilizando um objeto Coffee.
     *
     * @author João
     * @author Thiago
     *
     * @param coffee Coffee
     * @throws CustomException se ocorrer erro de SQL ou no PreparedStatement
     */
    public void updateCoffee (Coffee coffee) throws CustomException{
        try {
            String sql = "UPDATE coffees SET name=? WHERE id = ?";
            pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setString(1,coffee.getNameCoffee());
            pstmt.setInt(2,coffee.getIdCoffee());
            pstmt.execute();
        }catch (Exception error){
            throw new CustomException("Erro ao atualizar o Espaço de Café: " + error.getMessage());
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
     * Método para retornar todos os Espaços de Café.
     *
     * Realiza a busca e retorno de todos os Espaços de café salvos no banco.
     *
     * Obs: retorna uma lista vazia caso nenhum Espaço
     * de Café seja encontrado no banco!
     *
     * @author João
     * @author Thiago
     *
     * @return List<Coffee> Lista de Espaços de café
     * @throws CustomException se ocorrer erro de SQL ou no Statement
     */
    public List<Coffee> getCoffees() throws CustomException{
        List<Coffee> coffes = new ArrayList<Coffee>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM coffees";
            stmt = ConnectionFactory.connect().createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Coffee coffee = new Coffee(rs.getInt("id"), rs.getString("name"));
                coffes.add(coffee);
            }
        } catch (Exception error) {
            throw new CustomException("Erro ao selecionar o Espaço de Café: " + error.getMessage());
        } finally{
            try{
                if (stmt != null){
                    stmt.close();
                }
                if (rs != null){
                    rs.close();
                }
            } catch (Exception error){}
            ConnectionFactory.closeConnectionDatabase();
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
     * @author João
     * @author Thiago
     *
     * @param id Integer
     * @return Coffee
     * @throws CustomException se ocorrer erro de SQL ou no PreparedStatement
     */
    public Coffee getCoffee(Integer id) throws CustomException{
        Coffee coffee = new Coffee();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM coffees WHERE id = ?";
            pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.execute();
            rs = pstmt.getResultSet();
            if(rs.next()){
                coffee = new Coffee(rs.getInt("id"), rs.getString("name"));
            }
        } catch (Exception error) {
            throw new CustomException("Erro ao buscar o Espaço de Café: " + error.getMessage());
        } finally{
            try{
                if (pstmt != null){
                    pstmt.close();
                }
                if (rs != null){
                    rs.close();
                }
            } catch (Exception error){}
            ConnectionFactory.closeConnectionDatabase();
        }
        return coffee;
    }
}