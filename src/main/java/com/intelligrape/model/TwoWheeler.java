package com.intelligrape.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle {

    /*
    *
    * It inherit the data member and annotation from parent class like @Id, @GeneratedValue
    * */
    private String steeringHandle;

    public String getSteeringHandle() {
        return steeringHandle;
    }

    public void setSteeringHandle(String steeringHandle) {
        this.steeringHandle = steeringHandle;
    }

    public TwoWheeler(){

    }

}
