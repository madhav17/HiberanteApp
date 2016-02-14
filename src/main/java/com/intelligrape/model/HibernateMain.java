package com.intelligrape.model;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.*;

public class HibernateMain {

    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        for (int i = 1; i <= 10; i++) {
            session.save(new User("Madhav" + i));
        }

        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        Query query = session.createQuery("from User where userId = 1");
        query.setCacheable(true);
        List<User> userList = (List<User>) query.list();
        printlList(userList);
        session.close();

        Session session2 = sessionFactory.openSession();
        Query query2 = session2.createQuery("from  User where userId = 1");
        query2.setCacheable(true);
        // we need to make both the queries as setCacheable true
        // w/o query cache it will result in 2 queries
        // with query cache it will not result in a query becoz query is already cached.

        List<User> userList1 = (List<User>) query2.list();
        printlList(userList1);
        session2.close();
    }

    public static void printlList(List<User> userList) {
        for (User user : userList) {
            System.out.println(user.getUserName());
        }
    }
}
