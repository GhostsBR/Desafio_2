package Controller;

import CustomExceptions.CustomException;
import Model.*;

import java.util.ArrayList;
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
     * @param coffees Lista de objetos de espaços
     */
    public static void insertCoffees(List<Coffee> coffees){
        try{
            for (Coffee c : coffees) {
                if(c.getIdCoffee() == null){
                    new CoffeeDAO().createCoffee(c);
                }
            }
        } catch(Exception error){
            System.out.println("Não foi possível cadastrar os espaços!");
            System.out.println(error.getMessage());
        }
    }

    /**
     * Método responsável por retornar uma lista de espaços.
     *
     * Retorna uma lista de espaços com uma lista de usuários presentes em cada etapa.
     *
     * @author Gustavo Lemos
     * @return List<Coffee> Lista de Espaços
     */
    public static List<Coffee> findCoffees(){
        List<Coffee> coffees;
        try {
            CoffeeDAO cd = new CoffeeDAO();
            UserDAO ud = new UserDAO();
            coffees = cd.getCoffees();
            for (int i=0; i < coffees.size(); i++) {
                coffees.get(i).setUsersStage1(ud.getUsersRoom("id_coffee1", coffees.get(i).getIdCoffee()));
                coffees.get(i).setUsersStage2(ud.getUsersRoom("id_coffee2", coffees.get(i).getIdCoffee()));
            }
        } catch (CustomException error) {
            coffees = new ArrayList<Coffee>();
        }
        return coffees;
    }

    /**
     * Método responsável por retornar um espaço de café.
     *
     * Retorna um espaço com uma lista de usuários presentes em cada etapa.
     *
     * @author Gustavo Lemos
     * @author Thiago Alexandre
     * @param id Integer
     * @return List<Coffee> Lista de Espaços
     */
    public static Coffee findCoffee(Integer id){
        Coffee coffee;
        try {
            CoffeeDAO cd = new CoffeeDAO();
            UserDAO ud = new UserDAO();
            coffee = cd.getCoffee(id);
            coffee.setUsersStage1(ud.getUsersRoom("id_coffee1", coffee.getIdCoffee()));
            coffee.setUsersStage2(ud.getUsersRoom("id_coffee2", coffee.getIdCoffee()));
        } catch (CustomException error) {
            coffee = new Coffee();
        }
        return coffee;
    }

    /**
     * Método para excluir um espaço.
     *
     * @param coffee Coffee
     */
    public static void removeCoffee(Coffee coffee){
        try{
            new CoffeeDAO().deleteCoffee(coffee.getIdCoffee());
        } catch(CustomException error){
            System.out.println(error.getMessage());
        }
    }
}