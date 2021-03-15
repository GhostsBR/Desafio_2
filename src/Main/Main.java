package Main;

import View.ViewCMD;

public class Main {
    public static void main(String[] args) {

        /**
         * Cria um novo teste da classe Coffee e chama o método de testes
         *
         TestCoffee testCoffe = new TestCoffee();
         try{
         testCoffe.test();
         } catch(CustomException error){
         System.out.println(error.getMessage());
         }
         //*/

        /**
         * Cria um novo teste da classe CoffeeDAO e chama o método de teste
         *
         TestCoffeeDAO testCoffeeDAO = new TestCoffeeDAO();
         try{
         testCoffeeDAO.test();
         } catch(CustomException error){
         System.out.println(error.getMessage());
         }
         //*/

        /**
         * Cria um objeto DatabaseCreator e chama o método para criar o banco de dados
         *
         DatabaseCreator dataBase = new DatabaseCreator();
         try{
            dataBase.createDatabase();
         } catch(CustomException error){
            System.out.println(error.getMessage());
         }
         //*/

        /**
         */
         ViewCMD test = new ViewCMD();
         test.run();
         //*/
        
        //UserView view = new UserView();
    }
}