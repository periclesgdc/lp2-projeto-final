package com.edu.minimarket.connection;

import java.util.Optional;

import org.hibernate.criterion.Restrictions;

import com.edu.minimarket.domain.Usuario;

public class ORMUsuario extends ORM<Usuario> {

    public ORMUsuario() {
        super(Usuario.class);
    }
    
    public Optional<Usuario> buscarPorNome(String nome) {
        return Fabrica
            .buscar(this.classeExtendida, Restrictions.eq("nome", nome))
            .stream()
            .findFirst();
    }
}
