/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.processtask.test;

import cl.duoc.processtask.entity.Tiporol;
import cl.duoc.processtask.util.Conection;
import java.math.BigDecimal;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author jorge
 */
public class TestPersistence {
    
    public static void main(String [] args) throws NamingException{
       
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProcessTaskPU2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Tiporol rol = new Tiporol();
//        rol.setIdtiporol(new BigDecimal(1));
        rol.setDgnombretiporol("Gerente");
        rol.setBlvigente('0');
        tx.begin();
   
        em.persist(rol);
        tx.commit();
    
        em.close();
        
    }
    
}
