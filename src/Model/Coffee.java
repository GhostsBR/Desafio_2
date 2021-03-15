package Model;

import CustomExceptions.CustomException;

import java.util.List;

/**
 * Classe representativa para um Espaço de Café.
 *
 * @author Thiago
 * @author João
 */
public class Coffee {

    /**
     * Atributo ID do Espaço de Café.
     */
    private Integer idCoffee;

    /**
     * Atributo do nome do Espaço de Café.
     */
    private String nameCoffee;

    /**
     * Lista de pessoas lotadas no espaço durante a Etapa 1
     */
    private List<User> usersStage1;

    /**
     * Lista de pessoas lotadas no espaço durante a Etapa 1
     */
    private List<User> usersStage2;

    /**
     * Construtor vazio da classe Coffee.
     */
    public Coffee(){};

    /**
     * Construtor com todos os parâmetros da classe Coffee.
     */
    public Coffee(Integer id, String name){
        this.idCoffee = id;
        this.nameCoffee = name;
    }

    /**
     * Método Setter do atributo idCoffe.
     *
     * Define o valor do idCoffee, realizando validação para valores negativos,
     * zero e nulos.
     * @author Thiago
     * @param id Integer ID do Espaço de café
     * @throws CustomException quando for informado um valor inválido
     */
    public void setIdCoffee(Integer id) throws CustomException {
        if (id != null){
            if(id > 0){
                this.idCoffee = id;
            } else{
                throw new CustomException("Erro: informado um ID negativo ou igual a 0!");
            }
        } else{
            throw new CustomException("Erro: informado um ID nulo!");
        }
    }

    /**
     * Método para retornar o valor do atributo idCoffee.
     *
     * @return
     */
    public Integer getIdCoffee (){
        return this.idCoffee;
    }

    /**
     * Método Setter do atributo nameCoffe.
     *
     * Define o valor do nameCoffee, realizando validação para textos vazios,
     * só espaços, com menos de 50 caracteres e valor nulo.
     *
     * @author Thiago
     * @param name String nome do Espaço de café
     * @throws CustomException quando for informado um valor inválido
     */
    public void setNameCoffee(String name) throws CustomException {
        if (name != null){
            name = name.trim();
            if (name.length() > 0 && name.length() <= 50){
                this.nameCoffee = name;
            } else{
                throw new CustomException("Erro: informado um nome vazio ou com mais de 50 caracteres!");
            }
        } else{
            throw new CustomException("Erro: informado um nome nulo!");
        }
    }

    /**
     * Método para retornar o valor do atributo nameCoffee
     *
     * @return String nome do Espaço de Café
     */
    public String getNameCoffee (){
        return this.nameCoffee;
    }

    /**
     * Método de retorno do atributo getUsersStage1.
     *
     * @return Lista de pessoas lotadas no espaço durante a Etapa 1
     */
    public List<User> getUsersStage1() {
        return usersStage1;
    }

    /**
     * Método para adicionar pessoas que estarão lotadas no espaço durante a Etapa 1.
     *
     * @param usersStage1 User
     */
    public void setUsersStage1(List<User> usersStage1) {
        this.usersStage1 = usersStage1;
    }

    /**
     * Método de retorno do atributo getUsersStage1.
     *
     * @return Lista de pessoas lotadas no espaço durante a Etapa 2
     */
    public List<User> getUsersStage2() {
        return usersStage2;
    }

    /**
     * Método para adicionar pessoas que estarão lotadas no espaço durante a Etapa 2.
     *
     * @param usersStage2 User
     */
    public void setUsersStage2(List<User> usersStage2) {
        this.usersStage2 = usersStage2;
    }

    /**
     * Método para retornar uma String contendo o nome da pessoas
     * lotadas no espaço durante a Etapa 1.
     *
     * @return String lista com os nomes das pessoas
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
     * Método para retornar uma String contendo o nome da pessoas
     * lotadas no espaço durante a Etapa 2.
     *
     * @return String lista com os nomes das pessoas
     */
    public String usersStage2ToString (){
        String users = "";
        for (User u: usersStage2) {
            users += u.getNameUser() + ", ";
        }
        users = users.substring(0, users.length() - 2);
        return users;
    }
}