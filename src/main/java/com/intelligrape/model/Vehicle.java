package com.intelligrape.model;

import javax.persistence.*;

@Entity(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue
    private int vehicleId;
    private String vehicleName;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    // after we done with mapped by in user we need to specify JoinColumn in Vehicle
    @JoinColumn(name = "user_id")
    // then hibernate know to follow this mapping not to create new table
    private User user;


    public Vehicle(){

    }

    public Vehicle(String vehicleName,User user) {
        this.vehicleName = vehicleName;
        this.user = user;
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
