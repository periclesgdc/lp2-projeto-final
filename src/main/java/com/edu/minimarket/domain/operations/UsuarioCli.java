package com.edu.minimarket.domain.operations;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.Scanner;

import com.edu.minimarket.connection.ORMUsuario;
import com.edu.minimarket.domain.Usuario;
import com.edu.minimarket.domain.funcao.Gerente;

public class UsuarioCli {
    private static ORMUsuario ormUsuario = new ORMUsuario();
    private static Scanner entrada = new Scanner(System.in);

    public static void criarUsuarioAdmin() throws NoSuchAlgorithmException {
        try {
            if (UsuarioCli.ormUsuario.buscarPorNome("admin").isEmpty()) {
                UsuarioCli.ormUsuario.salvar(new Usuario("admin", "admin", new Gerente()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Boolean autenticarUsuario() {
        System.out.print("Usuário: ");
        String nome = entrada.next();

        System.out.print("Senha: ");
        String senha = entrada.next();

        Optional<Usuario> usuarioOpt = UsuarioCli.ormUsuario.buscarPorNome(nome);

        if (Boolean.FALSE.equals(usuarioOpt.isPresent())) {
            System.out.println("Usuário incorreto!");
            return false;
        } else {
            Usuario usuario = usuarioOpt.get();

            if (usuario.autenticar(senha)) {
                System.out.println(String.format("Seja bem-vindo, %s!", usuario.getNome()));
                return true;
            } else {
                System.out.println("Senha incorreta!");
                return false;
            }
        }
    }
}
