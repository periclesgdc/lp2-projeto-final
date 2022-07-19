package com.edu.minimarket.enums;

/** Classe Enum para tipos de permissões existentes no MiniMarket. 
 * @author Davi Carvalho, Pericles Gomes e Larissa Jales
 * @version 1.0 
 * @since Realese 01 da aplicação 
 */
public enum PermissoesEnum {
    CRIAR_GERENTE("Criar gerente"),
    CRIAR_ESTOQUISTA("Criar estoquista"),
    CONSULTAR_PRODUTO("Consultar estoque"),
    INSERIR_PRODUTO("Inserir Produto"),
    LISTAR_PRODUTOS("Listar Produtos"),
    REMOVER_PRODUTO("Remover Produto");


    private String descricao;

    private PermissoesEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
