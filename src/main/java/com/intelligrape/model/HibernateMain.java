package com.intelligrape.model;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

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

//        session.createQuery() has 2 method 1st sTring and 2nd Class
        Criteria criteria = session.createCriteria(User.class);
        //criteria has add method that take restrictions
        criteria.add(Restrictions.eq("userName","Madhav10"));
        // to execute it call list()
         List<User> userList =  criteria.list();
//        session.getTransaction().commit();
//        session.close();
        for(User user : userList){
            System.out.println(user.getUserName());
        }


//        Named query(HQL) is hibernate query language. HQL at certain point is not different from SQL
//        as the query grows it is difficult to change and manage.

//        therefore than comes criteria query

    }
}
