/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed;

import com.hibernate.entity.FourWheeler;
import com.hibernate.entity.Members;
import com.hibernate.entity.TwoWheeler;
import com.hibernate.entity.UserDetails;
import com.hibernate.entity.Vehicle;
import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author user
 */
@ManagedBean
@SessionScoped
public class Data {
    private Members m;
    private HibernateUtil helper;
    private Session session;
    
    public void addMember(){
        m=new Members("steve3");
        session=helper.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(m);
        session.getTransaction().commit();
        session.close();
    }
    
    public void viewMember(){
        String sql="select * from members";
        session=helper.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            SQLQuery query=session.createSQLQuery(sql);
            //query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            query.addEntity(Members.class);
            List list=query.list();

//            for(Object ob: list){
//                Map row=(Map)ob;
//                System.out.println("id: "+row.get("id"));
//                System.out.println("name: "+row.get("name"));
//            }
            
             for (Iterator iterator = list.iterator(); iterator.hasNext();){
                Members members = (Members) iterator.next(); 
                System.out.print("id: " + members.getId()); 
                System.out.print("Name: " + members.getName()); 
             }
             
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }finally {
           session.close(); 
        }
    }
    
    public void addUser(){
        UserDetails userDetails =new UserDetails();
        userDetails.setUserName("munim");
        Vehicle vehicle1=new Vehicle();
        vehicle1.setVehicleName("first");
        Vehicle vehicle2=new Vehicle();
        vehicle2.setVehicleName("seconde");
        userDetails.getVehicle().add(vehicle1);
        userDetails.getVehicle().add(vehicle2);
        session=helper.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.getTransaction().commit();
        session.close();
    }
    
    public void addWheeler(){
        
        Vehicle vehicle1=new Vehicle();
        vehicle1.setVehicleName("first");
        
        TwoWheeler twoWheeler=new TwoWheeler();
        twoWheeler.setVehicleName("Bike");
        twoWheeler.setSteeringHandle("Bike steering handle");
        
        FourWheeler fourWheeler=new FourWheeler();
        fourWheeler.setVehicleName("Porsche");
        fourWheeler.setSteeringWheel("Porsche steering wheel");
        
        session=helper.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(vehicle1);
        session.save(twoWheeler);
        session.save(fourWheeler);
        session.getTransaction().commit();
        session.close();
    }
    
    public void viewUser(){
        session=helper.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("from UserDetails where userid >= 5");
        List users=query.list();
        session.getTransaction().commit();
        session.close();
        System.out.println("size of list "+users.size());
    }
    
}
