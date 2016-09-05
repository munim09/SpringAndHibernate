/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author user
 */
@Entity
public class FourWheeler extends Vehicle{
    private String steeringWheel;

    /**
     * @return the SteeringWheel
     */
    public String getSteeringWheel() {
        return steeringWheel;
    }

    /**
     * @param SteeringWheel the SteeringWheel to set
     */
    public void setSteeringWheel(String SteeringWheel) {
        this.steeringWheel = SteeringWheel;
    }
    
}
