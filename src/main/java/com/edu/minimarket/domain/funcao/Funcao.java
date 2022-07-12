package com.edu.minimarket.domain.funcao;

import javax.persistence.Embeddable;
import java.util.Collection;
import java.util.Scanner;

@Embeddable
public abstract class Funcao {

    protected Scanner entrada;
    protected Collection<PermissoesEnum> permissoes;

    public Funcao(Collection<PermissoesEnum> permissoes) {
        this.permissoes = permissoes;
        this.entrada =  new Scanner(System.in);
    }

    public abstract String exibirPermissoes();
    public abstract void executarAcao(PermissoesEnum permissao) throws Exception;

    public Collection<PermissoesEnum> getPermissoes() {
        return permissoes;
    }
}
