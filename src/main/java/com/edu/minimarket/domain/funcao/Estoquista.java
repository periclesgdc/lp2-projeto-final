package com.edu.minimarket.domain.funcao;

import com.edu.minimarket.connection.Fabrica;
import com.edu.minimarket.connection.ORM;
import com.edu.minimarket.connection.ORMProduto;
import com.edu.minimarket.domain.ClasseBase;
import com.edu.minimarket.domain.operations.ProdutoCli;

import java.util.List;

public class Estoquista extends Funcao{

    public Estoquista() {
        super(List.of(
                PermissoesEnum.CONSULTAR_PRODUTO,
                PermissoesEnum.INSERIR_PRODUTO,
                PermissoesEnum.REMOVER_PRODUTO
        ));
    }
    @Override
    public String exibirPermissoes() {
        return null;
    }

    @Override
    public void executarAcao(PermissoesEnum permissao) throws IllegalArgumentException {
        switch (permissao){
            case INSERIR_PRODUTO:
                this.inserirEstoque();
                break;
            case REMOVER_PRODUTO:
                this.removerEstoque();
                break;
            case CONSULTAR_PRODUTO:
                this.consultarEstoque();
                break;
            default:
                throw new IllegalArgumentException("Permissão inválida para o usuário");

        }
    }

    public String consultarEstoque(){
        Fabrica.prepararConexao();
        Fabrica.abrirConexao();
        ORM orm = new ORMProduto();
        ClasseBase produto =  orm.buscarPorId(ProdutoCli.consultaProduto());

        System.out.println(produto.toString());
        return null;
    }

    public String inserirEstoque(){

        Fabrica.prepararConexao();
        Fabrica.abrirConexao();
        ORM orm = new ORMProduto();

        orm.salvar(ProdutoCli.lerDadodProduto());

        return "inserir";
    }

    public String removerEstoque(){
        return null;
    }
}
