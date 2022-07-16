package com.edu.minimarket.domain.funcao;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Gerente extends Funcao {

    public Gerente() {
        super(Arrays.asList(PermissoesEnum.values()));
    }
}
