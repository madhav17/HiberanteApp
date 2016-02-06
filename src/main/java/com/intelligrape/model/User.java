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

//    @OneToMany
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    // mappedBy say where you want mapping to happen
    // So,now mapping will take place at vehicle using user reference variable of vehicle entity
    private Set<Vehicle> vehicleSet;



    public Set<Vehicle> getVehicle() {
        return vehicleSet;
    }

    public void setVehicle(Set<Vehicle> vehicleSet) {
        this.vehicleSet = vehicleSet;
    }

    public User(String userName,Set<Vehicle> vehicleSet) {
        this.userName = userName;
        this.vehicleSet = vehicleSet;
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