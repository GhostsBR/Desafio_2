package Test.Model;

import Model.Coffee;
import Test.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe para testes de objetos Coffee
 * @author Thiago
 */
public class TestCoffe extends Test{

    /**
     * Objeto Coffee utilizado para os testes
     */
    private final Coffee coffee;

    /**
     * Construtor da Classe TestCoffe, definindo
     * o objeto Coffee
     */
    public TestCoffe(){
        super();
        this.coffee = new Coffee();
    }

    /**
     * Método para testar a classe Coffee
     */
    @Override
    public void test(){
        // Definindo um valor válido para o atributo idCoffee
        coffee.setIdCoffee(1);
        if (coffee.getIdCoffee() != 1){
            erros.add("Erro: não foi possível adicionar um valor válido para o atributo idCoffee!");
        }
        // Definindo um valor válido para o atributo idCoffee
        coffee.setNameCoffee("Espaço1");
        if (!coffee.getNameCoffee().equals("Espaço1")){
            erros.add("Erro: não foi possível adicionar um valor válido para o atributo nameCoffee!");
        }
        // Definindo valor negativo para o atributo idCoffee
        coffee.setIdCoffee(-10);
        if (coffee.getIdCoffee() < 0){
            erros.add("Erro: foi possível adicionar um valor negativo para o atributo idCoffee!");
        }
        // Definindo valor 0 para o atributo idCoffee
        coffee.setIdCoffee(0);
        if (coffee.getIdCoffee() == 0){
            erros.add("Erro: foi possível adicionar um valor 0 para o atributo idCoffee!");
        }
        // Definindo valor nulo para o atributo idCoffee
        coffee.setIdCoffee(null);
        if (coffee.getIdCoffee() == null){
            erros.add("Erro: foi possível adicionar um valor nulo para o atributo idCoffee!");
        }
        // Definindo valor vazio para o atributo nameCoffee
        coffee.setNameCoffee("");
        if (coffee.getNameCoffee().equals("")){
            erros.add("Erro: foi possível adicionar um valor vazio para o atributo nameCoffee!");
        }
        // Definindo valor com só espaços para o atributo nameCoffee
        coffee.setNameCoffee("     ");
        if (coffee.getNameCoffee().equals("     ")){
            erros.add("Erro: foi possível adicionar um valor com só espaços para o atributo nameCoffee!");
        }
        // Definindo valor com mais de 50 caracteres para o atributo nameCoffee
        coffee.setNameCoffee("123456789012345678901234567890123456789012345678952");
        if (coffee.getNameCoffee().equals("123456789012345678901234567890123456789012345678952")){
            erros.add("Erro: foi possível adicionar um valor com mais de 50 caracteres para o atributo nameCoffee!");
        }
        // Verifica se ocorreu erros
        super.verficaErros("Classe Coffee passou nos testes!", "Classe Coffee não passou nos testes!");
    }
}