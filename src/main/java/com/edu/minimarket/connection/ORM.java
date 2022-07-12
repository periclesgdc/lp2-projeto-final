package com.edu.minimarket.connection;

import com.edu.minimarket.domain.ClasseBase;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class ORM <T extends ClasseBase> {

    protected Class<T> classeExtendida;
    
    public ORM(Class<T> classeExtendida) {
        this.classeExtendida = classeExtendida;
    }

    public void salvar(Collection<T> listaEntidades) {
        listaEntidades.forEach(Fabrica::salvar);
        Fabrica.fecharTransacao();
    }

    public void salvar(T... listaEntidades) {
        Arrays.asList(listaEntidades).forEach(Fabrica::salvar);
        Fabrica.fecharTransacao();
    }

    public T buscarPorId(Long id) {
        return Fabrica.buscar(this.classeExtendida, id);
    }

    public List<T> buscarTodos() {
        return Fabrica.buscar(this.classeExtendida);
    }
}
