package com.edu.minimarket.connection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.service.ServiceRegistry;

import com.edu.minimarket.domain.ClasseBase;


public class Fabrica {
    private static Configuration configuration;
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    private static Session session;
    private static Transaction tx;

    public static void prepararConexao() {
        configuration = new Configuration();
        configuration.configure();
        configuration.setSessionFactoryObserver(
            new SessionFactoryObserver() {
                @Override
                public void sessionFactoryCreated(SessionFactory factory) {}
                @Override
                public void sessionFactoryClosed(SessionFactory factory) {
                    ((StandardServiceRegistryImpl) serviceRegistry).destroy();
                }
            }
        );

        serviceRegistry = new StandardServiceRegistryBuilder()
            .applySettings(configuration.getProperties()).build();
        
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static void abrirConexao() {
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();
    }

    public static void fecharConexao() {
        session.close();

        if (Boolean.FALSE.equals(sessionFactory.isClosed())) {
            sessionFactory.close();
        }
    }

    public static void abrirTransacao() {
        if (Objects.isNull(tx) || Boolean.FALSE.equals(tx.isParticipating())) {
            tx = session.beginTransaction();
        }
    }

    public static void fecharTransacao() {
        if (tx.isActive()) {
            tx.commit();
        }
    }

    public static void salvar(ClasseBase object) {
        try {
            abrirTransacao();
            session.persist(object);
        } catch (Exception e) {
            tx.rollback();
        }
    }

    public static <T extends ClasseBase> T buscar(Class<T> entidade, Long id) {
        return (T) session.get(entidade, id);
    }

    public static <T extends ClasseBase> List<T> buscar(Class<T> entidade) {
        Criteria c = session.createCriteria(entidade);
        
        return c.list();
    }

    public static <T extends ClasseBase> List<T> buscar(Class<T> entidade, Criterion... criterios) {
        Criteria c = session.createCriteria(entidade);
        
        if (Objects.nonNull(criterios)) {
            Arrays.asList(criterios).forEach(c::add);
        }
        
        return c.list();
    }

    public static <T extends ClasseBase> List<T> buscar(String querString, Map<String, Object> parameters) {
        Query query = session.createQuery(querString);
        
        parameters.entrySet().forEach(elem -> query.setParameter(elem.getKey(), elem.getValue()));

        List<T> result = query.list();

        return result;
    }
}
