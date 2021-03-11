package Controller;

import Model.Coffee;
import Model.CoffeeDAO;

import java.util.List;

/**
 * Classe responsável pelo controle dos espaços.
 *
 * @author Gustavo Lemos
 */
public class CoffeeController {
    /**
     * Método responsável por separar e enviar os espaços para serem inseridos no banco de dados.
     *
     * Apôs o recebimento de uma lista de objetos, o método separa as salas
     * e realiza o envio ao método responsável por inserir no banco de dados.
     *
     * @param coffees List<Coffee> Lista de objetos de espaços.
     */
    public static void insertCoffee(List<Coffee> coffees) {
        for (int i=0; i < coffees.size(); i++) {
            new CoffeeDAO().createCoffee(coffees.get(i));
        }
    }
}
