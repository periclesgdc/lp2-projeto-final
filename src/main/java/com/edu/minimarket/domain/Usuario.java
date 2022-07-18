package com.edu.minimarket.domain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.edu.minimarket.domain.funcao.Funcao;

@Entity
public class Usuario extends ClasseBase {
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private String senha;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "funcao_id")
    private Funcao funcao;

    public Usuario() {}
    public Usuario(String nome, String senha, Funcao funcao) throws NoSuchAlgorithmException {
        this.nome = nome;
        this.senha = Usuario.encriptarSenha(senha);
        this.funcao = funcao;
    }

    public String getNome() {
        return nome;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public Boolean autenticar(String senha) {
        return Usuario.verificarSenha(senha, this.senha);
    }

    public static String encriptarSenha(String senha) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        md.update(senha.getBytes(StandardCharsets.UTF_8));

        byte[] passEnc = md.digest();

        return new String(passEnc);
    }

    public static Boolean verificarSenha(String senha, String senhaEncriptada) {
        try {
            String senhaInseridaEncriptada = encriptarSenha(senha);

            return senhaInseridaEncriptada.equals(senhaEncriptada);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String detalhes() {
        return String.format(
            "Usuario{id = %s, produto = %s, funcao = %s}",
            this.id,
            this.nome,
            this.funcao.getClass().getSimpleName()
        );
    }
}
