package com.edu.minimarket.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Fabrica {
    SessionFactory sessionFactory;
    Session session;
    Transaction tx;

    public Fabrica() {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
            .applySettings(configuration.getProperties()).build();
        
        this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
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
