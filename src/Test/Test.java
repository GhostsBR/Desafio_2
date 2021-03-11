package Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe base para os testes
 * @author Thiago
 */
public abstract class Test {

    /**
     * Lista de possíveis erros do teste
     */
    protected final List<String> erros;

    /**
     * Construtor da Classe Test, definindo uma lista vazia
     * para adicionar os possíveis erros
     */
    public Test(){
        erros = new ArrayList<String>();
    }

    /**
     * Método abstrato para realizar o teste
     */
    public abstract void test();

    /**
     * Método para verificar os erros encontrados
     * @param mensagemPositiva String
     * @param mensagemNegativa String
     */
    protected void verficaErros(String mensagemPositiva, String mensagemNegativa){
        // Verifica se ocorreu erros
        if (erros.size() > 0){
            // Mostra os erros encontrados
            for (String erro: erros) {
                System.out.println(erro);
            }
            System.out.println(mensagemNegativa);
        } else{
            System.out.println(mensagemPositiva);
        }
    }
}