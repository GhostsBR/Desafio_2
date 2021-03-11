package Model;

/**
 * Classe representativa para um Espaço de Café
 * @author Thiago
 */
public class Coffee {

    /**
     * Atributo ID do Espaço de Café
     */
    private Integer idCoffee;

    /**
     * Atributo do nome do Espaço de Café
     */
    private String nameCoffee;

    /**
     * Construtor vazio da classe Coffee
     */
    public Coffee(){};

    /**
     * Construtor com todos os parâmetros da classe Coffee
     */
    public Coffee(Integer id, String name){
        this.idCoffee = id;
        this.nameCoffee = name;
    }

    /**
     * Construtor com o parâmetro nameCoffee da classe Coffee
     * usado para criar entradas novas na tabela de Espaços de Café
     * Obs: estas entradas novas vão receber somente o nome do novo Espaço de Café
     * e seu idCoffee será atribuído diretamente no Banco de Dados
     */
    public Coffee(String name){
        this.nameCoffee = name;
    }

    /**
     * Método Setter do atributo idCoffe, realizando validação
     * para valores negativos, zero e nulos.
     * Obs: Cuidado para verificar antes se o valor é nulo,
     * pois se verificar se um valor nulo é menor que 0
     * poderá lançar uma exceção!
     * @param id Integer
     */
    public void setIdCoffee(Integer id){
        //Verifica se o valor é nulo
        if (id != null){
            // Verifica se o valor não é zero ou negativo
            if(id > 0){
                // Altera o valor do atributo idCoffee
                this.idCoffee = id;
            } else{
                System.out.println("Erro: ID do Espaço de Café não poderá ser negativo ou zero!");
            }
        } else{
            System.out.println("Erro: ID do Espaço de Café não poderá ser nulo!");
        }
    }

    /**
     * Método para retornar o valor do atributo idCoffee
     * @return Integer
     */
    public Integer getIdCoffee (){
        return this.idCoffee;
    }

    /**
     * Método Setter do atributo nameCoffe, realizando validação
     * para textos vazios, só espaços, com menos de
     * 50 caracteres e valor nulo.
     * Obs: Cuidado para verificar antes se o valor é nulo,
     * pois se contar os caracteres de um valor nulo
     * poderá lançar uma exceção!
     * Obs2: Cuidado para remover os possíveis espaços da String
     * antes de verificar a quantidade de caracteres!
     * Valor "   " possui 3 caracteres, mas não é um valor válido!
     * @param name String
     */
    public void setNameCoffee(String name){
        // Verifica se o valor é nulo
        if (name != null){
            // Remove os espaços adicionais
            name = name.trim();
            // Verifica se existe pelo menos 1 caracter e se não ultrapassa 50 caracteres
            if (name.length() > 0 && name.length() <= 50){
                // Altera o valor do atributo nameCoffee
                this.nameCoffee = name;
            } else{
                System.out.println("Erro: Nome do Espaço de Café deverá conter entre 1 a 50 caracteres!");
            }
        } else{
            System.out.println("Erro: Nome do Espaço de Café não poderá ser nulo!");
        }
    }

    /**
     * Método para retornar o valor do atributo nameCoffee
     * @return String
     */
    public String getNameCoffee (){
        return this.nameCoffee;
    }
}