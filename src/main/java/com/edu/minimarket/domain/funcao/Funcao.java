package com.edu.minimarket.domain.funcao;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;

import java.util.Collection;
import java.util.Scanner;

@Embeddable
public abstract class Funcao {

    protected Scanner entrada;

    @ElementCollection(fetch = FetchType.LAZY)
    protected Collection<PermissoesEnum> permissoes;

    public Funcao(Collection<PermissoesEnum> permissoes) {
        this.permissoes = permissoes;
        this.entrada =  new Scanner(System.in);
    }

    public abstract String exibirPermissoes();
    public abstract void executarAcao(PermissoesEnum permissao) throws Exception;

    @ElementCollection
    public Collection<PermissoesEnum> getPermissoes() {
        return permissoes;
    }
}
