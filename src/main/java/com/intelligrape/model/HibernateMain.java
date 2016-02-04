package com.intelligrape.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        User user = new User("Madhav");
        session.beginTransaction();
        session.save(user);
        session.save(new User("Priya"));
        session.getTransaction().commit();
        session.close();

    }
}
