package com.edu.minimarket.domain.funcao;

import java.util.Collection;

import javax.persistence.Embeddable;

@Embeddable
public abstract class Funcao {
    
    private Collection<PermissoesEnum> permissoes;

    public Funcao(Collection<PermissoesEnum> permissoes) {
        this.permissoes = permissoes;
    }

    public abstract String exibirPermissoes();
    public abstract void executarAcao();

    public Collection<PermissoesEnum> getPermissoes() {
        return permissoes;
    }
}
