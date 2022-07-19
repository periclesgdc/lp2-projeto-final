package com.edu.minimarket.domain;

/** Classe para objetos tipo Produto, onde serão contidos os valores do nome, preço de custo, preço de venda, 
 * categoria, status e quantidade do MiniMarket. 
 * @author Davi Carvalho, Pericles Gomes e Larissa Jales
 * @version 1.0 
 * @since Realese 01 da aplicação 
 */

import com.edu.minimarket.enums.CategoriaEnum;

import javax.persistence.*;

@Entity
public class Produto extends ClasseBase {

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
    private CategoriaEnum categoria;

    @Column(nullable = false)
    private Boolean status = true;

    @Column(nullable = false)
    private Integer quantidade;

    public Produto() {}

    public Produto(String nome, Double precoCusto, Double precoVenda, CategoriaEnum categoria, Integer quantidade) {
        this.nome = nome.toUpperCase();
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return this.id;
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

    public CategoriaEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEnum categoria) {
        this.categoria = categoria;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void adicionarUnidades(Integer quantidade) {
        if (quantidade > 0) {
            this.quantidade += quantidade;
        } else {
            throw new IllegalArgumentException("Não é possível informar uma quantidade negativa.");
        }
    }

    public void removerUnidades(Integer quantidade) {
        if (quantidade > 0 && ((this.quantidade - quantidade) >= 0)) {
            this.quantidade -= quantidade;
        } else {
            throw new IllegalArgumentException("Não é possível informar uma quanidade negativa ou maior que o atual estoque.");
        }
    }

    @Override
    public String detalhes() {
        return String.format(
            "Produto{id = %s, nome = %s, custo = %s, venda = %s, categoria = %s, quantidade = %s, status = %s}",
            this.id,
            this.nome,
            this.precoCusto,
            this.precoVenda,
            this.categoria.name(),
            this.quantidade,
            this.status
        );
    }
}
