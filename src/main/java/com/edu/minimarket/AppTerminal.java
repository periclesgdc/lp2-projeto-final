package com.edu.minimarket;

import com.edu.minimarket.connection.Fabrica;
import com.edu.minimarket.domain.operations.UsuarioCli;

public class AppTerminal {

    private static final String DIVISORIA = "----------------------------------------";

    private static Boolean autenticado = false;

    public static void iniciarPrograma() throws Exception {
        try {
            Fabrica.prepararConexao();
            Fabrica.abrirConexao();

            UsuarioCli.criarUsuarioAdmin();

            blocoTexto("Minimarket, sistema de automação comercial!");

            while (true) {
                if (Boolean.FALSE.equals(autenticado)) {
                    autenticado = UsuarioCli.autenticarUsuario();
                }

                break; // remover depois
            }
        } catch (Exception e) {
            throw e;
        } finally {
            Fabrica.fecharConexao();
        }
    }

    private static void blocoTexto(String conteudo) {
        System.out.println(DIVISORIA);
        System.out.println(conteudo);
        System.out.println(DIVISORIA);
    }
}
