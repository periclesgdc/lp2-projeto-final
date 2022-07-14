package com.edu.minimarket.domain.funcao;

import java.util.List;

public class Caixa extends Funcao {

    public Caixa() {
        super(List.of(
            PermissoesEnum.ABRIR_PDV,
            PermissoesEnum.CONSULTAR_PRODUTO
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
