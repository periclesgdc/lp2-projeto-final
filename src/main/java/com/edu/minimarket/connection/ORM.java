package com.edu.minimarket.connection;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edu.minimarket.domain.ClasseBase;

import javassist.expr.Instanceof;


public class ORM <T extends ClasseBase> {

    private Class<T> classeExtendida;
    
    public ORM(Class<T> classeExtendida) {
        this.classeExtendida = classeExtendida;
    }

    public void salvar(T base) {
        Fabrica.salvar(base);
    }

    public void salvar(T base, Boolean fecharTransacao) {
        Fabrica.salvar(base, fecharTransacao);
    }

    public void salvar(Collection<ClasseBase> entityList) {
        Fabrica.abrirTransacao();
        entityList.forEach(Fabrica::salvar);
        Fabrica.fecharTransacao();
    }

    public T buscarPorId(Long id) {
        return Fabrica.buscar(this.classeExtendida, id);
    }
}
