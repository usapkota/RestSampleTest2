package org.sample.rest.RestSampleTest.database;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseConnection {
	
	 

	 
	 //original
  
  		private static  SessionFactory sessionFactory;
	    public static SessionFactory getSessionFactory() {
	        if (sessionFactory == null ) {
	            sessionFactory = new Configuration().configure().buildSessionFactory();
	        }
	        return sessionFactory;
	    }
	 
	 
	 
}

