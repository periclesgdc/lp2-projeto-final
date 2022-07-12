package com.edu.minimarket;

import java.security.NoSuchAlgorithmException;

import com.edu.minimarket.connection.Fabrica;
import com.edu.minimarket.connection.ORM;
import com.edu.minimarket.connection.ORMUsuario;
import com.edu.minimarket.domain.Estoque;
import com.edu.minimarket.domain.Produto;
import com.edu.minimarket.domain.Usuario;
import com.edu.minimarket.domain.funcao.Caixa;
import com.edu.minimarket.domain.funcao.Gerente;
import com.edu.minimarket.enums.CategoriaEnum;

public class App {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        Produto feijao = new Produto("Feijão", 10.0, 15.3, CategoriaEnum.CEREAIS);
        Produto arroz = new Produto("Arroz", 500.0, 750.0, CategoriaEnum.CEREAIS);
        Produto papelHigienico = new Produto("Papel Higiênico", 8.50, 10.0, CategoriaEnum.LIMPEZA);
        Produto sabao = new Produto("Sabão Pó", 3.50, 6.0, CategoriaEnum.LIMPEZA);

        Estoque estoqueFeijao = new Estoque(feijao, 500);

        Usuario admin = new Usuario("admin", "admin", new Gerente());
        Usuario pericles = new Usuario("periclesgdc", "testeSenha", new Caixa());
        
        Fabrica.prepararConexao();
        Fabrica.abrirConexao();

        ORM<Produto> ormProd = new ORM<>(Produto.class);

        ormProd.salvar(feijao);
        ormProd.salvar(arroz);
        ormProd.salvar(papelHigienico);
        ormProd.salvar(sabao);
        
        ORM<Estoque> ormEst = new ORM<>(Estoque.class);

        ormEst.salvar(estoqueFeijao);

        ORMUsuario ormUsu = new ORMUsuario(Usuario.class);

        ormUsu.salvar(admin);
        ormUsu.salvar(pericles, true);

        Produto produto = ormProd.buscarPorId(1L);
        produto.detalhes();

        System.out.println("-----");

        ormProd.buscarTodos().forEach(elem -> System.out.println(elem.detalhes()));
        ormEst.buscarTodos().forEach(elem -> System.out.println(elem.detalhes()));

        Usuario retornoUsuarioAdmin = ormUsu.buscarPorNome("admin");
        
        System.out.println(retornoUsuarioAdmin.detalhes());
        System.out.println(retornoUsuarioAdmin.autenticar("admin"));
        System.out.println(retornoUsuarioAdmin.autenticar("testeErrado"));

        Usuario retornoUsuarioPericles = ormUsu.buscarPorNome("periclesgdc");

        System.out.println(retornoUsuarioPericles.detalhes());
        System.out.println(retornoUsuarioPericles.autenticar("testeSenha"));
        System.out.println(retornoUsuarioPericles.autenticar("testeErrado"));

        Fabrica.fecharConexao();
    }
}
