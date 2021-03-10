package Test.Model;

import Model.Coffee;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe para testes de objetos Coffee
 * @author Thiago
 */
public class TestCoffe {

    /**
     *  Objeto Coffee utilizado para os testes
     */
    private final Coffee coffee;

    /**
     *  Lista de possíveis erros do teste
     */
    private List<String> erros;

    /**
     * Cosntrutor da Classe TestCoffe, definindo
     * o objeto coffee da classe e uma lista vazia
     * para adicionar os possíveis erros
     */
    public TestCoffe(){
        this.coffee = new Coffee();
        erros = new ArrayList<String>();
    }

    /**
     * Método para testar a classe Coffee
     */
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
        if (erros.size() > 0){
            System.out.println("Classe Coffee não passou nos testes!");
            // Mostra os erros encontrados
            for (String erro: erros) {
                System.out.println(erro);
            }
        } else{
            System.out.println("Classe Coffee passou nos testes!");
        }
    }
}