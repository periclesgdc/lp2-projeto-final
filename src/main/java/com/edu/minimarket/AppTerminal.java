package com.edu.minimarket;

import java.io.IOException;

import com.edu.minimarket.connection.Fabrica;
import com.edu.minimarket.domain.operations.UsuarioCli;

public class AppTerminal {

    private static final String DIVISORIA = "----------------------------------------";

    public static void iniciarPrograma() throws Exception {
        try {
            Fabrica.prepararConexao();
            Fabrica.abrirConexao();

            UsuarioCli.criarUsuarioAdmin();

            limparConsole();
            blocoTexto("Minimarket, sistema de automação comercial!");

            UsuarioCli.autenticarUsuario();

            while (UsuarioCli.usuarioLogado()) {
                blocoTexto(UsuarioCli.exibirPermissoes());
                UsuarioCli.solicitarAcao();
                limparConsole();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            System.out.println("Até logo!\n\n");
            Fabrica.fecharConexao();
        }
    }

    public static void blocoTexto(String conteudo) {
        System.out.println(String.format("%s\n%s\n%s", DIVISORIA, conteudo, DIVISORIA));
    }

    public static void divisoria() {
        System.out.println(DIVISORIA);
    }

    public static void limparConsole() throws IOException {
        final String os = System.getProperty("os.name");
        
        if (os.contains("Windows")) {
            Runtime.getRuntime().exec("cls");
        } else {
            Runtime.getRuntime().exec("clear");
        }
    }
}
