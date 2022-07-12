package com.edu.minimarket.connection;

import java.util.Collection;

import org.hibernate.criterion.Restrictions;

import com.edu.minimarket.domain.Produto;
import com.edu.minimarket.enums.CategoriaEnum;

public class ORMProduto extends ORM<Produto> {

    public ORMProduto() {
        super(Produto.class);
    }

    public Collection<Produto> buscarPorCategoria(CategoriaEnum categoria) {
        return Fabrica.buscar(
            this.classeExtendida,
            Restrictions.eq("categoria", categoria
        ));
    }
}
