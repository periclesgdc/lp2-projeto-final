package com.edu.minimarket.domain.operations;

import com.edu.minimarket.connection.ORMProduto;
import com.edu.minimarket.domain.Produto;
import com.edu.minimarket.enums.CategoriaEnum;

import java.util.Arrays;
import java.util.Scanner;

public class ProdutoCli {
    private static ORMProduto ormProduto = new ORMProduto();
    private static Scanner entrada = new Scanner(System.in);

    public static Produto lerDadoProduto(){
        System.out.print("Nome do produto: ");
        String nome =  entrada.nextLine();

        System.out.print("Preço de custo: ");
        double precoCusto = entrada.nextDouble();

        System.out.print("Preço de venda: ");
        double precoVenda = entrada.nextDouble();

        System.out.println("Escolha uma das categorias abaxo: ");
        System.out.println(Arrays.asList(CategoriaEnum.values()));
        CategoriaEnum categoria = CategoriaEnum.valueOf(entrada.next());

        System.out.print("Quantidade inicial de produtos: ");
        Integer quantidade = entrada.nextInt();

       return new Produto(nome, precoCusto, precoVenda, categoria, quantidade);
    }

    public static void salvarProduto(Produto produto) {
        ProdutoCli.ormProduto.salvar(produto);
    }

    public static Long consultarProduto(){
        System.out.print("Digite o id do produto a ser pesquisado: ");
        return entrada.nextLong();
    }

    public static Produto buscarProduto(Long id) {
        return ProdutoCli.ormProduto.buscarPorId(id);
    }
}
