package com.edu.minimarket.domain.funcao;

import java.util.List;

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
        return null;
    }

    public String removerEstoque(){
        return null;
    }
}
