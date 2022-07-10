package com.edu.minimarket.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class Usuario {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, nullable = false, length = 150)
    private String nome;
    @Column(unique = true, nullable = false, length = 40)
    private String login;
    @Column(unique = true, nullable = false, length = 40)
    private String senha;

    protected Usuario(Long id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    public Boolean autenticar(String usuario, String senha){
        return true;
    }
}