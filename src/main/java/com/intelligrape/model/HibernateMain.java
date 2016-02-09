package com.intelligrape.model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class HibernateMain {

    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        for(int i = 1;i<=10;i++){
            session.save(new User("Madhav" + i));
        }

        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();

        String minId = "5 or 1=1";
//        int minId = 5;
        // so now first condition may true or false but second will always bw true 1=1 and return all data
        // they do anything append ; (semicolon) and writing other query to delete data
        Query query = session.createQuery("from User where id > " + minId );
        List<User> userList = query.list();
        session.getTransaction().commit();
        session.close();
        for (User user : userList)
            System.out.println(user.getUserName());

    }
}
