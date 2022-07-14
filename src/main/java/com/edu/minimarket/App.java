package com.edu.minimarket;

import com.edu.minimarket.domain.funcao.Estoquista;
import com.edu.minimarket.domain.funcao.Funcao;
import com.edu.minimarket.domain.funcao.PermissoesEnum;

public class App {
    public static void main(String[] args) throws Exception {
        Funcao estoquista = new Estoquista();
        estoquista.executarAcao(PermissoesEnum.INSERIR_PRODUTO);
        estoquista.executarAcao(PermissoesEnum.INSERIR_PRODUTO);
//        estoquista.executarAcao(PermissoesEnum.CONSULTAR_PRODUTO);

//        Produto feijao = new Produto("Feijão", 10.0, 15.3, CategoriaEnum.CEREAIS, 10);
//        Produto arroz = new Produto("Arroz", 500.0, 750.0, CategoriaEnum.CEREAIS, 1);
//        Produto papelHigienico = new Produto("Papel Higiênico", 8.50, 10.0, CategoriaEnum.LIMPEZA, 2);
//        Produto sabao = new Produto("Sabão Pó", 3.50, 6.0, CategoriaEnum.LIMPEZA, 3);
//
//        Usuario admin = new Usuario("admin", "admin", new Gerente());
//        Usuario pericles = new Usuario("periclesgdc", "testeSenha", new Caixa());
//
//        Fabrica.prepararConexao();
//        Fabrica.abrirConexao();
//
//        ORMProduto ormProd = new ORMProduto();
//
//        ormProd.salvar(feijao, arroz, papelHigienico, sabao);
//
//        ORMUsuario ormUsu = new ORMUsuario();
//
//        ormUsu.salvar(admin, pericles);
//
//        Produto produto = ormProd.buscarPorId(1L);
//        produto.detalhes();
//
//        System.out.println("-----");
//
//        ormProd.buscarTodos().forEach(elem -> System.out.println(elem.detalhes()));
//
//        Usuario retornoUsuarioAdmin = ormUsu.buscarPorNome("admin");
//
//        System.out.println(retornoUsuarioAdmin.detalhes());
//        System.out.println(retornoUsuarioAdmin.autenticar("admin"));
//        System.out.println(retornoUsuarioAdmin.autenticar("testeErrado"));
//
//        Usuario retornoUsuarioPericles = ormUsu.buscarPorNome("periclesgdc");
//
//        System.out.println(retornoUsuarioPericles.detalhes());
//        System.out.println(retornoUsuarioPericles.autenticar("testeSenha"));
//        System.out.println(retornoUsuarioPericles.autenticar("testeErrado"));
//
//        Fabrica.fecharConexao();
    }
}
