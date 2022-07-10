package com.edu.minimarket;

import com.edu.minimarket.connection.Fabrica;
import com.edu.minimarket.connection.ORM;
import com.edu.minimarket.domain.Produto;
import com.edu.minimarket.enums.CategoriaEnum;

public class App {
    public static void main(String[] args) {

        Produto feijao = new Produto("Feijão", 10.0, 15.3, CategoriaEnum.CEREAIS);
        Produto arroz = new Produto("Arroz", 500.0, 750.0, CategoriaEnum.CEREAIS);
        Produto papelHigienico = new Produto("Papel Higiênico", 8.50, 10.0, CategoriaEnum.LIMPEZA);
        Produto sabao = new Produto("Sabão Pó", 3.50, 6.0, CategoriaEnum.LIMPEZA);
        
        Fabrica.prepararConexao();
        Fabrica.abrirConexao();

        ORM<Produto> orm = new ORM<>(Produto.class);

        orm.salvar(feijao);
        orm.salvar(arroz);
        orm.salvar(papelHigienico);
        orm.salvar(sabao, true);

        Produto produto = orm.buscarPorId(1L);
        produto.detalhes();

        System.out.println("-----");

        orm.buscarTodos().forEach(Produto::detalhes);

        Fabrica.fecharConexao();
    }
}
