package Model;

import CustomExceptions.CustomException;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe representativa para uma Sala.
 *
 * @author Thiago
 * @author João
 */
public class Room {

    /**
     * Atributo ID da Sala.
     */
    private Integer idRoom;

    /**
     * Atributo do nome da Sala.
     */
    private String nameRoom;

    /**
     * Atributo da capacidade da Sala.
     */
    private Integer capacityRoom;

    /**
     * Atributo QUANTITY1 da classe Room.
     *
     * Atributo utilizado pelo método de definir a lotação das pessoas.
     * Define a quantidade de pessoas já lotadas na sala durante a Etapa 1.
     * Não é salvo em banco de dados.
     */
    private Integer quantity1 = 0;

    /**
     * Atributo QUANTITY2 da classe Room.
     *
     * Atributo utilizado pelo método de definir a lotação das pessoas.
     * Define a quantidade de pessoas já lotadas na sala durante a Etapa 2.
     * Não é salvo em banco de dados.
     */
    private Integer quantity2 = 0;

    /**
     * Lista de pessoas lotadas na sala durante a etapa 1.
     *
     * Atributo utilizado pelo método de mostrar as pessoas lotadas
     * na sala durante a Etapa 1.
     * Não é salvo em banco de dados.
     */
    private List<User> usersStage1;

    /**
     * Lista de pessoas lotadas na sala durante a etapa 2.
     *
     * Atributo utilizado pelo método de mostrar as pessoas lotadas
     * na sala durante a Etapa 2.
     * Não é salvo em banco de dados.
     */
    private List<User> usersStage2;

    /**
     * Lista de pessoas lotadas na sala.
     *
     * Atributo utilizado pelo método de definir a lotação das pessoas.
     * Não é salvo em banco de dados.
     */
    private List<User> users = new ArrayList<User>();

    /**
     * Construtor vazio da classe Room.
     */
    public Room() {};

    /**
     * Construtor com todos os parâmetros da classe Room.
     *
     * @param idRoom Integer
     * @param nameRoom String
     * @param capacityRoom Integer
     */
    public Room(Integer idRoom, String nameRoom, Integer capacityRoom){
        this.idRoom = idRoom;
        this.nameRoom = nameRoom;
        this.capacityRoom = capacityRoom;
    }

    /**
     * Construtor com o parâmetro nameRoom e capacityRoom da classe Room.
     *
     * Usado para criar entradas novas na tabela de Salas
     * Obs: estas entradas novas vão receber somente o nome e lotação da nova Sala
     * e seu idRoom será atribuído diretamente no Banco de Dados.
     */
    public Room(String name, int capacity){
        this.nameRoom = name;
        this.capacityRoom = capacity;
    }

    /**
     * Método para retornar o valor do atributo idRoom.
     *
     * @return Integer ID da Sala
     */
    public Integer getIdRoom(){
        return this.idRoom;
    }

    /**
     * Método Setter do atributo idRoom.
     *
     * Define o valor do idRoom, realizando validação para valores negativos,
     * zero e nulos.
     *
     * @author João
     * @author Thiago
     *
     * @param id Integer ID da Sala
     * @throws CustomException quando for informado um valor inválido
     */
    public void setIdRoom(Integer id) throws CustomException {
        if (id != null){
            if(id>0){
                this.idRoom = id;
            }else{
                throw new CustomException("Erro: informado um ID negativo ou igual a zero!");
            }
        }else {
            throw new CustomException("Erro: informado um ID nulo!");
        }
    }

    /**
     * Método para retornar o valor do atributo nameRoom.
     *
     * @return String nome da Sala
     */
    public String getNameRoom(){
        return this.nameRoom;
    }

    /**
     * Método Setter do atributo nameRoom.
     *
     * Define o valor do nameRoom, realizando validação para textos vazios,
     * só espaços, com menos de 50 caracteres e valor nulo.
     *
     * @author João
     * @author Thiago
     *
     * @param name String nome da Sala
     * @throws CustomException quando for informado um valor inválido
     */
    public void setNameRoom(String name) throws CustomException {
        if(name!=null){
            name = name.trim();
            if (name.length() > 0 && name.length() <= 50){
                this.nameRoom = name;
            }else {
                throw new CustomException("Erro: informado um nome vazio ou com mais de 50 caracteres!");
            }
        }else {
            throw new CustomException("Erro: informado um nome nulo!");
        }
    }

    /**
     * Método para retornar o valor do atributo capacityRoom.
     *
     * @return Integer capacidade da Sala
     */
    public Integer getCapacityRoom(){
        return this.capacityRoom;
    }

    /**
     * Método Setter do atributo capacityRoom.
     *
     * Define o valor do capacityRoom, realizando validação para valores negativos,
     * zero e nulos.
     *
     * @author João
     * @author Thiago
     *
     * @param capacityRoom Integer capacityRoom da Sala
     * @throws CustomException quando for informado um valor inválido
     */
    public void setCapacityRoom(Integer capacityRoom) throws CustomException {
        if (capacityRoom != null){
            if(capacityRoom > 0){
                this.capacityRoom = capacityRoom;
            }else {
                throw new CustomException("Erro: informado uma capacidade negativa ou igual a zero!");
            }
        }else {
            throw new CustomException("Erro: informado uma capacidade nula!");
        }
    }

    /**
     * Método para retornar o valor do atributo quantity1Room.
     *
     * @return Integer quantidade da Sala na etapa 1
     */
    public Integer getQuantity1(){
        return this.quantity1;
    }

    /**
     * Método Setter do atributo quantity1.
     *
     * Define o valor do quantity1
     *
     * @author João
     *
     * @param quantity1 Integer quantity1 da Sala
     */
    public void setQuantity1(Integer quantity1){
        this.quantity1 = quantity1;
    }

    /**
     * Método para retornar o valor do atributo quantity2Room.
     *
     * @return Integer quantidade da Sala na etapa 2
     */
    public Integer getQuantity2(){
        return this.quantity2;
    }

    /**
     * Método Setter do atributo quantity2.
     *
     * Define o valor do quantity2
     *
     * @author João
     *
     * @param quantity2 Integer quantity2 da Sala
     */
    public void setQuantity2(Integer quantity2){
        this.quantity2 = quantity2;
    }

    /**
     *
     * @return
     */
    public List<User> getUsersStage1() {
        return usersStage1;
    }

    /**
     *
     * @param usersStage1
     */
    public void setUsersStage1(List<User> usersStage1) {
        this.usersStage1 = usersStage1;
    }

    /**
     *
     * @return
     */
    public List<User> getUsersStage2() {
        return usersStage2;
    }

    /**
     *
     * @param usersStage2
     */
    public void setUsersStage2(List<User> usersStage2) {
        this.usersStage2 = usersStage2;
    }

    /**
     *
     * @return
     */
    public String usersStage1ToString (){
        String users = "";
        for (User u: usersStage1) {
            users += u.getNameUser() + ", ";
        }
        users = users.substring(0, users.length() - 2);
        return users;
    }

    /**
     *
     * @return
     */
    public String usersStage2ToString (){
        String users = "";
        for (User u: usersStage2) {
            users += u.getNameUser() + ", ";
        }
        users = users.substring(0, users.length() - 2);
        return users;
    }

    /**
     *
     * @return Lista de usuários
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     *
     * @param user User
     */
    public void setUsers(User user) {
        this.users.add(user);
    }
}