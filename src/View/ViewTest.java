package View;

import Controller.UserController;
import CustomExceptions.CustomException;
import Model.*;

import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ViewTest {

    private final Scanner scanner = new Scanner(System.in);
    private int opcao = 0;
    private List<User> pessoas = new ArrayList<User>();
    private List<Room> salas = new ArrayList<Room>();
    private List<Coffee> espacos = new ArrayList<Coffee>();
    private final Controller controller = new Controller();

    public void run(){
        carregarDados();
        do {
            mostrarMenu();
            pedirOpcao();
            verificarOpcao();
        } while (opcao != 0);
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
        System.out.println("Informe a opção desejada:");
        opcao = scanner.nextInt();
    }

    private void verificarOpcao(){
            switch (opcao){
                case 1:
                    if (salas.size() == 0 || espacos.size() == 0){
                        System.out.println("Não há capacidade suficiente!");
                    } else{
                        addPessoa();
                    }
                    break;
                case 2:
                    addSala();
                    pessoas = Controller.userRaffle(pessoas, salas, espacos);
                    break;
                case 3:
                    addEspaco();
                    pessoas = Controller.userRaffle(pessoas, salas, espacos);
                    break;
                case 4:
                    excluirPessoa();
                    pessoas = Controller.userRaffle(pessoas, salas, espacos);
                    break;
                case 5:
                    excluirSala();
                    pessoas = Controller.userRaffle(pessoas, salas, espacos);
                    break;
                case 6:
                    excluirEspaco();
                    pessoas = Controller.userRaffle(pessoas, salas, espacos);
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

    private void mostrarPessoas(){
        System.out.println("Pessoas cadastradas:");
        System.out.println("\t Pessoa \t|\t Sala Etapa 1 \t|\t Sala Etapa 2 \t|\t Espaço Etapa 1 \t|\t Espaço Etapa 2");
        for (User u: pessoas) {
            System.out.println("\t" + u.getNameUser() +
                                "\t|\t" + u.getRoom1User().getNameRoom() +
                                "\t|\t" +  u.getRoom2User().getNameRoom() +
                                "\t|\t" +  u.getCoffee1User().getNameCoffee() +
                                "\t|\t" + u.getCoffee2User().getNameCoffee());
        }
    }

    private void addPessoa(){
        boolean continua = true;
        do {
            if (Controller.verificarCapacidade(salas, pessoas.size() + 1)){
                try{
                    System.out.println("Informe o nome da pessoa:");
                    String nome = scanner.next();
                    User pessoa = new User();
                    pessoa.setNameUser(nome);
                    pessoas.add(pessoa);
                    pessoas = Controller.userRaffle(pessoas, salas, espacos);
                    Controller.insertUser(pessoas);
                    pessoas = new UserDAO().getUsers();
                    System.out.println("Adicionar nova pessoa?");
                    System.out.println("\t 1 - Sim");
                    System.out.println("\t 0 - Não");
                    if (scanner.nextInt() != 1){
                        continua = false;
                    }
                } catch(CustomException error){
                    System.out.println(error.getMessage());
                    continua = false;
                } catch (InputMismatchException error){
                    System.out.println("Não utilize espaços em textos!");
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
                String nome = scanner.next();
                System.out.println(nome);
                System.out.println("Informe a capacidade da sala:");
                int capacidade = scanner.nextInt();
                Room sala = new Room();
                sala.setNameRoom(nome);
                sala.setCapacityRoom(capacidade);
                new RoomDAO().createRoom(sala);
                salas = new RoomDAO().getRooms();
                System.out.println("Adicionar nova sala?");
                System.out.println("\t 1 - Sim");
                System.out.println("\t 0 - Não");
                if (scanner.nextInt() != 1){
                    continua = false;
                }
            } catch(CustomException error){
                System.out.println(error.getMessage());
            } catch (InputMismatchException error){
                System.out.println("Não utilize espaços em textos!");
            }
        } while (continua);
    }

    private void addEspaco(){
        boolean continua = true;
        do {
            try{
                System.out.println("Informe o nome do espaço de café:");
                String nome = scanner.next();
                Coffee espaco = new Coffee();
                espaco.setNameCoffee(nome);
                new CoffeeDAO().createCoffee(espaco);
                espacos = new CoffeeDAO().getCoffees();
                System.out.println("Adicionar novo espaço de café?");
                System.out.println("\t 1 - Sim");
                System.out.println("\t 0 - Não");
                if (scanner.nextInt() != 1){
                    continua = false;
                }
            } catch(CustomException error){
                System.out.println(error.getMessage());
                break;
            } catch (InputMismatchException error){
                System.out.println("Não utilize espaços em textos!");
            }
        } while (continua);
    }

    private void mostrarEspacos(){
        System.out.println("Espaços cadastrados:");
        if (espacos.size() > 0){
            for (Coffee c: espacos) {
                System.out.println("\tID: " + c.getIdCoffee() + "\t| Nome: " + c.getNameCoffee());
                System.out.println("Pessoas na Etapa 1:");
                for (User u: pessoas) {
                    if (c.getIdCoffee() == u.getCoffee1User().getIdCoffee()){
                        System.out.println("\t\t ID: " + u.getIdUser() + "\t| Nome: " + u.getNameUser());
                    }
                }
                System.out.println("Pessoas na Etapa 2:");
                for (User u: pessoas) {
                    if (c.getIdCoffee() == u.getCoffee2User().getIdCoffee()){
                        System.out.println("\t\t ID: " + u.getIdUser() + "\t| Nome: " + u.getNameUser());
                    }
                }
            }
        } else{
            System.out.println("Nenhum espaço de café encontrado!");
        }
    }

    private void mostrarSalas(){
        System.out.println("Salas cadastradas:");
        if (salas.size() > 0){
            for (Room r: salas) {
                System.out.println("\tID: " + r.getIdRoom() + "\t| Nome: " + r.getNameRoom() + "\t| Capacidade: " + r.getCapacityRoom());
                System.out.println("Pessoas na Etapa 1:");
                for (User u: pessoas) {
                    if (r.getIdRoom() == u.getRoom1User().getIdRoom()){
                        System.out.println("\t\t ID: " + u.getIdUser() + "\t| Nome: " + u.getNameUser());
                    }
                }
                System.out.println("Pessoas na Etapa 2:");
                for (User u: pessoas) {
                    if (r.getIdRoom() == u.getRoom2User().getIdRoom()){
                        System.out.println("\t\t ID: " + u.getIdUser() + "\t| Nome: " + u.getNameUser());
                    }
                }
            }
        } else{
            System.out.println("Nenhuma sala encontrada!");
        }
    }

    private void excluirPessoa(){
       
        System.out.println("Informe o ID da pessoa:");
        Integer idPessoa = scanner.nextInt();
        try{
            new UserDAO().deleteUser(idPessoa);
            pessoas = new UserDAO().getUsers();

        } catch(CustomException error){
            System.out.println(error.getMessage());
       
    }

    private void excluirSala(){
        System.out.println("Informe o ID da sala:");
        try{
            Integer idSala = scanner.nextInt();
            Room salaSelecionada = null;
            for (Room r: salas) {
                if(r.getIdRoom() == idSala){
                    salaSelecionada = r;
                }
            }
            if (salaSelecionada != null){
                List<Room> roomsAltered = salas;
                roomsAltered.remove(salaSelecionada);
                if (Controller.verificarCapacidade(roomsAltered, pessoas.size())){
                    new RoomDAO().deleteRoom(idSala);
                    salas = new RoomDAO().getRooms();
                } else{
                    System.out.println("Não é possível excluir a sala: Algumas pessoas não poderão ficar lotadas!");
                }
            } else{
                System.out.println("ID inválido!");
            }
        } catch(Exception error){
            System.out.println(error.getMessage());
        }
    }

    private void excluirEspaco(){
        System.out.println("Informe o ID do espaço:");
        Integer idEspaço = scanner.nextInt();
        try{
            new CoffeeDAO().deleteCoffee(idEspaço);
            espacos = new CoffeeDAO().getCoffees();
        } catch(CustomException error){
            System.out.println(error.getMessage());
        }
    } 
}