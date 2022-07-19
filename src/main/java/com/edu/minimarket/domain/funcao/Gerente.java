package com.edu.minimarket.domain.funcao;

/** Classe com os métodos da permissão de Gerente do MiniMarket. 
 * @author Davi Carvalho, Pericles Gomes e Larissa Jales
 * @version 1.0 
 * @since Realese 01 da aplicação 
 */

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
