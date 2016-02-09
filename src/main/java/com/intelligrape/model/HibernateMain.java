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

//        ? is a parameter ? is a place holder where parameter needs to go and the ? parameter will be replace
        //by some value
        Query query = session.createQuery("from User where id > ? and userName = ?");
        query.setInteger(0,5);
        query.setString(1,"Madhav10");
        // it take 2 parameter 1st is the position where to replace ? and 2nd is the value with which we want to replace value
        List<User> userList = query.list();
        session.getTransaction().commit();
        session.close();
        for (User user : userList)
            System.out.println(user.getUserName());

    }
}
