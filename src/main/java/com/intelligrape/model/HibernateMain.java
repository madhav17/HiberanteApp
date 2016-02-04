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
        Address address1 = new Address("Company","Company","Company");
        User user = new User("Madhav",address);
        Company company = new Company("Intelligrape",address);
        session.beginTransaction();
        session.save(user);
        session.save(company);
        session.getTransaction().commit();
        session.close();

    }
}
