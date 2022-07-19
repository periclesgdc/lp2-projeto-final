package com.edu.minimarket.domain.operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.edu.minimarket.connection.ORMProduto;
import com.edu.minimarket.domain.Produto;
import com.edu.minimarket.enums.CategoriaEnum;

public class ProdutoCli {
    private static ORMProduto ormProduto = new ORMProduto();
    private static Scanner entrada = new Scanner(System.in);
    private static List<Produto> produtos = new ArrayList<>();

    public static void lerDadoProduto() {
        resetarEntrada();

        System.out.print("Nome do produto: ");
        String nome = entrada.nextLine();
        System.out.print("Preço de custo: ");
        double precoCusto = entrada.nextDouble();

        System.out.print("Preço de venda: ");
        double precoVenda = entrada.nextDouble();

        System.out.println("Escolha uma das categorias abaxo: ");
        System.out.println(ProdutoCli.exibirCategorias());
        System.out.print("Categoria: ");
        CategoriaEnum categoria = Arrays.asList(CategoriaEnum.values()).get(entrada.nextInt() - 1);

        System.out.print("Quantidade inicial: ");
        Integer quantidade = entrada.nextInt();

        produtos.add(new Produto(nome, precoCusto, precoVenda, categoria, quantidade));
    }

    public static void salvarProdutos() {
        ProdutoCli.ormProduto.salvar(produtos);
    }

    public static Long consultarProduto() {
        resetarEntrada();

        System.out.print("Digite o id do produto: ");
        return entrada.nextLong();
    }

    public static void consultarEstoque(Long id) {
        try {
            System.out.println(buscarProduto(id).detalhes());
            aguardarConfirmacao();
        } catch (Exception e) {
            System.out.println("O produto buscado não existe!");
        }
    }

    public static Produto buscarProduto(Long id) {
        return ProdutoCli.ormProduto.buscarPorId(id);
    }

    public static void listarProdutos() {
        List<Produto> produtosSalvos = ProdutoCli.ormProduto.buscarTodos();
        Map<String, Integer> cabecalhos = new LinkedHashMap<>();

        String result = "Lista de produtos\n\n";

        cabecalhos.put("ID", 8);
        cabecalhos.put("NOME", produtosSalvos.stream().map(Produto::getNome)
                .max(Comparator.comparingInt(String::length)).get().length());
        cabecalhos.put("CUSTO", 10);
        cabecalhos.put("VENDA", 10);
        cabecalhos.put("CATEGORIA", produtosSalvos.stream().map(Produto::getCategoria).map(CategoriaEnum::name)
                .max(Comparator.comparingInt(String::length)).get().length());
        cabecalhos.put("QTD", 6);
        cabecalhos.put("ATIVO", 5);

        var cabecalhosSet = cabecalhos.entrySet().iterator();

        result += String.format("|%s|\n", cabecalhos.keySet().stream().map(elem -> espacos(elem, cabecalhosSet))
                .collect(Collectors.joining("|")));

        result += produtosSalvos.stream()
                .map(elem -> {
                    var cabecalhosSetInternal = cabecalhos.entrySet().iterator();

                    return String.format("|%s|%s|%s|%s|%s|%s|%s|",
                            espacos(elem.getId().toString(), cabecalhosSetInternal),
                            espacos(elem.getNome(), cabecalhosSetInternal),
                            espacos(elem.getPrecoCusto().toString(), cabecalhosSetInternal),
                            espacos(elem.getPrecoVenda().toString(), cabecalhosSetInternal),
                            espacos(elem.getCategoria().name(), cabecalhosSetInternal),
                            espacos(elem.getQuantidade().toString(), cabecalhosSetInternal),
                            espacos(elem.getStatus() ? "V" : "F", cabecalhosSetInternal));
                })
                .collect(Collectors.joining("\n"));

        System.out.println(result);

        aguardarConfirmacao();
    }

    private static String espacos(String item, Iterator<Entry<String, Integer>> parametros) {
        return String.format(" %s %s", item, " ".repeat(parametros.next().getValue() - item.length() + 1));
    }

    private static String exibirCategorias() {
        List<CategoriaEnum> listed = Arrays.asList(CategoriaEnum.values());
        String menu = listed.stream()
                .map(elem -> String.format("%s - %s", listed.indexOf(elem) + 1, elem.toString()))
                .collect(Collectors.joining("\n"));

        return menu;
    }

    public static Produto buscarParaAlterarQuantidade(Long id) {
        resetarEntrada();

        Produto produto = buscarProduto(id);

        System.out.println(String.format("Quantidade atual: %s x%s", produto.getNome(), produto.getQuantidade()));
        System.out.print("Digite o quantia a ser alterada: ");

        return produto;
    }

    public static void removerProdutos(Long id) {
        try {
            Produto produto = ProdutoCli.buscarParaAlterarQuantidade(id);
            Integer quantidade = entrada.nextInt();

            produto.removerUnidades(quantidade);

            ProdutoCli.ormProduto.salvar(produto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void reabastecerProduto(Long id) {
        try {
            Produto produto = ProdutoCli.buscarParaAlterarQuantidade(id);
            Integer quantidade = entrada.nextInt();

            produto.adicionarUnidades(quantidade);

            ProdutoCli.ormProduto.salvar(produto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void aguardarConfirmacao() {
        resetarEntrada();
        System.out.print("\n\nENTER ");
        entrada.nextLine();
    }

    private static void resetarEntrada() {
        entrada = new Scanner(System.in);
    }
}
