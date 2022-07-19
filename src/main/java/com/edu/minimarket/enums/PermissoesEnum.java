package com.edu.minimarket.enums;

/** Classe Enum para tipos de permissões existentes no MiniMarket. 
 * @author Davi Carvalho, Pericles Gomes e Larissa Jales
 * @version 1.0 
 * @since Realese 01 da aplicação 
 */
public enum PermissoesEnum {
    CRIAR_GERENTE("Criar Gerente"),
    CRIAR_ESTOQUISTA("Criar Estoquista"),
    CONSULTAR_PRODUTO("Consultar Produto"),
    INSERIR_PRODUTO("Inserir Produto"),
    REABASTECER_PRODUTO("Reabastecer Produto"),
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
