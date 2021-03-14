package Controller;

import CustomExceptions.CustomException;
import Model.*;

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
     * @exception CustomException se ocorrer erro ao salvar no banco
     *
     * @param coffees List<Coffee> Lista de objetos de espaços
     */
    public static void insertCoffee(List<Coffee> coffees) throws CustomException{
        try{
            for (Coffee c : coffees) {
                if(c.getIdCoffee() == null){
                    new CoffeeDAO().createCoffee(c);
                } else{
                    new CoffeeDAO().updateCoffee(c);
                }
            }
        } catch(Exception error){
            throw new CustomException("Erro ao enviar os espaços para salvar no banco: " + error.getMessage());
        }
    }

    public static List<Coffee> findCoffees() throws CustomException{
        try {
            CoffeeDAO cd = new CoffeeDAO();
            UserDAO ud = new UserDAO();

            List<Coffee> coffees = cd.getCoffees();
            for (int i=0; i < coffees.size(); i++) {
                coffees.get(i).setUsersStage1(ud.getUsersRoom("id_coffee1", coffees.get(i).getIdCoffee()));
                coffees.get(i).setUsersStage2(ud.getUsersRoom("id_coffee2", coffees.get(i).getIdCoffee()));
            }

            return coffees;
        } catch (CustomException error) {
            throw new CustomException("ERRO: " + error.getMessage());
        }
    }
}