package com.edu.minimarket.domain.funcao;

import java.util.Arrays;

public class Gerente extends Funcao {

    public Gerente() {
        super(Arrays.asList(PermissoesEnum.values()));
    }

    public Boolean adicionarUsuario(String senha){
        return true;
    }

    @Override
    public String exibirPermissoes() {
        return null;
    }

    @Override
    public void executarAcao() {
        
    }
}
