package com.edu.minimarket.domain.funcao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Caixa extends Funcao {

    public Caixa() {
        super(List.of(
            PermissoesEnum.ABRIR_PDV,
            PermissoesEnum.CONSULTAR_PRODUTO
        ));
    }

    public void abrirPDV() {

    }

    public String consultarEstoque() {
        return null;
    }
}
