package com.edu.minimarket.domain.funcao;

/** Classe de entidade base para os tipos de funções do MiniMarket. 
 * @author Davi Carvalho, Pericles Gomes e Larissa Jales
 * @version 1.0 
 * @since Realese 01 da aplicação 
 */

import com.edu.minimarket.domain.operations.ProdutoCli;
import com.edu.minimarket.domain.operations.UsuarioCli;
import com.edu.minimarket.enums.PermissoesEnum;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public List<PermissoesEnum> getPermissoes() {
        return List.copyOf(this.permissoes);
    }

    public Set<String> exibirPermissoes() {
        return this.permissoes.stream().map(PermissoesEnum::getDescricao).collect(Collectors.toSet());
    }

    public void executarAcao(PermissoesEnum permissao) throws Exception {
        switch (permissao) {
            case INSERIR_PRODUTO: {
                ProdutoCli.lerDadoProduto();
                ProdutoCli.salvarProdutos();
            }
                break;
            case REABASTECER_PRODUTO:
                ProdutoCli.reabastecerProduto(ProdutoCli.consultarProduto());
                break;
            case LISTAR_PRODUTOS:
                ProdutoCli.listarProdutos();
                break;
            case CONSULTAR_PRODUTO:
                ProdutoCli.consultarEstoque(ProdutoCli.consultarProduto());
                break;
            case REMOVER_PRODUTO:
                ProdutoCli.removerProdutos(ProdutoCli.consultarProduto());
                break;
            case CRIAR_GERENTE:
                UsuarioCli.criarGerente();
                break;
            case CRIAR_ESTOQUISTA:
                UsuarioCli.criarEstoquista();
                break;
            default:
                throw new IllegalArgumentException("Permissão inválida para o usuário");
        }
    }
}
