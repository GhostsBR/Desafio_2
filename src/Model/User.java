package Model;

import CustomExceptions.CustomException;

/**
 * Classe representativa para um Usuário
 *
 * @author João
 */
public class User {

    /**
     * Atributo ID da pessoa.
     */
    private Integer idUser;

    /**
     * Atributo nome da pessoa.
     */
    private String nameUser;

    /**
     * Atributa da sala onde a pessoa vai estar na etapa 1.
     */
    private Room room1User;

    /**
     * Atributa da sala onde a pessoa vai estar na etapa 2.
     */
    private Room room2User;

    /**
     * Atributa do espaço onde a pessoa vai estar na etapa 1.
     */
    private Coffee coffee1User;

    /**
     * Atributa do espaço onde a pessoa vai estar na etapa 2.
     */
    private Coffee coffee2User;

    /**
     * Atributo positionRoom da classe User.
     *
     * Atributo utilizado pelo método de definir a lotação das pessoas.
     * Não é salvo em banco de dados.
     */
    private Integer positionRoom = 0;

    /**
     * Atributo positionCoffee da classe User.
     *
     * Atributo utilizado pelo método de definir a lotação das pessoas.
     * Não é salvo em banco de dados.
     */
    private Integer positionCoffee = 0;

    /**
     * Atributo idTemp da classe User.
     *
     * Atributo utilizado pelo método de definir a lotação das pessoas.
     * Não é salvo em banco de dados.
     */
    private Integer idTemp = 0;

    /**
     * Construtor vazio da classe User
     */
    public User() {}

    /**
     * Construtor com todos os parâmetros da classe User.
     *
     * @author João
     *
     * @param id Integer ID da pessoa
     * @param name String nome da pessoa
     * @param room1 Room da Etapa 1
     * @param room2 Room da Etapa 2
     * @param coffee1 Coffee da Etapa 1
     * @param coffee2 Coffee da Etapa 2
     */
    public User(Integer id, String name, Room room1, Room room2, Coffee coffee1, Coffee coffee2) {
        this.idUser = id;
        this.nameUser = name;
        this.room1User = room1;
        this.room2User = room2;
        this.coffee1User = coffee1;
        this.coffee2User = coffee2;
    }

    /**
     * Construtor com o parâmetro nameUser da classe User
     * usado para criar entradas novas na tabela de Usuários
     * Obs: estas entradas novas vão receber somente o nome do novo Usuário
     * e futuramente serão populadas com suas Salas e Espaços de Café
     * Obs2: seu atributo idUser será atribuído diretamente no Banco de Dados
     *
     * @param name String
     */
    public User(String name) {
        this.nameUser = name;
    }

    /**
     * Método Setter do atributo idUser.
     *
     * Define o valor do Id do User.
     *
     * @param id Integer
     */
    public void setIdUser(Integer id) {
        this.idUser = id;
        /*
        if (id != null) {
            if (id > 0) {
                this.idUser = id;
            } else {
                throw new CustomException("Erro: informado um Id negativo ou igual a zero!");
            }
        } else {
            throw new CustomException("Erro: informado um Id nulo!");
        }*/
    }

    /**
     * Método Getter do atributo idUser.
     *
     * @return Integer
     */
    public Integer getIdUser() {
        return this.idUser;
    }

    /**
     * Método Setter do atributo nameUser.
     *
     * Define um valor para o nome do User realizando validação para textos vazios,
     * somente espaços, menos de 50 caracteres ou valor nulo.
     *
     * @param name String
     * @throws CustomException quando for informado um valor inválido
     */
    public void setNameUser(String name) throws CustomException {
        if (name != null) {
            name = name.trim();
            if (name.length() > 0 && name.length() <= 50) {
                this.nameUser = name;
            } else {
                throw new CustomException("Erro: informado um nome vazio ou com mais de 50 caracteres!");
            }
        } else {
            throw new CustomException("Erro: informado um nome nulo!");
        }
    }

    /**
     * Método Getter do atributo nomeUser.
     *
     * @return String
     */
    public String getNameUser() {
        return this.nameUser;
    }

    /**
     * Método Setter do atributo room1User.
     *
     * Define um Room correspondente a Sala onde a pessoa ficará durante a Etapa 1
     *
     * @param room1 Room
     * @throws CustomException quando for informado um valor inválido
     */
    public void setRoom1User(Room room1) throws CustomException{
        this.room1User = room1;
        /*if (room1 != null) {

        } else{
            throw new CustomException("Erro: informado uma Sala nula!");
        }*/
    }

    /**
     * Método Getter do atributo room1User.
     *
     * @return Room
     */
    public Room getRoom1User() {
        return this.room1User;
    }

    /**
     * Método Setter do atributo room2User.
     *
     * Define um Room correspondente a Sala onde a pessoa ficará durante a Etapa 2
     *
     * @param room2 Room
     * @throws CustomException quando for informado um valor inválido
     */
    public void setRoom2User(Room room2) throws CustomException{
        this.room2User = room2;
        /*if(room2 != null){

        } else{
            throw new CustomException("Erro: foi informado uma sala nula!");
        }*/
    }

    /**
     * Método Getter do atributo room2User.
     *
     * @return Room
     */
    public Room getRoom2User() {
        return this.room2User;
    }

    /**
     * Método Setter do atributo coffee1User.
     *
     * Define um Coffee correspondente ao Espaço onde a pessoa ficará durante a Etapa 1
     *
     * @param coffee1 Coffee
     * @throws CustomException quando for informado um valor inválido
     */
    public void setCoffee1User(Coffee coffee1) throws CustomException{
        this.coffee1User = coffee1;
        /*if(coffee1 != null){

        } else{
            throw new CustomException("Erro: foi informado um espaço nulo!");
        }*/
    }

    /**
     * Método Getter do atributo coffee1User.
     *
     * @return Coffee
     */
    public Coffee getCoffee1User() {
        return this.coffee1User;
    }

    /**
     * Método Setter do atributo coffee2User.
     *
     * Define um Coffee correspondente ao Espaço onde a pessoa ficará durante a Etapa 2
     *
     * @param coffee2 Coffee
     * @throws CustomException quando for informado um valor inválido
     */
    public void setCoffee2User(Coffee coffee2) throws CustomException{
        this.coffee2User = coffee2;
        /*if(coffee2 != null){

        } else{
            throw new CustomException("Erro: foi informado um espaço nulo!");
        }*/
    }

    /**
     * Método Getter do atributo coffee2User.
     *
     * @return coffee2User
     */
    public Coffee getCoffee2User() {
        return this.coffee2User;
    }

    /**
     * Método Setter do atributo positionRoom.
     *
     * @param position Integer
     */
    public void setPositionRoom(Integer position) {
        this.positionRoom = position;
    }

    /**
     * Método Getter do atributo positionRoom.
     *
     * @return Integer
     */
    public Integer getPositionRoom() {
        return this.positionRoom;
    }

    /**
     * Método Setter do atributo positionCoffee.
     *
     * @param position Integer
     */
    public void setPositionCoffee(Integer position) {
        this.positionCoffee = position;
    }

    /**
     * Método Getter do atributo positionCoffee.
     *
     * @return Integer
     */
    public Integer getPositionCoffee() {
        return this.positionCoffee;
    }

    /**
     *
     * @return
     */
    public Integer getIdTemp() {
        return idTemp;
    }

    /**
     *
     * @param idTemp
     */
    public void setIdTemp(Integer idTemp) {
        this.idTemp = idTemp;
    }
}