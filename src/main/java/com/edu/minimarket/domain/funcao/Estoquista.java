package com.edu.minimarket.domain.funcao;

import com.edu.minimarket.connection.Fabrica;
import com.edu.minimarket.connection.ORM;
import com.edu.minimarket.connection.ORMProduto;
import com.edu.minimarket.domain.Produto;
import com.edu.minimarket.enums.CategoriaEnum;

import java.util.Arrays;
import java.util.List;

public class Estoquista extends Funcao{

    public Estoquista() {
        super(List.of(
                PermissoesEnum.CONSULTAR_PRODUTOS,
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
            case CONSULTAR_PRODUTOS:
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
        System.out.print("Nome do produto: ");
        String nome =  entrada.next();

        System.out.print("Preço de custo: ");
        double precoCusto = entrada.nextDouble();

        System.out.print("Preço de venda: ");
        double precoVenda = entrada.nextDouble();;

        System.out.println("Escolho uma das categorias abaxo: ");
        System.out.println(Arrays.asList(CategoriaEnum.values()));
        CategoriaEnum categoria = CategoriaEnum.valueOf(entrada.next());

        System.out.print("Quantidade inicial de produtos: ");
        Integer quantidade = entrada.nextInt();
        entrada.close();

        Produto produto = new Produto(nome, precoCusto, precoVenda, categoria, quantidade);

        Fabrica.prepararConexao();
        Fabrica.abrirConexao();
        ORM orm = new ORMProduto();
        orm.salvar(produto);

        return "inserir";
    }

    public String removerEstoque(){
        return null;
    }
}
