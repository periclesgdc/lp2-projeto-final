package com.edu.minimarket.domain;

import javax.persistence.Embeddable;

@Embeddable
public interface Funcao {
    public String exibirPermissoes();
}
