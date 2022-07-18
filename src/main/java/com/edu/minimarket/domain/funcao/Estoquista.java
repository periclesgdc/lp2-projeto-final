package com.edu.minimarket.domain.funcao;

/** Classe com os métodos da permissão de Estoquista do MiniMarket. 
 * @author Davi Carvalho, Pericles Gomes e Larissa Jales
 * @version 1.0 
 * @since Realese 01 da aplicação 
 */

import java.util.List;
import java.util.Scanner;

public class Estoquista extends Funcao{

    public Estoquista() {
        super(List.of(
                PermissoesEnum.CONSULTAR_ESTOQUE,
                PermissoesEnum.INSERIR_ESTOQUE,
                PermissoesEnum.REMOVER_ESTOQUE
        ));
    }
    @Override
    public String exibirPermissoes() {
        return null;
    }

    @Override
    public void executarAcao(PermissoesEnum permissao) throws IllegalArgumentException {
        switch (permissao){
            case INSERIR_ESTOQUE:
                this.inserirEstoque();
                break;
            case REMOVER_ESTOQUE:
                this.removerEstoque();
                break;
            case CONSULTAR_ESTOQUE:
                this.consultarEstoque();
                break;
            default:
                throw new IllegalArgumentException("Permissão inválida para o usuário");

        }
    }

    public String consultarEstoque(){
        return null;
    }

    public String inserirEstoque(){
        Scanner ler = new Scanner(System.in);
        String nomeProduto;
        System.out.print("Nome do produto: ");

        return "";

    }

    public String removerEstoque(){
        return null;
    }
}
