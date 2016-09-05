/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.entity;

import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 *
 * @author user
 */

@Entity
@Table(name="user_details")
public class UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;
    private String userName;
    
    
//    @ManyToOne
//    private Vehicle vehicle;
    
//    @OneToMany(mappedBy = "userDetails")
//    private Collection<Vehicle> vehicle;
    
    @OneToMany(cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    private Collection<Vehicle> vehicle=new ArrayList<>();

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

   
    public String getUserName() {
        return userName;
    }

    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Collection<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Collection<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

//    public Vehicle getVehicle() {
//        return vehicle;
//    }
//
//    public void setVehicle(Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }

 
    
}
