package com.intelligrape.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Address address = new Address("ABC","XYZ","123");
        User user = new User("Madhav");
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }
}
