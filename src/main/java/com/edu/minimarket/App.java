package com.edu.minimarket;

import com.edu.minimarket.connection.Fabrica;
import com.edu.minimarket.domain.funcao.Estoquista;
import com.edu.minimarket.domain.funcao.Funcao;
import com.edu.minimarket.domain.funcao.PermissoesEnum;

public class App {
    public static void main(String[] args) throws Exception {
        Fabrica.prepararConexao();
        Fabrica.abrirConexao();

        Funcao estoquista = new Estoquista();
        estoquista.exibirPermissoes().forEach(elem -> System.out.println(elem));
        estoquista.executarAcao(PermissoesEnum.INSERIR_PRODUTO);
        System.out.println(estoquista.executarAcao(PermissoesEnum.CONSULTAR_PRODUTO));

        Fabrica.fecharConexao();
    }
}
