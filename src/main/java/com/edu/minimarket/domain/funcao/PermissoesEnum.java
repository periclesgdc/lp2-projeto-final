package com.edu.minimarket.domain.funcao;

public enum PermissoesEnum {
    CRIAR_GERENTE("Criar gerente"),
    CRIAR_CAIXA("Criar caixa"),
    CRIAR_ESTOQUISTA("Criar estoquista"),
    ABRIR_PDV("Abrir PDV"),
    CONSULTAR_PRODUTOS("Consultar estoque"),
    INSERIR_PRODUTO("Inserir Produto"),
    LISTAR_PRODUTO("Listar Produtos"),
    REMOVER_PRODUTO("Remover do estoque");



    private String descricao;

    private PermissoesEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
