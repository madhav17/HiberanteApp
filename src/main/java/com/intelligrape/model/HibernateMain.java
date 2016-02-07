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
        user.getVehicle().add(new Vehicle("Baleno"));
        user.getVehicle().add(new Vehicle("Ignis"));
        session.save(user);
        session.getTransaction().commit();
        session.close();


    }
}
