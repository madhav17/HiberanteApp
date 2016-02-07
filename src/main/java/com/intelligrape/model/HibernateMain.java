package com.intelligrape.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class HibernateMain {

    public static void main(String[] args) {

        User user = new User("Maddy");
        //1 initialize the object

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(user);

        user.setUserName("Madhav");
        user.setUserName("Priya");
        //2 pass the object to session
        /*
        * so, when we do not save the object then the object will be transient object
        * if we save the object then it will be persistent object
        * when object is persistent then hibernate track the object and save it
        *
        *
        * user will not be saved if session.save() is not called i.e. it is not passed to hibernate and if it is called
        * then it will save it.
        *
        * */


        /*
        *
        * So, when we update the user after the save and not calling save again then first it will insert the user and update the user
        *
        * why
        * Once we pass an entity object to session.save then any change we make to that object will result in update statement
        * to the DB till the time transaction is not committed
        *
        * if we update the user after the transaction is committed then it will not update the user
        *
        *
        * Let suppose we have 2 updates then it will call only one update and last value will be retain
        *
        * How
        *
        * Not every change will  trigger's a query. Hibernate detect what changes need to go to DB.
        * It figure out the least number of  change is required.
        *
        *
        *
        * So difference b/w transient and Persistent Object
        *
        * Before an object handed to hibernate it is an transient object and hibernate will not track any of it
        * changes.
        *
        * But after an object is handed to hibernate it is an persistent object and hibernate will track any of
        * its change till the transaction is not completed. then is it duty of hibernate that object state will
        * be equal to DB state.
        *
        * Once, we do session.close() it becomes the detached object. It is similar to transient object in the sense
        * that hibernate will not track any changes. Detach object means that the object was tracked by hibernate and
        * persist by hibernate before. But now session is closed it is no longer track by hibernate now it is in
          * detached state
        *
        *
        *
        * */
        session.getTransaction().commit();
        user.setUserName("Update when transaction is committed");
        session.close();

    }
}
