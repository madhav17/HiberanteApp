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
        User user = new User("Madhav");
        vehicles.add(new Vehicle("Baleno",user));
        vehicles.add(new Vehicle("Ignis",user));
        session.beginTransaction();
        user.setVehicle(vehicles);
        session.save(user);
        session.getTransaction().commit();
        session.close();




    }
}
