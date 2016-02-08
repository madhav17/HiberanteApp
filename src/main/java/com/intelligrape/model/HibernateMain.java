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

//        Query query =  session.createQuery("select userName from User");
        Query query =  session.createQuery("select new list (id,userName) from User");
        //Query query =  session.createQuery("select new map (id,userName) from User");
        query.setFirstResult(5);
        query.setMaxResults(4);
//        List<String> userList = query.list();
        List<List> userList = (List<List>)query.list();
//        List<Map> userList = (List<Map>)query.list();
        session.getTransaction().commit();

        session.close();
//        for (String s : userList){
//            System.out.println(s);
//        }
        for (List l: userList){
            System.out.println(l.get(0));
            System.out.println(l.get(1));
        }
//        for (Map<String,String> map : userList){
//            System.out.println(map);
//        }

    }
}
