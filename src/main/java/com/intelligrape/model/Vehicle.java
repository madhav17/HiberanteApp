package com.intelligrape.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue
    private int vehicleId;
    private String vehicleName;


    @ManyToMany
    // It should have one mapping table
    // and it has collection at both end with @ManyToMany
    private Collection<User> users = new ArrayList<User>();

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Vehicle(){

    }

    public Vehicle(String vehicleName,Collection<User> users) {
        this.vehicleName = vehicleName;
        this.users = users;
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
