package com.edu.minimarket.connection;

import org.hibernate.criterion.Restrictions;

import com.edu.minimarket.domain.Usuario;

public class ORMUsuario extends ORM<Usuario> {

    public ORMUsuario(Class<Usuario> classeExtendida) {
        super(classeExtendida);
    }
    
    public Usuario buscarPorNome(String nome) {
        return Fabrica
            .buscar(this.classeExtendida, Restrictions.eq("nome", nome))
            .stream()
            .findFirst()
            .orElseThrow();
    }
}
