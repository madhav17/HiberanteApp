package com.intelligrape.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class HibernateMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Set<Vehicle> vehicles = new HashSet<Vehicle>();
        vehicles.add(new Vehicle("Baleno"));
        vehicles.add(new Vehicle("Ignis"));
        session.beginTransaction();
        session.save(new User("Madhav",vehicles));
        session.getTransaction().commit();
        session.close();




    }
}
