package Model;

import Database.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pela persisntência de dados da Classe Coffee
 *
 * @author João
 * @author Thiago
 */
public class CoffeeDAO {
    //Cria uma nova entrada na tabela de Espaços de Café.
    public void createCoffee(String name){
        try {
            String sql = "INSERT INTO coffees (name) VALUES (?)";
            PreparedStatement pstmt = ConnectionFactory.connect().prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.execute();
        }catch (Exception error){
            System.out.println("Falha ao cadastrar o Espaço de Café. Erro: " + error.getMessage());
        }
    }

    /**
     * Método para registrar no banco um novo Espaço de Café,
     * utilizando um objeto Coffee
     *
     * Obs: Como acabei definindo que o idCoffee não poderá ser definido como nulo,
     * é necessário criar um objeto Coffee utilizando o construtor vazio e definir
     * seus atributos via métodos setters!
     *
     * Coffee novo = new Coffee();
     * novo.setNameCoffee("Espaço 1");
     * createCoffee(novo);
     *
     * Isso ocorre pelo fato do ID ser criado automáticamente no banco,
     * e não ser definido pelo sistema.
     *
     * @author Thiago
     * @param coffee Coffee
     */
    public void createCoffee(Coffee coffee){
        try {
            // Define o comando SQL
            String sql = "INSERT INTO coffees (name) VALUES (?)";
            // Pega uma conexão do banco e gera um PreparedStatement
            PreparedStatement pstmt = ConnectionFactory.connect().prepareStatement(sql);
            // Define os paramêtros do comando SQL
            pstmt.setString(1,coffee.getNameCoffee());
            // Executa o comando SQL para salvar no banco
            pstmt.execute();
        }catch (Exception error){
            System.out.println("Falha ao cadastrar o Espaço de Café. Erro: " + error.getMessage());
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
     * @param id Integer
     */
    //Deleta uma entrada na tabela de Espaços de Café.
    public void deleteCoffee (int id){
        try {
            // Define o comando SQL
            String sql = "DELETE FROM coffees WHERE id = ?";
            // Pega uma conexão do banco e gera um PreparedStatement
            PreparedStatement pstmt = ConnectionFactory.connect().prepareStatement(sql);
            // Define os paramêtros do comando SQL
            pstmt.setInt(1,id);
            // Executa o comando SQL para deletar no banco
            pstmt.execute();
        }catch (Exception error){
            System.out.println("Falha ao deletar o Espaço de Café. Erro: " + error.getMessage());
        }
    }

    //Atualiza uma entrada na tabela de Espaços de Café.
    public void updateCoffee (int id, String name){
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
            System.out.println("Falha ao atualizar o Espaço de Café. Erro: " + error.getMessage());
        }
    }

    /**
     * Método para alterar o Espaço de Café
     * utilizando um objeto Coffee
     * @author Thiago
     * @param coffee Coffee
     */
    public void updateCoffee (Coffee coffee){
        try {
            // Define o comando SQL
            String sql = "UPDATE coffees SET name=? WHERE id = ?";
            // Pega uma conexão do banco e gera um PreparedStatement
            PreparedStatement pstmt = ConnectionFactory.connect().prepareStatement(sql);
            // Define os paramêtros do comando SQL
            pstmt.setString(1,coffee.getNameCoffee());
            // Define os paramêtros do comando SQL
            pstmt.setInt(2,coffee.getIdCoffee());
            // Executa o comando SQL para alterar no banco
            pstmt.execute();
        }catch (Exception error){
            System.out.println("Falha ao atualizar o Espaço de Café. Erro: " + error.getMessage());
        }
    }

    //Retorna todas as entradas da tabela de Espaços de Café.
    public String[] getCoffee() {
        try {
            String sql = "SELECT * FROM coffees";
            Statement stmt = ConnectionFactory.connect().createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                System.out.println("\nID do Espaço de Café:\t" + rs.getString("id"));
                System.out.println("Nome do Espaço de Café:\t" + rs.getString("name"));
            }
            return null;
        } catch (Exception e) {
            System.out.println("Falha ao selecionas os Espaços de Café:" + e.getMessage());
        }
        return null;
    }

    /**
     * Método para retornar todos os Espaços de Café
     * salvas no banco em uma lista de objetos Coffee
     * Obs: retorna uma lista vazia caso nenhum Espaço
     * de Café seja encontrado no banco!
     * @author Thiago
     * @return List<Coffee>
     */
    public List<Coffee> getCoffees() {
        // Cria uma lista de objetos Coffee vazia
        List<Coffee> coffes = new ArrayList<Coffee>();
        try {
            // Define o comando SQL
            String sql = "SELECT * FROM coffees";
            // Pega uma conexão do banco e gera um Statement
            Statement stmt = ConnectionFactory.connect().createStatement();
            // Executa o comando SQL e recebe os dados via ResultSet
            ResultSet rs = stmt.executeQuery(sql);
            // Verifica se há dados
            while(rs.next()){
                // Pega os dados do ResultSet e cria uma objeto Coffee através do construtor com paramêtros
                Coffee coffee = new Coffee(rs.getInt("id"), rs.getString("name"));
                // Adiciona o objeto Coffee na lista
                coffes.add(coffee);
            }
        } catch (Exception e) {
            System.out.println("Falha ao selecionas os Espaços de Café:" + e.getMessage());
        }
        // Retorna a lista, seja ela vazia ou não
        return coffes;
    }

    /**
     * Método para retornar um Espaço de Café salvo no banco em um objeto Coffee através do id
     *
     * Obs: retorna um objeto vazio caso nenhum Espaço
     * de Café seja encontrado no banco!
     * @author Thiago
     * @return Coffee
     */
    public Coffee getCoffee(Integer id) {
        // Cria um objeto Coffee vazio
        Coffee coffee = new Coffee();
        try {
            // Define o comando SQL
            String sql = "SELECT * FROM coffees WHERE id = ?";
            // Pega uma conexão do banco e gera um PreparedStatement
            PreparedStatement pstmt = ConnectionFactory.connect().prepareStatement(sql);
            // Define os paramêtros do comando SQL
            pstmt.setInt(1,id);
            // Executa o comando SQL e recebe os dados via ResultSet
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            // Verifica se há dados
            if(rs.next()){
                // Pega os dados do ResultSet e cria uma objeto Coffee através do construtor com paramêtros
                coffee = new Coffee(rs.getInt("id"), rs.getString("name"));
            }
        } catch (Exception e) {
            System.out.println("Falha ao selecionar os Espaços de Café:" + e.getMessage());
        }
        // Retorna o objeto Coffee, seja ele vazio ou não
        return coffee;
    }
}