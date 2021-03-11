package CustomExceptions;

/**
 * Classe para customizar uma exceção.
 *
 * Customização para erros do sistema.
 *
 * @author Thiago
 */
public class CustomException extends Exception {

    /**
     * Mensagem customizada do erro.
     */
    private final String mensagem;

    /**
     * Construtor da Exceção customizada.
     *
     * @param mensagem String
     */
    public CustomException(String mensagem){
        this.mensagem = mensagem;
    }

    /**
     * Método para o acesso à menagem do erro.
     *
     * @return String mensagem do erro
     */
    @Override
    public String getMessage(){
        return mensagem;
    }
}