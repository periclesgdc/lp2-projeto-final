package com.edu.minimarket.domain.funcao;

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
    public void executarAcao() {
        
    }

    public Boolean adicionarUsuario(String senha){
        return true;
    }
}
