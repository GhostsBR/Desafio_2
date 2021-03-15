package Test;

import java.util.ArrayList;
import java.util.List;
import CustomExceptions.CustomException;

/**
 * Classe base para realizar os testes.
 *
 * @author Thiago
 */
public abstract class Test{

    /**
     * Lista de possíveis erros dos testes.
     */
    protected final List<String> erros;

    /**
     * Construtor da Classe Test, definindo uma lista vazia para adicionar os possíveis erros.
     */
    public Test(){
        erros = new ArrayList<String>();
    }

    /**
     * Método abstrato para realizar o teste.
     *
     * @exception CustomException se ocorrer erros no teste
     */
    public abstract void test() throws CustomException;

    /**
     * Método geral para verificar os erros encontrados.
     *
     * Verifica a lista de erros, exibindo-os caso existam, e define o resultado do teste.
     *
     * @author Thiago
     *
     * @param mensagemPositiva String
     * @param mensagemNegativa String
     */
    protected void verficarErros(String mensagemPositiva, String mensagemNegativa){
        if (erros.size() > 0){
            for (String erro: erros) {
                System.out.println(erro);
            }
            System.out.println(mensagemNegativa);
        } else{
            System.out.println(mensagemPositiva);
        }
    }
}