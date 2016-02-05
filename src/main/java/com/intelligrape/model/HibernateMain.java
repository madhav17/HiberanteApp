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
        Vehicle vehicle = new Vehicle("Baleno");
        Vehicle vehicle1 = new Vehicle("Ignis");
        vehicles.add(vehicle);
        vehicles.add(vehicle1);
        User user = new User("Madhav",vehicles);
        session.beginTransaction();
        session.save(vehicle);
        session.save(vehicle1);
        session.save(user);
        session.getTransaction().commit();
        session.close();




    }
}
