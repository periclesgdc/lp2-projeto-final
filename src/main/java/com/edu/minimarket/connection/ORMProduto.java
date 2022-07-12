package com.edu.minimarket.connection;

import com.edu.minimarket.domain.Produto;

public class ORMProduto extends ORM<Produto> {

    public ORMProduto() {
        super(Produto.class);
    }

}
