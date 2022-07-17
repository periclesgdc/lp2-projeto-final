package com.edu.minimarket.domain.operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.edu.minimarket.AppTerminal;
import com.edu.minimarket.connection.ORMProduto;
import com.edu.minimarket.domain.Produto;
import com.edu.minimarket.enums.CategoriaEnum;

public class ProdutoCli {
    private static ORMProduto ormProduto = new ORMProduto();
    private static Scanner entrada = new Scanner(System.in);
    private static List<Produto> produtos = new ArrayList<>();

    public static void lerDadoProduto() {
        System.out.print("Nome do produto: ");
        String nome =  entrada.nextLine();

        System.out.print("Preço de custo: ");
        double precoCusto = entrada.nextDouble();

        System.out.print("Preço de venda: ");
        double precoVenda = entrada.nextDouble();

        System.out.println("Escolha uma das categorias abaxo: ");
        System.out.println(Arrays.asList(CategoriaEnum.values()));
        CategoriaEnum categoria = CategoriaEnum.valueOf(entrada.next());

        System.out.print("Quantidade inicial: ");
        Integer quantidade = entrada.nextInt();

        produtos.add(new Produto(nome, precoCusto, precoVenda, categoria, quantidade));
    }

    public static void salvarProdutos() {
        ProdutoCli.ormProduto.salvar(produtos);
    }

    public static Long consultarProduto(){
        System.out.print("Digite o id do produto a ser pesquisado: ");
        return entrada.nextLong();
    }

    public static Produto buscarProduto(Long id) {
        return ProdutoCli.ormProduto.buscarPorId(id);
    }

    public static void listarProdutos() {
        String result = "Lista de produtos\n\n";

        List<Produto> produtosSalvos = ProdutoCli.ormProduto.buscarTodos();

        String list = produtosSalvos.stream()
            .map(prod -> prod.detalhes()).collect(Collectors.joining("\n"));
        
        AppTerminal.blocoTexto(result + list);
    }
}
