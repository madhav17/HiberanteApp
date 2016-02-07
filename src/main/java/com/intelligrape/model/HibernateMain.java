package com.intelligrape.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class HibernateMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        User user = new User("Madhav");
        Vehicle v = new Vehicle("Baleno");
        Vehicle v1 = new Vehicle("Ignis");

        user.getVehicles().add(v);
        user.getVehicles().add(v1);

        session.save(v);
        session.save(v1);
        session.save(user);

        session.getTransaction().commit();
        session.close();




    }
}
