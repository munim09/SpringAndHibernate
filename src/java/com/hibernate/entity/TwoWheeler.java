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
public class TwoWheeler extends Vehicle{
    private String steeringHandle;

    /**
     * @return the steeringHandle
     */
    public String getSteeringHandle() {
        return steeringHandle;
    }

    /**
     * @param steeringHandle the steeringHandle to set
     */
    public void setSteeringHandle(String steeringHandle) {
        this.steeringHandle = steeringHandle;
    }
}
