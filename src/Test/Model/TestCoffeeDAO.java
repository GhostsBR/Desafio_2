package Test.Model;

import Database.DatabaseCreator;
import Model.Coffee;
import Model.CoffeeDAO;
import Test.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe para testes do CoffeeDAO
 * @author Thiago
 */
public class TestCoffeeDAO extends Test {

    /**
     * Objeto CoffeeDAO utilizado para os testes
     */
    private final CoffeeDAO dao;

    /**
     * Construtor da Classe TestCoffeDAO, definindo
     * o objeto CoffeeDAO
     */
    public TestCoffeeDAO() {
        super();
        this.dao = new CoffeeDAO();
    }

    /**
     * Método para testar a classe CoffeeDAO
     */
    @Override
    public void test(){

        //Cria um objeto DatabaseCreator e chama o método para criar o banco de dados
        DatabaseCreator dataBase = new DatabaseCreator();
        dataBase.createDatabase();

        // Cria um novo objeto Coffee e define um valor para nameCoffee
        Coffee coffeeTeste = new Coffee();
        coffeeTeste.setNameCoffee("Espaço de Café Teste");

        // Cadastra o objeto Coffee no banco de dados
        dao.createCoffee(coffeeTeste);

        // Busca todos os espaços de café cadastrado no banco
        List<Coffee> coffees = dao.getCoffees();

        // Verifica se foi cadastrado o novo espaço de café
        if (coffees.size() > 0){

            // Pega o último objeto coffee cadastrado no banco
            Coffee coffeeNovo = coffees.get(coffees.size() - 1);

            // Verifica se é o mesmo objeto que foi enviado para o cadastro
            if (!coffeeNovo.getNameCoffee().equals(coffeeTeste.getNameCoffee())){
                erros.add("Erro: não foi possível cadastrar um novo espaço de café!");
            }

            // Altera o nome do espaço de café e salva no banco de dados
            coffeeTeste.setIdCoffee(coffeeNovo.getIdCoffee());
            coffeeTeste.setNameCoffee("Espaço de Café Teste Editado");
            dao.updateCoffee(coffeeTeste);

            // Busca o objeto Coffee alterado no banco
            coffeeNovo = dao.getCoffee(coffeeTeste.getIdCoffee());

            // Verifica se é o mesmo nome que foi enviado para a alteração
            if (!coffeeNovo.getNameCoffee().equals(coffeeTeste.getNameCoffee())){
                erros.add("Erro: não foi possível alterar o espaço de café!");
            }
            // Deleta o espaço de café do banco
            dao.deleteCoffee(coffeeNovo.getIdCoffee());

            // Busca o objeto pelo id deletado
            coffeeNovo = dao.getCoffee(coffeeNovo.getIdCoffee());

            // Verifica se o objeto foi apagado do banco
            if (coffeeNovo.getIdCoffee() != null){
                erros.add("Erro: não foi possível excluir o espaço de café!");
            }
        } else{
            erros.add("Erro: não foi possível cadastrar um novo espaço de café!");
        }
        super.verficaErros("Classe CoffeeDAO passou nos testes!","Classe CoffeeDAO não passou nos testes!");
    }
}