package com.edu.minimarket.domain.funcao;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.edu.minimarket.domain.Produto;
import com.edu.minimarket.domain.operations.ProdutoCli;

@Entity
public abstract class Funcao {

    @Id
    @GeneratedValue
    private Long id;

    @ElementCollection(fetch = FetchType.LAZY)
    protected Collection<PermissoesEnum> permissoes;

    public Funcao(Collection<PermissoesEnum> permissoes) {
        this.permissoes = permissoes;
    }

    public Collection<PermissoesEnum> getPermissoes() {
        return permissoes;
    }

    public Set<String> exibirPermissoes() {
        return this.permissoes.stream().map(PermissoesEnum::getDescricao).collect(Collectors.toSet());
    }

    public Object executarAcao(PermissoesEnum permissao) throws Exception {
        switch (permissao) {
            case INSERIR_PRODUTO:
                this.inserirProduto(ProdutoCli.lerDadoProduto());
                break;
            case CONSULTAR_PRODUTO:
                return this.consultarEstoque(ProdutoCli.consultarProduto());
            case REMOVER_PRODUTO:
                this.removerEstoque();
                break;
            default:
                throw new IllegalArgumentException("Permissão inválida para o usuário");
        }

        return null;
    }

    private void inserirProduto(Produto produto) {
        ProdutoCli.salvarProduto(produto);
    }

    private String consultarEstoque(Long id) {
        Produto produto = ProdutoCli.buscarProduto(id);

        return produto.detalhes();
    }

    private void removerEstoque() {
    }
}
