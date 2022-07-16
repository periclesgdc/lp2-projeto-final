package com.edu.minimarket.domain.funcao;

import java.util.List;

public class Estoquista extends Funcao {

    public Estoquista() {
        super(List.of(
            PermissoesEnum.CONSULTAR_PRODUTO,
            PermissoesEnum.INSERIR_PRODUTO,
            PermissoesEnum.REMOVER_PRODUTO
        ));
    }
}
