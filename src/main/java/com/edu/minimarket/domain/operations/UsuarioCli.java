package com.edu.minimarket.domain.operations;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.edu.minimarket.AppTerminal;
import com.edu.minimarket.connection.ORMUsuario;
import com.edu.minimarket.domain.Usuario;
import com.edu.minimarket.domain.funcao.Caixa;
import com.edu.minimarket.domain.funcao.Funcao;
import com.edu.minimarket.domain.funcao.Gerente;
import com.edu.minimarket.domain.funcao.PermissoesEnum;

public class UsuarioCli {
    private static ORMUsuario ormUsuario = new ORMUsuario();
    private static Scanner entrada = new Scanner(System.in);
    private static Usuario usuarioLogado;

    public static void criarUsuarioAdmin() throws NoSuchAlgorithmException {
        try {
            if (UsuarioCli.ormUsuario.buscarPorNome("admin").isEmpty()) {
                UsuarioCli.ormUsuario.salvar(new Usuario("admin", "admin", new Gerente()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Boolean usuarioLogado() {
        return Objects.nonNull(usuarioLogado);
    }

    public static Usuario autenticarUsuario() {
        System.out.print("Usuário: ");
        String nome = entrada.next();

        System.out.print("Senha: ");
        String senha = entrada.next();

        Optional<Usuario> usuarioOpt = UsuarioCli.ormUsuario.buscarPorNome(nome);

        if (Boolean.FALSE.equals(usuarioOpt.isPresent())) {
            System.out.println("Usuário incorreto!");
        } else {
            Usuario usuario = usuarioOpt.get();

            if (usuario.autenticar(senha)) {
                System.out.println(String.format("Seja bem-vindo, %s!", usuario.getNome()));
                usuarioLogado = usuario;
                return usuario;
            } else {
                System.out.println("Senha incorreta!");
            }
        }

        return null;
    }

    public static String exibirPermissoes() {
        List<PermissoesEnum> listed = usuarioLogado.getFuncao().getPermissoes();
        String menu = listed.stream()
                .map(elem -> String.format("%s - %s", listed.indexOf(elem) + 1, elem.getDescricao()))
                .collect(Collectors.joining("\n"));
        menu += "\n0 - Sair";

        return menu;
    }

    public static void solicitarAcao() {
        System.out.print("Ação: ");
        Integer opcao = entrada.nextInt();
        AppTerminal.divisoria();

        if (opcao > 0) {
            try {
                usuarioLogado.getFuncao().executarAcao(usuarioLogado.getFuncao().getPermissoes().get(opcao - 1));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            usuarioLogado = null;
        }
    }

    public static void criarGerente() {
        UsuarioCli.criarUsuario(new Gerente());
    }

    public static void criarCaixa() {
        UsuarioCli.criarUsuario(new Caixa());
    }
    public static void criarUsuario(Funcao funcao){
        System.out.print("Usuário: ");
        String nome = entrada.next();

        System.out.print("Senha: ");
        String senha = entrada.next();
        System.out.println(nome);
        System.out.println(senha);
        try {
            UsuarioCli.ormUsuario.salvar(new Usuario(nome, senha, funcao));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
