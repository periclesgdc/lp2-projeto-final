package com.edu.minimarket;

import com.edu.minimarket.connection.Fabrica;
import com.edu.minimarket.domain.Produto;
import com.edu.minimarket.enums.Categoria;

public class App {
    public static void main( String[] args ) {
        System.out.println( "-- Testando persistência de produto" );

        Fabrica fabrica = new Fabrica();
        Produto feijao = new Produto("Feijão", 10.0, 15.3, Categoria.CEREAIS);
        Produto arroz = new Produto("Arroz", 500.0, 750.0, Categoria.CEREAIS);
        Produto papelHigienico = new Produto("Papel Higiênico", 8.50, 10.0, Categoria.LIMPEZA);
        
        fabrica.abrirConexao();
        fabrica.salvar(feijao);
        fabrica.salvar(arroz);
        fabrica.salvar(papelHigienico);
        fabrica.fecharConexao();

        System.out.println("-- Encerrando aplicação");
    }
}
