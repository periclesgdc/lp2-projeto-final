package com.edu.minimarket.domain.funcao;

public enum PermissoesEnum {
    CRIAR_GERENTE("Criar gerente"),
    CRIAR_CAIXA("Criar caixa"),
    CRIAR_ESTOQUISTA("Criar estoquista"),
    ABRIR_PDV("Abrir PDV"),
    CONSULTAR_ESTOQUE("Consultar estoque"),
    INSERIR_ESTOQUE("Inserir no estoque"),
    REMOVER_ESTOQUE("Remover do estoque");

    private String descricao;

    private PermissoesEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
