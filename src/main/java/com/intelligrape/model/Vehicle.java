package com.intelligrape.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue
    private int vehicleId;
    private String vehicleName;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Vehicle(){

    }

    public Vehicle(String vehicleName,User user) {
        this.vehicleName = vehicleName;
        this.user = user;
    }

    public Vehicle(String vehicleName) {
        this.vehicleName = vehicleName;
    }


    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}
