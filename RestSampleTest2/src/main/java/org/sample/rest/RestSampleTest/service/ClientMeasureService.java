package org.sample.rest.RestSampleTest.service;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sample.rest.RestSampleTest.database.DatabaseConnection;
//import org.sample.rest.RestSampleTest.model.ClientMeasureId;
import org.sample.rest.RestSampleTest.model.ClientMeasure;
import org.sample.rest.RestSampleTest.model.ClientMeasureId;
import org.sample.rest.RestSampleTest.model.UserDetails;






public class ClientMeasureService {
	
     SessionFactory sessionFactory = DatabaseConnection.getSessionFactory();
	
     //to get all users
     public  List<ClientMeasure> getAllUsers(){

    	 List<ClientMeasure> users = null;

    	 Session session = null;

    	 try{
    		 session = sessionFactory.openSession();
    		 session.beginTransaction();

    		 users =  session.createQuery("from ClientMeasure c").list();
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
    
     //single user by primary key
 	public ClientMeasure getUserByID(int id, String subid, int meassk, int popid){
        ClientMeasure user = null;
        Session session = null;
        
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            user = (ClientMeasure) session.createQuery("from ClientMeasure c where c.id.clientId = :ID and c.id.clientSubId = :SUBID and c.id.measSk = :MEAS and c.id.populationIdentifier = :POPID").setParameter("ID",id).setParameter("SUBID", subid).setParameter("MEAS", meassk).setParameter("POPID" , popid).uniqueResult();
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
       return user; 
    }
     
     

 	
 	
 	//add and update user
	public boolean saveUser(ClientMeasure clientmeasure){
        boolean hasErrors = false;
        Session session = null;
        
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            //new
            clientmeasure.setRecordLastUpdateDatetime(new Date());
            //new
           session.saveOrUpdate(clientmeasure);
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
        
       return hasErrors; 
    }
	
	//delete user
	
	public boolean deleteUser(ClientMeasure clientmeasure){
        boolean hasErrors = false;
        Session session = null;
        
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
           session.delete(clientmeasure);
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
        
       return hasErrors; 
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*    public static void main (String[] args){
    	ClientMeasureService clients = new ClientMeasureService();
    	System.out.println(clients.getUserByID(2,"2",63,2));
    }*/


    
    		
    		
	
}
		    		
		    		
    		
    		
    		





