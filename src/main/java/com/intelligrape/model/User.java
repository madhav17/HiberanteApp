package com.intelligrape.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "user")
public class User {

    @Id // create PK (Surrogate key)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userName;

    @ManyToMany
    // and join column annotation can be defined  here similar to one to many
    //but join column annotation is defined in that class which is creating mapping that is user not the vehicle
    // Now this many to many is doing mapping
    private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();



    public Collection<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Collection<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public User(String userName,Collection<Vehicle> vehicles) {
        this.userName = userName;
        this.vehicles = vehicles;
    }

    public User(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User() {

    }
}




/*
*
* Natural Key - one column has unique and it is required like email ID then it can be PK i.e key a Natural Key. Column which are there for business and assigned as PK is called NK
*
* surrogate key - more than one column can be marked as PK i.e a surrogate key
*
* In current system we do not know any column can marked as unique or we do not have it. In then that case we add a column to act as key
* i.e called as surrogate key
*
* so,if it as NK then it is our duty to provide Value
* and if it is surrogate key then we can ask hibernate to do that becoz it does not matter for us.
*
* */