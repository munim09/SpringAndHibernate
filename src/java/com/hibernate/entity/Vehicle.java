/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.entity;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name="vehicle")
public class Vehicle {
    @Id @GeneratedValue
    private int vehicleId;
    private String vehicleName;
    
//    @ManyToOne
//   
//    private UserDetails userDetails;
    
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "vehicle")
//    private Collection<UserDetails> userDetails;

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

//    public Collection<UserDetails> getUserDetails() {
//        return userDetails;
//    }
//
//    public void setUserDetails(Collection<UserDetails> userDetails) {
//        this.userDetails = userDetails;
//    }

//    public UserDetails getUserDetails() {
//        return userDetails;
//    }
//
//    public void setUserDetails(UserDetails userDetails) {
//        this.userDetails = userDetails;
//    }

   
    
}
