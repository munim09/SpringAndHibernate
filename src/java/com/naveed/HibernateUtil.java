/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author user
 */
public class HibernateUtil {

//    private static final SessionFactory sessionFactory;
//    
//    static {
//        try {
//            // Create the SessionFactory from standard (hibernate.cfg.xml) 
//            // config file.
//            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
//        } catch (Throwable ex) {
//            // Log the exception. 
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//    
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
    private static SessionFactory sessionFactory;
    private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			System.out.println("Hibernate Configuration loaded");

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			System.out.println("Hibernate serviceRegistry created");

			SessionFactory sessionFactory = configuration
					.buildSessionFactory(serviceRegistry);

			return sessionFactory;
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			sessionFactory = buildSessionFactory();
		return sessionFactory;
	}
}
