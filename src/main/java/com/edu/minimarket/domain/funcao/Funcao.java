package com.edu.minimarket.domain.funcao;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;

import java.util.Collection;

@Embeddable
public abstract class Funcao {
    
    @ElementCollection(fetch = FetchType.LAZY)
    private Collection<PermissoesEnum> permissoes;

    public Funcao(Collection<PermissoesEnum> permissoes) {
        this.permissoes = permissoes;
    }

    public abstract String exibirPermissoes();
    public abstract void executarAcao(PermissoesEnum permissao) throws Exception;

    public Collection<PermissoesEnum> getPermissoes() {
        return permissoes;
    }
}
