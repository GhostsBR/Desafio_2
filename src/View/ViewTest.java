package View;

import Controller.UserController;
import CustomExceptions.CustomException;
import Model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ViewTest {

    private final Scanner scanner = new Scanner(System.in);
    private int opcao = 0;
    private List<User> pessoas;
    private List<Room> salas;
    private List<Coffee> espacos;

    public void run(){
        do {
            carregarDados();
            mostrarMenu();
            pedirOpcao();
            verificarOpcao();
        } while (opcao != 0);
    }

    private void carregarDados(){
        try{
            pessoas = new UserDAO().getUsers();
        } catch(CustomException error){
            System.out.println(error.getMessage());
            pessoas = new ArrayList<User>();
        }
        try{
            salas = new RoomDAO().getRooms();
        } catch(CustomException error){
            System.out.println(error.getMessage());
            salas = new ArrayList<Room>();
        }
        try{
            espacos = new CoffeeDAO().getCoffees();
        } catch(CustomException error){
            System.out.println(error.getMessage());
            espacos = new ArrayList<Coffee>();
        }
    }

    private void mostrarMenu(){
        System.out.println("Opções:");
        System.out.println("\t 1 - Cadastrar Nova Pessoa");
        System.out.println("\t 2 - Cadastrar Nova Sala");
        System.out.println("\t 3 - Cadastrar Novo Espaço de Café");
        System.out.println("\t 4 - Excluir Pessoa");
        System.out.println("\t 5 - Excluir Sala");
        System.out.println("\t 6 - Excluir Espaço de Café");
        System.out.println("\t 7 - Mostrar Pessoas");
        System.out.println("\t 8 - Mostrar Salas");
        System.out.println("\t 9 - Mostrar Espaços de Café");
        System.out.println("\t 0 - Sair");
    }

    private void pedirOpcao(){
        boolean continua = true;
        do {
            try{
                System.out.println("Informe a opção desejada:");
                opcao = Integer.parseInt(scanner.nextLine());
                continua = false;
            } catch(Exception error){
                System.out.println("Informe uma opção válida!");
            }
        } while(continua);
    }

    private void verificarOpcao(){
        switch (opcao){
            case 1:
                if (salas.size() == 0 || espacos.size() == 0){
                    System.out.println("Não há capacidade suficiente!");
                } else{
                    addPessoa();
                    atualizarLotacao();
                }
                break;
            case 2:
                addSala();
                break;
            case 3:
                addEspaco();
                break;
            case 4:
                excluirPessoa();
                break;
            case 5:
                excluirSala();
                break;
            case 6:
                excluirEspaco();
                break;
            case 7:
                mostrarPessoas();
                break;
            case 8:
                mostrarSalas();
                break;
            case 9:
                mostrarEspacos();
                break;
            default:
                opcao = 0;
        }
    }

    private void addPessoa(){
        boolean continua = true;
        do {
            if (UserController.verifyCapacity(salas, pessoas.size() + 1)){
                try{
                    System.out.println("Informe o nome da pessoa:");
                    String nome = scanner.nextLine();
                    User pessoa = new User();
                    pessoa.setNameUser(nome);
                    pessoas.add(pessoa);
                    System.out.println("Adicionar nova pessoa?");
                    System.out.println("\t 1 - Sim");
                    System.out.println("\t 0 - Não");
                    if (Integer.parseInt(scanner.nextLine()) != 1){
                        continua = false;
                    }
                } catch(CustomException error){
                    System.out.println(error.getMessage());
                    continua = false;
                } catch (InputMismatchException error){
                    System.out.println("Informe um valor válido!");
                }
            } else{
                System.out.println("Não há capacidade suficiente!");
                continua = false;
            }
        } while (continua);
    }

    private void addSala(){
        boolean continua = true;
        do {
            try{
                System.out.println("Informe o nome da sala:");
                String nome = scanner.nextLine();
                System.out.println("Informe a capacidade da sala:");
                int capacidade = Integer.parseInt(scanner.nextLine());
                Room sala = new Room();
                sala.setNameRoom(nome);
                sala.setCapacityRoom(capacidade);
                List<Room> rooms = salas;
                rooms.add(sala);
                if (UserController.verifyCapacity(rooms, pessoas.size())){
                    new RoomDAO().createRoom(sala);
                    atualizarLotacao();
                    System.out.println("Adicionar nova sala?");
                    System.out.println("\t 1 - Sim");
                    System.out.println("\t 0 - Não");
                    if (Integer.parseInt(scanner.nextLine()) != 1){
                        continua = false;
                    }
                } else{
                    System.out.println("Não é possível adicionar a sala: Algumas pessoas não poderão ficar lotadas!");
                    continua = false;
                }
            } catch(CustomException error){
                System.out.println(error.getMessage());
            } catch (InputMismatchException error){
                System.out.println("Informe um valor válido!");
            }
        } while (continua);
    }

    private void addEspaco(){
        boolean continua = true;
        do {
            try{
                System.out.println("Informe o nome do espaço de café:");
                String nome = scanner.nextLine();
                Coffee espaco = new Coffee();
                espaco.setNameCoffee(nome);
                new CoffeeDAO().createCoffee(espaco);
                atualizarLotacao();
                System.out.println("Adicionar novo espaço de café?");
                System.out.println("\t 1 - Sim");
                System.out.println("\t 0 - Não");
                if (Integer.parseInt(scanner.nextLine()) != 1){
                    continua = false;
                }
            } catch(CustomException error){
                System.out.println(error.getMessage());
                break;
            } catch (InputMismatchException error){
                System.out.println("Informe um valor válido!");
            }
        } while (continua);
    }

    private void mostrarPessoas(){
        System.out.println("Pessoas cadastradas:");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("\t|" + formatText("Pessoa") +
                            "| " + formatText("Sala Etapa 1") +
                            "| " + formatText("Sala Etapa 2") +
                            "| " + formatText("Espaço Café Etapa 1") +
                            "| " + formatText("Espaço Café Etapa 2") + "|");
        for (User u: pessoas) {
            System.out.println("\t|" + formatText(u.getNameUser()) +
                            "| " + formatText(u.getRoom1User().getNameRoom()) +
                            "| " + formatText(u.getRoom2User().getNameRoom()) +
                            "| " + formatText(u.getCoffee1User().getNameCoffee()) +
                            "| " + formatText(u.getCoffee2User().getNameCoffee()) + "|");
        }
        System.out.println("***************************************************************************************************************************");
    }

    private void mostrarSalas(){
        try{
            System.out.println("Salas cadastradas:");
            System.out.println("------------------------------------------------------------------------------------------------");
            if (salas.size() > 0){
                UserDAO dao = new UserDAO();
                for (Room r: salas) {
                    System.out.println("\tID: " + r.getIdRoom() + "\t| Nome: " + r.getNameRoom() + "\t| Capacidade: " + r.getCapacityRoom());
                    System.out.println("\tPessoas na Etapa 1:");
                    List<User> users1 = dao.getUsersRoom("id_room1", r.getIdRoom());
                    List<User> users2 = dao.getUsersRoom("id_room2", r.getIdRoom());
                    for (User u: users1) {
                        System.out.println("\t\t ID: " + u.getIdUser() + "\t| Nome: " + u.getNameUser());
                    }
                    System.out.println("\tPessoas na Etapa 2:");
                    for (User u: users2) {
                        System.out.println("\t\t ID: " + u.getIdUser() + "\t| Nome: " + u.getNameUser());
                    }
                    System.out.println("------------------------------------------------------------------------------------------------");
                }
            } else{
                System.out.println("Nenhuma sala encontrada!");
            }
        } catch(CustomException error){
            System.out.println(error.getMessage());
        }
        System.out.println("***************************************************************************************************************************");
    }

    private void mostrarEspacos(){
        try{
            System.out.println("Espaços cadastrados:");
            System.out.println("------------------------------------------------------------------------------------------------");
            if (espacos.size() > 0){
                UserDAO dao = new UserDAO();
                for (Coffee c: espacos) {
                    System.out.println("\tID: " + c.getIdCoffee() + "\t| Nome: " + c.getNameCoffee());
                    List<User> users1 = dao.getUsersRoom("id_coffee1", c.getIdCoffee());
                    List<User> users2 = dao.getUsersRoom("id_coffee2", c.getIdCoffee());
                    System.out.println("\tPessoas na Etapa 1:");
                    for (User u: pessoas) {
                        if (c.getIdCoffee() == u.getCoffee1User().getIdCoffee()){
                            System.out.println("\t\t ID: " + u.getIdUser() + "\t| Nome: " + u.getNameUser());
                        }
                    }
                    System.out.println("\tPessoas na Etapa 2:");
                    for (User u: pessoas) {
                        if (c.getIdCoffee() == u.getCoffee2User().getIdCoffee()){
                            System.out.println("\t\t ID: " + u.getIdUser() + "\t| Nome: " + u.getNameUser());
                        }
                    }
                    System.out.println("------------------------------------------------------------------------------------------------");
                }
            } else{
                System.out.println("Nenhum espaço de café encontrado!");
            }
        } catch(Exception error){
            System.out.println(error.getMessage());
        }
        System.out.println("***************************************************************************************************************************");
    }

    private void excluirPessoa(){
        System.out.println("Informe o ID da pessoa:");
        try{
            Integer idPessoa = Integer.parseInt(scanner.nextLine());
            new UserDAO().deleteUser(idPessoa);
            pessoas = new UserDAO().getUsers();
            atualizarLotacao();
        } catch(CustomException error){
            System.out.println(error.getMessage());
        } catch (Exception error){
            System.out.println("Informe um valor válido!");
        }
        System.out.println("***************************************************************************************************************************");
    }

    private void excluirSala(){
        System.out.println("Informe o ID da sala:");
        try{
            Integer idSala = Integer.parseInt(scanner.nextLine());
            Room salaSelecionada = null;
            for (Room r: salas) {
                if(r.getIdRoom() == idSala){
                    salaSelecionada = r;
                }
            }
            if (salaSelecionada != null){
                List<Room> roomsAltered = salas;
                roomsAltered.remove(salaSelecionada);
                if (UserController.verifyCapacity(roomsAltered, pessoas.size())){
                    salas = roomsAltered;
                    limparSala();
                    new RoomDAO().deleteRoom(idSala);
                    salas = new RoomDAO().getRooms();
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

    private void excluirEspaco(){
        System.out.println("Informe o ID do espaço:");
        try{
            int idEspaco = Integer.parseInt(scanner.nextLine());
            Coffee espacoSelecionado = null;
            for (Coffee c: espacos) {
                if(c.getIdCoffee() == idEspaco){
                    espacoSelecionado = c;
                }
            }
            if (espacoSelecionado != null){
                espacos.remove(espacoSelecionado);
                limparEspaco();
                new CoffeeDAO().deleteCoffee(idEspaco);
                espacos = new CoffeeDAO().getCoffees();
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

    private void atualizarLotacao(){
        if (pessoas.size() > 0){
            try{
                try{
                    salas = new RoomDAO().getRooms();
                } catch(CustomException error){
                    System.out.println(error.getMessage());
                    salas = new ArrayList<Room>();
                }
                try{
                    espacos = new CoffeeDAO().getCoffees();
                } catch(CustomException error){
                    System.out.println(error.getMessage());
                    espacos = new ArrayList<Coffee>();
                }
                for (User u: pessoas) {
                    u.setPositionRoom(0);
                    u.setPositionCoffee(0);
                    u.setIdTemp(0);
                }
                pessoas = UserController.userRaffle(pessoas, salas, espacos);
                UserController.insertUser(pessoas);
            } catch (CustomException error){
                System.out.println(error.getMessage());
            }
        }
    }

    private void limparSala(){
        if (pessoas.size() > 0){
            try{
                try{
                    espacos = new CoffeeDAO().getCoffees();
                } catch(CustomException error){
                    System.out.println(error.getMessage());
                    espacos = new ArrayList<Coffee>();
                }
                for (Room r: salas) {
                    r.setQuantity1(0);
                    r.setQuantity2(0);
                }
                for (User u: pessoas) {
                    u.setPositionRoom(0);
                    u.setPositionCoffee(0);
                    u.setIdTemp(0);
                }
                pessoas = UserController.userRaffle(pessoas, salas, espacos);
                UserController.insertUser(pessoas);
            } catch (CustomException error){
                System.out.println(error.getMessage());
            }
        }
    }

    private void limparEspaco(){
        if (pessoas.size() > 0){
            try{
                try{
                    salas = new RoomDAO().getRooms();
                } catch(CustomException error){
                    System.out.println(error.getMessage());
                    salas = new ArrayList<Room>();
                }
                for (Room r: salas) {
                    r.setQuantity1(0);
                    r.setQuantity2(0);
                }
                for (User u: pessoas) {
                    u.setPositionRoom(0);
                    u.setPositionCoffee(0);
                    u.setIdTemp(0);
                }
                pessoas = UserController.userRaffle(pessoas, salas, espacos);
                UserController.insertUser(pessoas);
            } catch (CustomException error){
                System.out.println(error.getMessage());
            }
        }
    }

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
}