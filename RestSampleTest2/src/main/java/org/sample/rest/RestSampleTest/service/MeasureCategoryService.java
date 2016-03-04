package org.sample.rest.RestSampleTest.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sample.rest.RestSampleTest.database.DatabaseConnection;
import org.sample.rest.RestSampleTest.model.MeasureCategory;

public class MeasureCategoryService {
	
	 SessionFactory sessionFactory = DatabaseConnection.getSessionFactory();
		
	    

		public  List<MeasureCategory> getAllUsers(){
	        List<MeasureCategory> users = null;
	        Session session = null;
	        
	        try{
	            session = sessionFactory.openSession();
	            session.beginTransaction();
	            users = session.createQuery("from MeasureCategory m").list();
	            session.getTransaction().commit();
	            
	        }catch(Exception ex){
	            if (session != null){
	                session.getTransaction().rollback();
	            }
	        }
	        finally{
	            if (session != null){
	                session.close();
	            }     
	        
	    }
	        
	       return users; 
	    }
		

}
