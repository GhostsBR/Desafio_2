package Test.Model;

import CustomExceptions.CustomException;
import Model.Coffee;
import Test.Test;

/**
 * Classe para testes de objetos Coffee.
 *
 * Realiza os testes unitários da classe Coffee.
 *
 * @author Thiago
 */
public class TestCoffee extends Test{

    /**
     * Objeto Coffee utilizado para os testes.
     */
    private final Coffee coffee;

    /**
     * Construtor da Classe TestCoffe, definindo o objeto Coffee como vazio.
     */
    public TestCoffee(){
        super();
        this.coffee = new Coffee();
    }

    /**
     * Método para testar a classe Coffee.
     *
     * Realiza testes na validação dos valores de ID e de nome da classe Coffee.
     * Caso não seja possível definir valores válidos para o ID e nome da classe Coffee,
     * ela não passa nos testes. Caso seja possível definir um valor negativo, 0 ou nulo
     * para o ID, a classe não passa nos testes. Caso seja possível definir um valor vazio,
     * só com espaços, com mais de 50 caracteres ou nulo para o nome, a classe não passa
     * nos testes. Ao final, verifica-se a lista de erros e define se a classe passou nos testes.
     *
     * @author Thiago
     * @throws CustomException se ocorrer erros no teste
     */
    @Override
    public void test() throws CustomException{

        try{
            coffee.setIdCoffee(1);
            if (coffee.getIdCoffee() != 1){
                erros.add("Erro: não foi possível adicionar um valor válido para o atributo idCoffee!");
            }
        } catch(Exception error){
            erros.add("Erro: não foi possível adicionar um valor válido para o atributo idCoffee!");
        }
        try{
            coffee.setNameCoffee("Espaço1");
            if (!coffee.getNameCoffee().equals("Espaço1")){
                erros.add("Erro: não foi possível adicionar um valor válido para o atributo nameCoffee!");
            }
        } catch(Exception error){
            erros.add("Erro: não foi possível adicionar um valor válido para o atributo nameCoffee!");
        }

        try{
            coffee.setIdCoffee(-10);
            if (coffee.getIdCoffee() < 0){
                erros.add("Erro: foi possível adicionar um valor negativo para o atributo idCoffee!");
            }
        } catch(Exception error){}

        try{
            coffee.setIdCoffee(0);
            if (coffee.getIdCoffee() == 0){
                erros.add("Erro: foi possível adicionar um valor 0 para o atributo idCoffee!");
            }
        } catch(Exception error){}

        try{
            coffee.setIdCoffee(null);
            if (coffee.getIdCoffee() == null){
                erros.add("Erro: foi possível adicionar um valor nulo para o atributo idCoffee!");
            }
        } catch(Exception error){}

        try{
            coffee.setNameCoffee("");
            if (coffee.getNameCoffee().equals("")){
                erros.add("Erro: foi possível adicionar um valor vazio para o atributo nameCoffee!");
            }
        } catch(Exception error){}

        try{
            coffee.setNameCoffee("     ");
            if (coffee.getNameCoffee().equals("     ")){
                erros.add("Erro: foi possível adicionar um valor com só espaços para o atributo nameCoffee!");
            }
        } catch(Exception error){}

        try{
            coffee.setNameCoffee("123456789012345678901234567890123456789012345678952");
            if (coffee.getNameCoffee().equals("123456789012345678901234567890123456789012345678952")){
                erros.add("Erro: foi possível adicionar um valor com mais de 50 caracteres para o atributo nameCoffee!");
            }
        } catch(Exception error){}

        try{
            coffee.setNameCoffee(null);
            if (coffee.getNameCoffee() == null){
                erros.add("Erro: foi possível adicionar um valor nulo para o atributo nameCoffee!");
            }
        } catch(Exception error){}

        super.verficarErros("Classe Coffee passou nos testes!",
                "Classe Coffee não passou nos testes!");
    }
}