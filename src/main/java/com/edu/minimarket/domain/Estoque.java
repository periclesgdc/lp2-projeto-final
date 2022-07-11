package com.edu.minimarket.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Estoque extends ClasseBase {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(unique = true)
    private Produto produto;

    @Column(nullable = false)
    private Integer quantidade;

    public Estoque(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public void inserirProduto(Integer quantidade) {
        this.quantidade +=  quantidade;
    }

    public void retirarProduto(Integer quantidade) {
        this.quantidade -= quantidade;
    }

    public String exibirRelatorio() {
        return "";
    }

    @Override
    public String detalhes() {
        return String.format(
            "Estoque{id = %s, produto = %s, quantidade = %s}",
            this.id,
            this.produto.getNome(),
            this.quantidade
        );
    }
}
