/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jpa;

import com.example.jpa.Users;
import com.example.jpa.Questions;
import com.example.jpa.Answers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.EntityExistsException;

public class JpaDatabaseApp {

    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/aps/Users.odb");
				EntityManager em = emf.createEntityManager();
		try{
				
			//	System.out.println("Welcome to hELL");	
				em.getTransaction().begin();
				Users u1=new Users(1, "fishygut", "password");
				Users u2= new Users(2, "puffstone", "qwerty");
				Users u3= new Users(3, "barkingcustard", "welcome");
				
				em.persist(u1);
				em.persist(u2);
				em.persist(u3);
				
				Questions q1= new Questions(1,u1, "What are the main differences between Java EE 7 and Java EE 6 ?");
				Questions q2= new Questions(2,u3, "Where can I find code examples for Java 7 EE Tutorial?");
				em.persist(q1);
				em.persist(q2);
				
				
				Answers a1=new Answers(1,u2,q2,"Support for JSON");
				Answers a2=new Answers(2,u2,q1,"Improved Bean Validation");
				Answers a3= new Answers(3,u2,q2,"https://java.net/projects/javaeetutorial/sources/svn/show/trunk/examples");
		
				Answers a4=new Answers(4,u3,q1,"GlassFish v4");
				Answers a5=new Answers(5,u3,q1,"WebSocket support");
				Answers a6= new Answers(6,u3,q2,"Thanks!");
				
				em.persist(a1);
				em.persist(a2);
				em.persist(a3);
				em.persist(a4);
				em.persist(a5);
				em.persist(a6);
				
				
			//	em.persist(object);
				em.getTransaction().commit();
				em.close();
            } 
			catch (EntityExistsException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } 
				
    }   
}
	