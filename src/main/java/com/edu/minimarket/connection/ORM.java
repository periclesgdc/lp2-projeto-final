package com.edu.minimarket.connection;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edu.minimarket.domain.ClasseBase;


public class ORM <T extends ClasseBase> {

    private Class<T> classeExtendida;
    
    public ORM(Class<T> classeExtendida) {
        this.classeExtendida = classeExtendida;
    }

    public void salvar(T entidade) {
        Fabrica.salvar(entidade);
    }

    public void salvar(T entidade, Boolean fecharTransacao) {
        Fabrica.salvar(entidade, fecharTransacao);
    }

    public void salvar(Collection<T> listaEntidades) {
        listaEntidades.forEach(Fabrica::salvar);
        Fabrica.fecharTransacao();
    }

    public T buscarPorId(Long id) {
        return Fabrica.buscar(this.classeExtendida, id);
    }

    public List<T> buscarTodos() {
        return Fabrica.buscar(this.classeExtendida, List.of());
    }
}
