package com.intelligrape.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "vehicle")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// we do not have extra column with Null in row as compared to single table
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    /*
    *
    * The problem here is that you mix "table-per-class" inheritance and GenerationType.Auto.
    * Consider an identity column in MsSQL. It is column based.
    * In a "table-per-class" strategy you use one table per class and each one has an ID.
    *
    * */
    private int vehicleId;
    private String vehicleName;


    public Vehicle(){

    }

    public Vehicle(String vehicleName,Collection<User> users) {
        this.vehicleName = vehicleName;
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
