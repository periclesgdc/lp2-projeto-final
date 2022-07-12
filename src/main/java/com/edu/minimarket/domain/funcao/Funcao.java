package com.edu.minimarket.domain.funcao;

import javax.persistence.Embeddable;
import java.util.Collection;

@Embeddable
public abstract class Funcao {
    
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
