package com.intelligrape.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class HibernateMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Address address = new Address("1","XYZ","123");
        Address address1 = new Address("2","XYZ","123");
        Address address2 = new Address("3","XYZ","123");
        List<Address> addresses = new ArrayList<Address>();
        addresses.add(address);
        addresses.add(address1);
        addresses.add(address2);
        User user = new User("Madhav",addresses);
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }
}
