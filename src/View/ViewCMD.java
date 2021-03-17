package View;

import Controller.CoffeeController;
import Controller.RoomController;
import Controller.UserController;
import CustomExceptions.CustomException;
import Database.DatabaseCreator;
import Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável pela interação com o usuário através do CMD.
 */
public class ViewCMD {

    private final Scanner scanner = new Scanner(System.in);
    private int optionMenu = 0;
    private int optionSubMenu = 0;
    private List<User> users;
    private List<Room> rooms;
    private List<Coffee> coffees;

    /**
     * Método para executar a aplicação via CMD.
     */
    public void run(){
        do {
            updateUsers();
            updateRooms();
            updateCoffees();
            showMenu();
            requestOptionMenu();
            checkOptions();
        } while (optionMenu != 0);
    }

    /**
     * Método para carregar os espaços.
     */
    private void updateCoffees(){
        coffees = CoffeeController.findCoffees();
    }

    /**
     * Método para carregar as pessoas.
     */
    private void updateUsers(){
        users = UserController.findUsers();
    }

    /**
     * Método para carregar as salas.
     */
    private void updateRooms(){
        rooms = RoomController.findRooms();
    }

    /**
     * Método para mostrar o Menu Principal.
     */
    private void showMenu(){
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Menu Principal:");
        System.out.println("\t 1 - Pessoa");
        System.out.println("\t 2 - Sala");
        System.out.println("\t 3 - Espaço de Café");
        System.out.println("\t 4 - Excluir Dados");
        System.out.println("\t 0 - Sair");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * Método para mostrar o submenu.
     */
    private void showSubMenu(){
        System.out.println("\t 1 - Cadastrar");
        System.out.println("\t 2 - Mostrar Todos");
        System.out.println("\t 3 - Pesquisar");
        System.out.println("\t 4 - Excluir");
        System.out.println("\t 0 - Voltar");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * Método para solicitar qual opção do Menu Principal desejada pelo usuário.
     */
    private void requestOptionMenu(){
        boolean remake = true;
        do {
            try{
                System.out.println("Informe a opção desejada:");
                optionMenu = Integer.parseInt(scanner.nextLine());
                remake = false;
            } catch(Exception error){
                System.out.println("Informe uma opção válida!");
            }
        } while(remake);
    }

    /**
     * Método para solicitar qual opção do Sub Menu desejada pelo usuário.
     */
    private void requestOptionSubMenu(){
        boolean remake = true;
        do {
            try{
                System.out.println("Informe a opção desejada:");
                optionSubMenu = Integer.parseInt(scanner.nextLine());
                remake = false;
            } catch(Exception error){
                System.out.println("Informe uma opção válida!");
            }
        } while(remake);
    }

    /**
     * Método para verificar as opções selecionadas pelo usuário no Menu Principal e SubMenu.
     */
    private void checkOptions(){
        switch (optionMenu){
            case 1:
                System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Opções para Pessoas:");
                showSubMenu();
                requestOptionSubMenu();
                switch (optionSubMenu){
                    case 1:
                        if (rooms.size() == 0 || coffees.size() == 0){
                            System.out.println("Não há capacidade suficiente!");
                        } else{
                            int usersNow = users.size();
                            addUser();
                            if(usersNow < users.size()){
                                updateUsersPositions();
                            }
                        }
                        break;
                    case 2:
                        showUsers();
                        break;
                    case 3:
                        findUsers();
                        break;
                    case 4:
                        deleteUser();
                        break;
                    default:
                        optionSubMenu = 0;
                }
                //waitForContinue();
                break;
            case 2:
                System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Opções para Salas:");
                showSubMenu();
                requestOptionSubMenu();
                switch (optionSubMenu){
                    case 1:
                        addRoom();
                        RoomController.insertRooms(rooms);
                        updateRooms();
                        updateUsersPositions();
                        break;
                    case 2:
                        showRooms();
                        break;
                    case 3:
                        showRoom();
                        break;
                    case 4:
                        deleteRoom();
                        break;
                    default:
                        optionSubMenu = 0;
                }
                //waitForContinue();
                break;
            case 3:
                System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Opções para Espaços:");
                showSubMenu();
                requestOptionSubMenu();
                switch (optionSubMenu){
                    case 1:
                        addCoffee();
                        CoffeeController.insertCoffees(coffees);
                        updateCoffees();
                        updateUsersPositions();
                        break;
                    case 2:
                        showCoffees();
                        break;
                    case 3:
                        showCoffee();
                        break;
                    case 4:
                        deleteCoffee();
                        break;
                    default:
                        optionSubMenu = 0;
                }
                //waitForContinue();
                break;
            case 4:
                deleteData();
                //waitForContinue();
                break;
            default:
                optionMenu = 0;
        }
    }

    /**
     * Método para adicionar novas pessoas.
     */
    private void addUser(){
        boolean newUser = true;
        do {
            if (UserController.verifyCapacity(rooms, users.size() + 1)){
                System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Adicionar Nova pessoa:");
                try{
                    System.out.println("Informe o nome da pessoa:");
                    String name = scanner.nextLine();
                    User user = new User();
                    user.setNameUser(name);
                    users.add(user);
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                    if (UserController.verifyCapacity(rooms, users.size() + 1)){
                        System.out.println("Adicionar nova pessoa?");
                        System.out.println("\t 1 - Sim");
                        System.out.println("\t 0 - Não");
                        if (Integer.parseInt(scanner.nextLine()) != 1){
                            newUser = false;
                        }
                    } else{
                        System.out.println("Não há capacidade suficiente!");
                        newUser = false;
                    }
                } catch(CustomException error){
                    System.out.println(error.getMessage());
                    newUser = false;
                } catch (Exception error){
                    System.out.println("Informe um valor válido!");
                }
            } else{
                System.out.println("Não há capacidade suficiente!");
                newUser = false;
            }
        } while (newUser);
    }

    /**
     * Método para adicionar novas salas.
     */
    private void addRoom(){
        boolean newRoom = true;
        do {
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Adicionar Nova Sala:");
            try{
                System.out.println("Informe o nome da sala:");
                String name = scanner.nextLine();
                System.out.println("Informe a capacidade da sala:");
                int capacity = Integer.parseInt(scanner.nextLine());
                Room room = new Room();
                room.setNameRoom(name);
                room.setCapacityRoom(capacity);
                List<Room> roomsForVerify = new ArrayList<Room>();
                for (Room r: rooms) {
                    roomsForVerify.add(r);
                }
                roomsForVerify.add(room);
                if (UserController.verifyCapacity(roomsForVerify, users.size())){
                    rooms.add(room);
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Adicionar nova sala?");
                    System.out.println("\t 1 - Sim");
                    System.out.println("\t 0 - Não");
                    if (Integer.parseInt(scanner.nextLine()) != 1){
                        newRoom = false;
                    }
                } else{
                    System.out.println("Não é possível adicionar a sala: Algumas pessoas não poderão ficar lotadas!");
                    newRoom = false;
                }
            } catch(CustomException error){
                System.out.println(error.getMessage());
            } catch (Exception error){
                System.out.println("Informe um valor válido!");
            }
        } while (newRoom);
    }

    /**
     * Método para adicionar novos espaços de café.
     */
    private void addCoffee(){
        boolean newCoffee = true;
        do {
            if (coffees.size() < 2){
                System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Adicionar Novo Espaço de Café:");
                try{
                    System.out.println("Informe o nome do espaço de café:");
                    String name = scanner.nextLine();
                    Coffee coffee = new Coffee();
                    coffee.setNameCoffee(name);
                    coffees.add(coffee);
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                    if (coffees.size() < 2){
                        System.out.println("Adicionar novo espaço de café?");
                        System.out.println("\t 1 - Sim");
                        System.out.println("\t 0 - Não");
                        if (Integer.parseInt(scanner.nextLine()) != 1){
                            newCoffee = false;
                        }
                    } else{
                        newCoffee = false;
                        System.out.println("Não é possível adicionar mais espaços de café!");
                    }

                } catch(CustomException error){
                    System.out.println(error.getMessage());
                    break;
                } catch (Exception error){
                    System.out.println("Informe um valor válido!");
                }
            } else{
                newCoffee = false;
                System.out.println("Não é possível adicionar mais espaços de café!");
            }

        } while (newCoffee);
    }

    /**
     * Método para mostrar todas as pessoas cadastradas.
     */
    private void showUsers(){
        System.out.println("Pessoas cadastradas:");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\t|" + formatText("Pessoa") +
                "| " + formatText("Sala Etapa 1") +
                "| " + formatText("Sala Etapa 2") +
                "| " + formatText("Espaço Café Etapa 1") +
                "| " + formatText("Espaço Café Etapa 2") + "|");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        for (User u: users) {
            System.out.println("\t|" + formatText(u.getNameUser()) +
                    "| " + formatText(u.getRoom1User().getNameRoom()) +
                    "| " + formatText(u.getRoom2User().getNameRoom()) +
                    "| " + formatText(u.getCoffee1User().getNameCoffee()) +
                    "| " + formatText(u.getCoffee2User().getNameCoffee()) + "|");
        }
        System.out.println("***************************************************************************************************************************");
    }

    /**
     * Método para mostrar uma pessoa pesquisada pelo ID.
     */
    private void findUsers(){
        System.out.println("Informe o nome da pessoa:");
        try{
            String name = scanner.nextLine();
            System.out.println("Pessoa:");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\t|" + formatText("Pessoa") +
                    "| " + formatText("Sala Etapa 1") +
                    "| " + formatText("Sala Etapa 2") +
                    "| " + formatText("Espaço Café Etapa 1") +
                    "| " + formatText("Espaço Café Etapa 2") + "|");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");

            List<User> usersFound = UserController.findUser(name);
            for (User u: usersFound) {
                System.out.println("\t|" + formatText(u.getNameUser()) +
                        "| " + formatText(u.getRoom1User().getNameRoom()) +
                        "| " + formatText(u.getRoom2User().getNameRoom()) +
                        "| " + formatText(u.getCoffee1User().getNameCoffee()) +
                        "| " + formatText(u.getCoffee2User().getNameCoffee()) + "|");
            }
        } catch (Exception error){
            System.out.println("ID inválido!");
        }
        System.out.println("***************************************************************************************************************************");
    }

    /**
     * Método para mostrar todas as salas.
     *
     * Mostra todas as salas cadastradas com as pessoas que estarão em cada sala
     * durante cada etapa.
     */
    private void showRooms(){
        System.out.println("Salas cadastradas:");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        if (rooms.size() > 0){
            for (Room r: rooms) {
                System.out.println("\tID: " + r.getIdRoom() + "\t| Nome: " + r.getNameRoom() + "\t| Capacidade: " + r.getCapacityRoom());
                System.out.println("\t\tPessoas na Etapa 1:");
                List<User> users1 = r.getUsersStage1();
                for (User u: users1) {
                    System.out.println("\t\t\t ID: " + u.getIdUser() + "\t| Nome: " + u.getNameUser());
                }
                List<User> users2 = r.getUsersStage2();
                System.out.println("\t\tPessoas na Etapa 2:");
                for (User u: users2) {
                    System.out.println("\t\t\t ID: " + u.getIdUser() + "\t| Nome: " + u.getNameUser());
                }
                System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            }
        } else{
            System.out.println("Nenhuma sala encontrada!");
        }
        System.out.println("***************************************************************************************************************************");
    }

    /**
     * Método para exibir uma sala pesquisada.
     *
     * Mostra uma sala cadastrada pesquisada por ID com as pessoas que estarão em cada etapa.
     */
    private void showRoom(){
        System.out.println("Informe o ID da sala:");
        try{
            Integer id = Integer.parseInt(scanner.nextLine());
            System.out.println("Sala:");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            Room room = RoomController.findRoom(id);
            if(room.getIdRoom() != null){
                System.out.println("\tID: " + room.getIdRoom() + "\t| Nome: " + room.getNameRoom() + "\t| Capacidade: " + room.getCapacityRoom());
                System.out.println("\t\tPessoas na Etapa 1:");
                List<User> users1 = room.getUsersStage1();
                for (User u: users1) {
                    System.out.println("\t\t\t ID: " + u.getIdUser() + "\t| Nome: " + u.getNameUser());
                }
                List<User> users2 = room.getUsersStage2();
                System.out.println("\t\tPessoas na Etapa 2:");
                for (User u: users2) {
                    System.out.println("\t\t\t ID: " + u.getIdUser() + "\t| Nome: " + u.getNameUser());
                }
                System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            } else{
                System.out.println("Nenhuma sala encontrada!");
            }
        } catch (Exception error){
            System.out.println("ID inválido!");
        }
        System.out.println("***************************************************************************************************************************");
    }

    /**
     * Método para exibir todos os espaços.
     *
     * Mostrar todos os espaços cadastrados com as pessoas que estarão em espaço
     * durante cada etapa.
     */
    private void showCoffees(){
        System.out.println("Espaços cadastrados:");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        if (coffees.size() > 0){
            for (Coffee c: coffees) {
                System.out.println("\tID: " + c.getIdCoffee() + "\t| Nome: " + c.getNameCoffee());
                System.out.println("\t\tPessoas na Etapa 1:");
                List<User> usersInCoffee = c.getUsersStage1();
                for (User u: usersInCoffee) {
                    System.out.println("\t\t\t ID: " + u.getIdUser() + "\t| Nome: " + u.getNameUser());
                }
                usersInCoffee = c.getUsersStage2();
                System.out.println("\t\tPessoas na Etapa 2:");
                for (User u: usersInCoffee) {
                    System.out.println("\t\t\t ID: " + u.getIdUser() + "\t| Nome: " + u.getNameUser());
                }
                System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            }
        } else{
            System.out.println("Nenhum espaço de café encontrado!");
        }
        System.out.println("***************************************************************************************************************************");
    }

    /**
     * Método para exibir um espaço pesquisado.
     *
     * Mostra um espaço cadastrado pesquisado por ID com as pessoas que estarão em cada etapa.
     */
    private void showCoffee(){
        System.out.println("Informe o ID do espaço:");
        try{
            Integer id = Integer.parseInt(scanner.nextLine());
            System.out.println("Espaço:");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            Coffee coffee = CoffeeController.findCoffee(id);
            if (coffee.getIdCoffee() != null){
                System.out.println("\tID: " + coffee.getIdCoffee() + "\t| Nome: " + coffee.getNameCoffee());
                System.out.println("\t\tPessoas na Etapa 1:");
                List<User> usersInCoffee = coffee.getUsersStage1();
                for (User u: usersInCoffee) {
                    System.out.println("\t\t\t ID: " + u.getIdUser() + "\t| Nome: " + u.getNameUser());
                }
                usersInCoffee = coffee.getUsersStage2();
                System.out.println("\t\tPessoas na Etapa 2:");
                for (User u: usersInCoffee) {
                    System.out.println("\t\t\t ID: " + u.getIdUser() + "\t| Nome: " + u.getNameUser());
                }
            } else{
                System.out.println("Nenhum espaço de café encontrado!");
            }
        } catch (Exception error){
            System.out.println("ID inválido!");
        }
        System.out.println("***************************************************************************************************************************");
    }

    /**
     * Método para solicitar a exclusão de uma pessoa.
     */
    private void deleteUser(){
        System.out.println("Pessoas Cadastradas:");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        for (User u: users) {
            System.out.println("\t ID: " + u.getIdUser() + "\t| Nome: " + u.getNameUser());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Informe o ID da pessoa:");
        try{
            Integer idUser = Integer.parseInt(scanner.nextLine());
            new UserDAO().deleteUser(idUser);
            users = UserController.findUsers();
            updateUsersPositions();
        } catch(CustomException error){
            System.out.println(error.getMessage());
        } catch (Exception error){
            System.out.println("Informe um valor válido!");
        }
        System.out.println("***************************************************************************************************************************");
    }

    /**
     * Método para solicitar uma exclusão de uma sala.
     */
    private void deleteRoom(){
        System.out.println("Salas Cadastradas:");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        for (Room r: rooms) {
            System.out.println("\t ID: " + formatText("" + r.getIdRoom()) +
                    "\t| Nome: " + formatText(r.getNameRoom()) +
                    "\t| Capacidade: " + formatText("" + r.getCapacityRoom()));
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Informe o ID da sala:");
        try{
            Integer idRoom = Integer.parseInt(scanner.nextLine());
            Room roomSelected = null;
            for (Room r: rooms) {
                if(r.getIdRoom().equals(idRoom)){
                    roomSelected = r;
                }
            }
            if (roomSelected != null){
                List<Room> roomsAltered = new ArrayList<Room>(rooms);
                roomsAltered.remove(roomSelected);
                if (UserController.verifyCapacity(roomsAltered, users.size())){
                    rooms = roomsAltered;
                    clearRoom();
                    RoomController.removeRoom(roomSelected);
                    rooms = new RoomDAO().getRooms();
                } else{
                    System.out.println("Não é possível excluir a sala: Algumas pessoas não poderão ficar lotadas!");
                }
            } else{
                System.out.println("ID inválido!");
            }
        } catch(CustomException error){
            System.out.println(error.getMessage());
        } catch (Exception error){
            System.out.println("Informe um valor válido!");
        }
        System.out.println("***************************************************************************************************************************");
    }

    /**
     * Método para solicitar a exclusão de um espaço de café.
     */
    private void deleteCoffee(){
        System.out.println("Espaços de Café Cadastrados:");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        for (Coffee c: coffees) {
            System.out.println("\t ID: " + formatText("" + c.getIdCoffee()) +
                    "\t| Nome: " + formatText(c.getNameCoffee()));
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Informe o ID do espaço:");
        try{
            int idCoffee = Integer.parseInt(scanner.nextLine());
            Coffee coffeeSelected = null;
            for (Coffee c: coffees) {
                if(c.getIdCoffee() == idCoffee){
                    coffeeSelected = c;
                }
            }
            if (coffeeSelected != null){
                coffees.remove(coffeeSelected);
                clearCoffee();
                CoffeeController.removeCoffee(coffeeSelected);
                coffees = new CoffeeDAO().getCoffees();
            } else{
                System.out.println("ID inválido!");
            }
        } catch(CustomException error){
            System.out.println(error.getMessage());
        } catch (Exception error){
            System.out.println("Informe um valor válido!");
        }
        System.out.println("***************************************************************************************************************************");
    }

    /**
     * Método para atualizar as posições das pessoas nas salas e espaços durante cada etapa.
     */
    private void updateUsersPositions(){
        if (users.size() > 0){
            try{
                users = UserController.userRaffle(users, rooms, coffees);
                UserController.insertUsers(users);
            } catch (CustomException error){
                System.out.println(error.getMessage());
            }
        }
    }

    /**
     * Método para remover as pessoas da sala.
     *
     * Refaz as posições das pessoas sem a sala selecionada para exclusão,
     * removendo as ligações entre pessoas e a sala, para então poder remove-la.
     */
    private void clearRoom(){
        if (users.size() > 0){
            try{
                users = UserController.userRaffle(users, rooms, coffees);
                UserController.insertUsers(users);
            } catch (CustomException error){
                System.out.println(error.getMessage());
            }
        }
    }

    /**
     * Método para remover as pessoas do espaço.
     *
     * Refaz as posições das pessoas sem o espaço selecionado para exclusão,
     * removendo as ligações entre pessoas e o espaço, para então poder remove-lo.
     */
    private void clearCoffee(){
        if (users.size() > 0){
            try{
                users = UserController.userRaffle(users, rooms, coffees);
                UserController.insertUsers(users);
            } catch (CustomException error){
                System.out.println(error.getMessage());
            }
        }
    }

    /**
     * Método para formatar o tamanho de textos.
     *
     * Formata o texto para até 20 caracteres.
     * Utilizado para deixar a tabela de dados formatada.
     *
     * @param text String
     * @return String
     */
    private String formatText(String text){
        while(text.length() < 20){
            text += " ";
        }
        if (text.length() > 20){
            while(text.length() > 20){
                text = text.substring(0, text.length() - 1);
            }
        }
        return text;
    }

    /**
     * Método para resetar o banco de dados.
     */
    private void deleteData(){
        try{
            System.out.println("Desaja realmente excluir os dados do banco?");
            System.out.println("\t 1 - Sim");
            System.out.println("\t 0 - Não");
            if (Integer.parseInt(scanner.nextLine()) == 1){
                new DatabaseCreator().createDatabase();
            } else{
                System.out.println("Comando cancelado!");
            }
        } catch(CustomException error){
            System.out.println(error.getMessage());
        } catch (Exception error){
            System.out.println("Informe um valor válido!");
            System.out.println("Comando cancelado!");
        }
    }

    /**
     *
     *
    private void waitForContinue(){
        System.out.println("Aperte Enter para continuar...");
        scanner.nextLine();
        try{
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c",
                        "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch(Exception error){
            System.out.println(error.getMessage());
        }
    }
    //*/
}