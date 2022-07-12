package com.edu.minimarket;

import java.security.NoSuchAlgorithmException;

import com.edu.minimarket.connection.Fabrica;
import com.edu.minimarket.connection.ORMProduto;
import com.edu.minimarket.connection.ORMUsuario;
import com.edu.minimarket.domain.Produto;
import com.edu.minimarket.domain.Usuario;
import com.edu.minimarket.domain.funcao.Caixa;
import com.edu.minimarket.domain.funcao.Gerente;
import com.edu.minimarket.enums.CategoriaEnum;

public class App {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        Produto feijao = new Produto("Feijão", 10.0, 15.3, CategoriaEnum.CEREAIS, 10);
        Produto arroz = new Produto("Arroz", 500.0, 750.0, CategoriaEnum.CEREAIS, 1);
        Produto papelHigienico = new Produto("Papel Higiênico", 8.50, 10.0, CategoriaEnum.LIMPEZA, 2);
        Produto sabao = new Produto("Sabão Pó", 3.50, 6.0, CategoriaEnum.LIMPEZA, 3);

        Usuario admin = new Usuario("admin", "admin", new Gerente());
        Usuario pericles = new Usuario("periclesgdc", "testeSenha", new Caixa());
        
        Fabrica.prepararConexao();
        Fabrica.abrirConexao();

        ORMProduto ormProd = new ORMProduto();

        ormProd.salvar(feijao, arroz, papelHigienico, sabao);

        ORMUsuario ormUsu = new ORMUsuario();

        ormUsu.salvar(admin, pericles);

        Produto produto = ormProd.buscarPorId(1L);
        produto.detalhes();

        System.out.println("-----");

        ormProd.buscarTodos().forEach(elem -> System.out.println(elem.detalhes()));

        System.out.println("-----");

        ormProd.buscarPorCategoria(CategoriaEnum.LIMPEZA).forEach(elem -> System.out.println(elem.detalhes()));
        ormProd.buscarPorCategoria(CategoriaEnum.CEREAIS).forEach(elem -> System.out.println(elem.detalhes()));
        ormProd.buscarPorCategoria(CategoriaEnum.BEBIDAS).forEach(elem -> System.out.println(elem.detalhes()));

        System.out.println("-----");

        ormProd.buscarPorNome("papel").forEach(elem -> System.out.println(elem.detalhes()));

        System.out.println("-----");

        Usuario retornoUsuarioAdmin = ormUsu.buscarPorNome("admin");
        
        System.out.println(retornoUsuarioAdmin.detalhes());
        System.out.println(retornoUsuarioAdmin.autenticar("admin"));
        System.out.println(retornoUsuarioAdmin.autenticar("testeErrado"));

        System.out.println("-----");

        Usuario retornoUsuarioPericles = ormUsu.buscarPorNome("periclesgdc");

        System.out.println(retornoUsuarioPericles.detalhes());
        System.out.println(retornoUsuarioPericles.autenticar("testeSenha"));
        System.out.println(retornoUsuarioPericles.autenticar("testeErrado"));

        Fabrica.fecharConexao();
    }
}
