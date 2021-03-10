package Main;

import Database.DatabaseCreator;
import Test.Model.TestCoffe;

public class Main {
    public static void main(String[] args) {

        /**
         * Cria um novo teste da classe Coffee e chama o método de testes

        TestCoffe testCoffe = new TestCoffe();
        testCoffe.test();
        */

        /**
         * Cria um objeto DatabaseCreator e chama o método para criar o banco de dados
         */
        DatabaseCreator dataBase = new DatabaseCreator();
        dataBase.createDatabase();
    }
}
