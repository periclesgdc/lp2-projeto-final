package com.edu.minimarket.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Fabrica {
    SessionFactory sessionFactory;
    Session session;
    Transaction tx;

    public Fabrica() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void abrirConexao() {
        System.out.println("-- Abrindo conexao");
        this.session = this.sessionFactory.openSession();
        this.tx = this.session.beginTransaction();
    }

    public void fecharConexao() {
        System.out.println("-- Fechando conexao");
        this.tx.commit();
        this.session.clear();
        this.session.close();
    }

    public void salvar(Object object) {
        System.out.println("-- Salvando entidade");
        this.session.persist(object);
    }
}
