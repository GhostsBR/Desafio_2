package Model;

import CustomExceptions.CustomException;

/**
 * Classe representativa para um Espaço de Café.
 *
 * @author Thiago
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
     *
     * @exception CustomException quando for informado um valor inválido
     *
     * @author Thiago
     *
     * @param id Integer ID do Espaço de café
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
     * @return Integer ID do Espaço de café
     */
    public Integer getIdCoffee (){
        return this.idCoffee;
    }

    /**
     * Método Setter do atributo nameCoffe.
     *
     * Define o valor do nameCoffee, rrealizando validação para textos vazios,
     * só espaços, com menos de 50 caracteres e valor nulo.
     *
     * @exception CustomException quando for informado um valor inválido
     *
     * @author Thiago
     *
     * @param name String nome do Espaço de café
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
}