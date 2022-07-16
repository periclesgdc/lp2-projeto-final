package com.edu.minimarket.domain.funcao;

import java.util.Arrays;

public class Gerente extends Funcao {

    public Gerente() {
        super(Arrays.asList(PermissoesEnum.values()));
    }
}
