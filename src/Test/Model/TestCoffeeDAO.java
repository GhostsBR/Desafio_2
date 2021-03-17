package Test.Model;

import CustomExceptions.CustomException;
import Database.DatabaseCreator;
import Model.Coffee;
import Model.CoffeeDAO;
import Test.Test;

import java.util.List;

/**
 * Classe para testes do CoffeeDAO.
 *
 * Realiza testes unitários nos métodos de persistência da classe CoffeeDAO.
 *
 * @author Thiago
 */
public class TestCoffeeDAO extends Test {

    /**
     * Objeto CoffeeDAO utilizado para os testes.
     */
    private final CoffeeDAO dao;

    /**
     * Construtor da Classe TestCoffeDAO, definindo o objeto CoffeeDAO.
     */
    public TestCoffeeDAO() {
        super();
        this.dao = new CoffeeDAO();
    }

    /**
     * Método para testar a classe CoffeeDAO.
     *
     * Utiliza o DatabseCreator para gerar o banco. Depois, cria-se um objeto Coffee
     * e define um nome para realizar o teste de inserção no banco de dados. Com isso,
     * busca-se todos os Espaços de café salvos no banco. Caso nenhum objeto Coffee seja
     * encontrado, ocorreu erro ou no cadastro ou na busca por todos, sendo finalizado o
     * teste. Caso seja encontrado espaços de café salvos no banco, busca-se o último
     * registrado e verifica se o nome salvo é igual ao nome enviado para salvar. Realizado
     * esse teste, atualiza-se os dados de teste e envia as atualizações para o banco. Ao
     * buscar o objeto pelo ID, verifica-se o nome caso seja nulo, o que indica erro no método
     * e finaliza o teste. Se não for nulo, verifica-se se o nome salvo é correspondente a
     * atualização enviada ao banco. Por fim, realiza a exclusão do espaço de café e a busca pelo
     * seu ID. Caso o objeto retornar com um ID diferente de nulo, significa que a exclusão falhou.
     * Ao final, verifica-se a lista de erros e define se a classe passou nos testes.
     *
     * @author Thiago
     * @throws CustomException se ocorrer erros no teste
     */
    @Override
    public void test() throws CustomException{
        try{
            DatabaseCreator dataBase = new DatabaseCreator();
            dataBase.createDatabase();

            Coffee coffeeTeste = new Coffee();
            coffeeTeste.setNameCoffee("Espaço de Café Teste");
            dao.createCoffee(coffeeTeste);

            List<Coffee> coffees = dao.getCoffees();
            if (coffees.size() > 0){
                Coffee coffeeNovo = coffees.get(coffees.size() - 1);
                if (!coffeeNovo.getNameCoffee().equals(coffeeTeste.getNameCoffee())){
                    erros.add("Erro: não foi possível cadastrar um novo espaço de café!");
                }

                coffeeTeste.setIdCoffee(coffeeNovo.getIdCoffee());
                coffeeTeste.setNameCoffee("Espaço de Café Teste Editado");
                dao.updateCoffee(coffeeTeste);

                coffeeNovo = dao.getCoffee(coffeeTeste.getIdCoffee());
                if (coffeeNovo.getNameCoffee() != null){

                    if (!coffeeNovo.getNameCoffee().equals(coffeeTeste.getNameCoffee())){
                        erros.add("Erro: não foi possível alterar o espaço de café!");
                    }

                    dao.deleteCoffee(coffeeNovo.getIdCoffee());
                    coffeeNovo = dao.getCoffee(coffeeNovo.getIdCoffee());
                    if (coffeeNovo.getIdCoffee() != null){
                        erros.add("Erro: não foi possível excluir o espaço de café!");
                    }
                } else{
                    erros.add("Erro: não foi possível buscar o espaço de café pelo ID!");
                }
            } else{
                erros.add("Erro: não foi possível cadastrar um novo espaço de café" +
                        " ou não foi possível realizar a busca dos espaços de café!");
            }
            super.verficarErros("Classe CoffeeDAO passou nos testes!","Classe CoffeeDAO não passou nos testes!");
        } catch(Exception error){
            throw new CustomException("Erro ao realizar o teste da classe CoffeeDAO: " + error.getMessage());
        }
    }
}