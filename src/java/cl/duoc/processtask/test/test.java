/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.processtask.test;

import cl.duoc.processtask.entity.Empresa;
import cl.duoc.processtask.servicio.EmpresaService;
import java.math.BigDecimal;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author jorge
 */

public class test {
    public void  guardar(){
     try {
            Context jndi = new InitialContext();
            EmpresaService ci = (EmpresaService) jndi.lookup("java:global/ProcessTask/EmpresaServiceImpl!cl.duoc.processtask.servicio.EmpresaService");
            //EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProcessTaskPU");
            //EntityManager em = emf.createEntityManager();
            //EntityTransaction tx = em.getTransaction();
           
           
            Empresa empresa = new Empresa();
            empresa.setIdempresa(1L);
            empresa.setDgrut("898956-8");
            empresa.setDgdireccion("Renca");
            empresa.setDgcontacto("Jorge Marquez");
            empresa.setDgcorreo("jmar@mail.com");
            ci.registrarEmpresa(empresa);
            //tx.begin();
            
            ///em.persist(empresa);
            
            //tx.commit();
            
            //em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
