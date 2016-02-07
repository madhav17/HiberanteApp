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

        Vehicle vehicle = new Vehicle("Car");
        TwoWheeler bike = new TwoWheeler();
        bike.setVehicleName("KTM");
        bike.setSteeringHandle("Duke");

        FourWheeler car = new FourWheeler();
        car.setVehicleName("Maruti");
        car.setSteeringWheel("Baleno");

        session.save(vehicle);
        session.save(bike);
        session.save(car);

        session.getTransaction().commit();
        session.close();

        /*
        *
        * So,we have a vehicle table it created only vehicle table
        *
        * 1 It save vehicle name and id and created column DTYPE
        * 2 It also inserting steering handle and wheel and not created other tables
        * 3 instead it mapped everything to the vehicle
        * 4 vehicle has steering handle and wheel
        * 5 but they are not defined in sub class
        * 6 so hibernate by default implement a strategy called single table for inheritance
        * 7 so it create single table for all sub classes
        *
        * */


    }
}
