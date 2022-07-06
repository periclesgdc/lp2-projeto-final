package com.edu.minimarket.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.edu.minimarket.enums.Categoria;

@Entity
public class Produto {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String nome;

    @Column(nullable = false)
    private Double precoCusto = 0.0;

    @Column(nullable = false)
    private Double precoVenda = 0.0;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(nullable = false)
    private Boolean status = true;
    
    public Produto(String nome, Double precoCusto, Double precoVenda, Categoria categoria) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String detalhes() {
        return String.format(
            "Produto{id = %s, nome = %s, custo = %s, venda = %s, categoria = %s, status = %s}",
            this.id,
            this.nome,
            this.precoCusto,
            this.precoVenda,
            this.categoria.name(),
            this.status
        );
    }
}
