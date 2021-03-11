package Model;

/**
 * Classe representativa para um Usuário
 */

public class User {

    /**
     * Criação de atributos da classe User
     * Os atributos room1, room2, coffee1 e coffee2 são
     * inicializados como null, uma vez que inicialmente a tabela
     * users receberá valores nulos para estes atributos.
     */
    private Integer idUser;
    private String nameUser;
    private Integer room1User;
    private Integer room2User;
    private Integer coffee1User;
    private Integer coffee2User;
    private Integer posicionRoom;
    private Integer posicionCoffee;

    /**
     * Construtor vazio da classe User
     */
    public User() {}

    /**
     * Construtor com todos os parâmetros da classe User
     *
     * @param id   Integer
     * @param name String
     */
    public User(Integer id, String name) {
        this.idUser = id;
        this.nameUser = name;
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
     * Construtor com todos os parâmetros da classe User
     * usado para criar a lista de retorno dos Usuários
     *
     * @param id Integer
     * @param name String
     * @param room1 Room
     * @param room2 Room
     * @param coffee1 Coffee
     * @param coffee2 Coffee
     */
    public User(Integer id, String name, Integer room1, Integer room2, Integer coffee1, Integer coffee2) {
        this.idUser = id;
        this.nameUser = name;
        this.room1User = room1;
        this.room2User = room2;
        this.coffee1User = coffee1;
        this.coffee2User = coffee2;
    }

    /**
     * Método Setter do atributo idUser
     * realizando validação para valores negativos, nulos e zero
     * @param id Integer
     */
    public void setIdUser(Integer id) {
        if (id != null) {
            if (id > 0) {
                this.idUser = id;
            } else {
                System.out.println("Erro: ID do Usuário não poderá ser negativo ou zero!");
            }
        } else {
            System.out.println("Erro: ID do Usuário não poderá ser nulo!");
        }
    }

    /**
     * Método Getter do atributo idUser
     * @return Integer
     */
    public Integer getIdUser() {
        return this.idUser;
    }

    /**
     * Método Setter do atributo nameUser
     * realizando validação para textos vazios, somente espaços,
     * menos de 50 caracteres e valor nulo.
     * Remoção de espaços antes e depois da String pelo método trim
     * @param name String
     */
    public void setNameUser(String name) {
        if (name != null) {
            name = name.trim();
            if (name.length() > 0 && name.length() <= 50) {
                this.nameUser = name;
            } else {
                System.out.println("Erro: Nome do Usuário deverá conter entre 1 e 50 caracteres!");
            }
        } else {
            System.out.println("Erro: Nome do usuário não pode ser nulo!");
        }
    }

    /**
     * Método Getter do atributo nomeUser
     *
     * @return String
     */
    public String getNameUser() {
        return this.nameUser;
    }

    /**
     * Método Setter do atributo room1User
     *
     * @param room1 Integer
     */
    public void setRoom1User(Integer room1) {
        this.room1User = room1;
    }

    /**
     * Método Getter do atributo room1User
     *
     * @return room1User
     */
    public Integer getRoom1User() {
        return this.room1User;
    }

    /**
     * Método Setter do atributo room2User
     *
     * @param room2 Room
     */
    public void setRoom2User(Integer room2) {
        this.room2User = room2;
    }

    /**
     * Método Getter do atributo room2User
     *
     * @return room2User
     */
    public Integer getRoom2User() {
        return this.room2User;
    }

    /**
     * Método Setter do atributo coffee1User
     *
     * @param coffee1 Coffee
     */
    public void setCoffee1User(Integer coffee1) {
        this.coffee1User = coffee1;
    }

    /**
     * Método Getter do atributo coffee1User
     *
     * @return coffee1User
     */
    public Integer getCoffee1User() {
        return this.coffee1User;
    }

    /**
     * Método Setter do atributo coffee2User
     *
     * @param coffee2 Coffee
     */
    public void setCoffee2User(Integer coffee2) {
        this.coffee2User = coffee2;
    }

    /**
     * Método Getter do atributo coffee2User
     *
     * @return coffee2User
     */
    public Integer getCoffee2User() {
        return this.coffee2User;
    }

    /**
     * Método Setter do atributo posicionRoom
     *
     * @param posicion Integer
     */
    public void setPosicionRoom(Integer posicion) {
        this.posicionRoom = posicion;
    }

    /**
     * Método Getter do atributo posicionRoom
     *
     * @return posicionRoom Integer
     */
    public Integer getPosicionRoom() {
        return this.posicionRoom;
    }

    /**
     * Método Setter do atributo posicionCoffee
     *
     * @param posicion Integer
     */
    public void setPosicionCoffee(Integer posicion) {
        this.posicionCoffee = posicion;
    }

    /**
     * Método Getter do atributo posicionCoffee
     *
     * @return posicionCoffee Integer
     */
    public Integer getPosicionCoffee() {
        return this.posicionCoffee;
    }
}