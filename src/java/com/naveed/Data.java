/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed;

import com.hibernate.entity.Members;
import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
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
    
}
