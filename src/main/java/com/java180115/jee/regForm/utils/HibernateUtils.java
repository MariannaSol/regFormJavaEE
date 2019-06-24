package com.java180115.jee.regForm.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils implements AutoCloseable {
    private SessionFactory sessionFactory;

    private Session session;

    public HibernateUtils() {
        sessionFactory = new Configuration().configure().buildSessionFactory();

    }

    public Session getSession() {
        if (session == null) {
            session = sessionFactory.openSession();
        }

        return session;
    }


    @Override
    public void close() {
        session.close();
        sessionFactory.close();
    }
}