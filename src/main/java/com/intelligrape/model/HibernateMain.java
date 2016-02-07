package com.intelligrape.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class HibernateMain {

    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(new User("Madhav"));

        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        User user = (User) session.get(User.class, 1);
        session.getTransaction().commit();
        session.close();

        user.setUserName("Maddy");

        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user); // hibernate will update the user by finding the required object
//          user.setUserName("updated Name"); // now hibernate make it persist becoz we give this to hibernate and only run one update query

        session.getTransaction().commit();
        session.close();

        /*
        *
        * Even if we do not update the user after the session is closed and call update() hibernate will update
        * the user then also hibernate will persist the object.
        *
        * it because hibernate does not know what value is changed or not becoz object is coming from other session
        *so for safer side hibernate makes a update query.
        *
        * we can avoid this by telling hibernate to update if user object is changed
        *
        * @org.hibernate.annotations.Entity(selectBeforeUpdate = true) on Entity
        // it means makes a select before update and update if there is any change

            if the object state is same and after we call update() the object will be save automatically
            becoz update() is already called
        * */

    }
}
