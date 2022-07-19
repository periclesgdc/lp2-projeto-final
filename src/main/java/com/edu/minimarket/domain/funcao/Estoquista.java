package com.edu.minimarket.domain.funcao;

/** Classe com os métodos da permissão de Estoquista do MiniMarket. 
 * @author Davi Carvalho, Pericles Gomes e Larissa Jales
 * @version 1.0 
 * @since Realese 01 da aplicação 
 */

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.edu.minimarket.enums.PermissoesEnum;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Estoquista extends Funcao {

    public Estoquista() {
        super(List.of(
            PermissoesEnum.CONSULTAR_PRODUTO,
            PermissoesEnum.INSERIR_PRODUTO,
            PermissoesEnum.REMOVER_PRODUTO
        ));
    }
}
