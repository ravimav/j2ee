/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jpa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.Collection;

/**
 *
 * @author Ravi Mav
 */
public class JpaDatabaseApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.example.jpaPU");
        EntityManager em = emf.createEntityManager();
       
         Query q = em.createQuery("SELECT x FROM Questions x ");
       
         Query p = em.createQuery("SELECT a FROM Answers a ");
         
        for(Questions ques : (Collection<Questions>) q.getResultList()){  
            //System.out.println(ques.getUserId().getUsername());
            //Query p = em.createQuery("SELECT a FROM Answers a ");
            int cnt = 0;
            System.out.println("Question from "+ ques.getUserId().getUsername());
            System.out.println();
            System.out.println("Question from "+ ques.getText());
            System.out.println();   
            for(Answers ans : (Collection<Answers>) p.getResultList()){
                if(ques.getId()== ans.getQuestionId().getId()){
                    cnt = cnt + 1;
                }
            }
            
            System.out.println(cnt + " Answers");
            System.out.println();
            for(Answers ans : (Collection<Answers>) p.getResultList()){
                if(ques.getId()== ans.getQuestionId().getId()){
                    System.out.println(ans.getUserId().getUsername() +": " +ans.getText());
                }
                
            }
            System.out.println("-------------------");
        }
        em.close();
    }
}
