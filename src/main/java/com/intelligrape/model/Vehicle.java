package com.intelligrape.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue
    private int vehicleId;
    private String vehicleName;

    public Vehicle(){

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
