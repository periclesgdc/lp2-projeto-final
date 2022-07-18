package com.edu.minimarket.domain.funcao;

/** Classe com os métodos da permissão de Caixa do MiniMarket. 
 * @author Davi Carvalho, Pericles Gomes e Larissa Jales
 * @version 1.0 
 * @since Realese 01 da aplicação 
 */

import java.util.List;

public class Caixa extends Funcao {

    public Caixa() {
        super(List.of(
            PermissoesEnum.ABRIR_PDV,
            PermissoesEnum.CONSULTAR_ESTOQUE
        ));
    }

    @Override
    public String exibirPermissoes() {
        return null;
    }

    @Override
    public void executarAcao(PermissoesEnum permissao) {
        
    }

    public void abrirPDV() {

    }

    public String consultarEstoque() {
        return null;
    }
}
