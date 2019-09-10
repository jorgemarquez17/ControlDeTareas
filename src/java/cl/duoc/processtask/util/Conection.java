/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.processtask.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author jorge
 */
public class Conection {
    
    private EntityManagerFactory emf;
    private EntityManager em ;
    private EntityTransaction tx;

    public Conection() {
    }
    
    public EntityManager getEntityMamager() {
       emf = Persistence.createEntityManagerFactory("ProcessTaskPU2");
       em = emf.createEntityManager();
        return em;
    }
    public EntityTransaction getTransaction(){
         tx =  getEntityMamager().getTransaction();
        return tx;
    }  
    
}
