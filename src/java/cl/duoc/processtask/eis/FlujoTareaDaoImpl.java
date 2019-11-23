/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.eis;

import cl.duoc.processtask.entity.Flujotarea;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author jorge
 */
@Stateless
public class FlujoTareaDaoImpl implements FlujoTareaDao{
    @PersistenceContext(unitName = "ProcessTaskPU")//ProcessTaskPU
    EntityManager em;

    @Override
    public boolean insertFlujoTarea(Flujotarea flujotarea) {
        boolean bandera = false;
        short var;
         StoredProcedureQuery spInsertFlujoTarea = em.createStoredProcedureQuery("INGRESARFLUJOTAREA",Flujotarea.class);
         spInsertFlujoTarea.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN);
         spInsertFlujoTarea.registerStoredProcedureParameter(3, Long.class, ParameterMode.IN);
         spInsertFlujoTarea.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
         spInsertFlujoTarea.registerStoredProcedureParameter(5, Date.class, ParameterMode.IN);
         spInsertFlujoTarea.registerStoredProcedureParameter(6, Date.class, ParameterMode.IN);
         spInsertFlujoTarea.registerStoredProcedureParameter(7, BigDecimal.class, ParameterMode.IN);
         spInsertFlujoTarea.registerStoredProcedureParameter(8, Short.class, ParameterMode.IN);
         spInsertFlujoTarea.registerStoredProcedureParameter(9, Short.class, ParameterMode.IN);
         spInsertFlujoTarea.registerStoredProcedureParameter("C_FLUJOTAREA", Short.class, ParameterMode.OUT);
         
         spInsertFlujoTarea.setParameter(2, flujotarea.getIdusuarioFlujotarea().getIdusuario());
         spInsertFlujoTarea.setParameter(3, flujotarea.getIdreporteFlujotarea());
         spInsertFlujoTarea.setParameter(4, flujotarea.getGnombreflujotarea());
         spInsertFlujoTarea.setParameter(5, flujotarea.getDcfechaemision());
         spInsertFlujoTarea.setParameter(6, flujotarea.getDcfechatermino());
         spInsertFlujoTarea.setParameter(7, flujotarea.getDcporcentajeavance());
         spInsertFlujoTarea.setParameter(8, flujotarea.getBlestadoavance());
         spInsertFlujoTarea.setParameter(9,flujotarea.getBlvigente());
         
         spInsertFlujoTarea.execute();
         var= (short) spInsertFlujoTarea.getOutputParameterValue("C_FLUJOTAREA");
         if(var==1) bandera = true;
         
         return bandera;         
    }

    @Override
    public boolean updateFlujoTarea(Flujotarea flujotarea) {
        boolean bandera = false;
        short var;
        StoredProcedureQuery spActualizarFlujo = em.createStoredProcedureQuery("P_ACTUALIZARFLUJOTAREA",Flujotarea.class);
        spActualizarFlujo.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        spActualizarFlujo.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN);
        spActualizarFlujo.registerStoredProcedureParameter(3, Long.class, ParameterMode.IN);
        spActualizarFlujo.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        spActualizarFlujo.registerStoredProcedureParameter(5, Date.class, ParameterMode.IN);
        spActualizarFlujo.registerStoredProcedureParameter(6, Date.class, ParameterMode.IN);
        spActualizarFlujo.registerStoredProcedureParameter(7, BigDecimal.class, ParameterMode.IN);
        spActualizarFlujo.registerStoredProcedureParameter(8, Short.class, ParameterMode.IN);
        spActualizarFlujo.registerStoredProcedureParameter(9, Short.class, ParameterMode.IN);
        spActualizarFlujo.registerStoredProcedureParameter("C_FLUJOTAREA", Short.class, ParameterMode.OUT);
        
        spActualizarFlujo.setParameter(1, flujotarea.getIdflujotarea());
        spActualizarFlujo.setParameter(2, flujotarea.getIdusuarioFlujotarea().getIdusuario());
        spActualizarFlujo.setParameter(3, flujotarea.getIdreporteFlujotarea());
        spActualizarFlujo.setParameter(4, flujotarea.getGnombreflujotarea());
        spActualizarFlujo.setParameter(5, flujotarea.getDcfechaemision());
        spActualizarFlujo.setParameter(6, flujotarea.getDcfechatermino());
        spActualizarFlujo.setParameter(7, flujotarea.getDcporcentajeavance());
        spActualizarFlujo.setParameter(8, flujotarea.getBlestadoavance());
        spActualizarFlujo.setParameter(9, flujotarea.getBlvigente());
        
        spActualizarFlujo.execute();
        
        var = (short) spActualizarFlujo.getOutputParameterValue("C_FLUJOTAREA");
        if(var==1) bandera = true;
        
        return bandera;      
    }

    @Override
    public boolean deleteFlujoTarea(Flujotarea flujotarea) {
        boolean bandera = false;
        short var;
        StoredProcedureQuery spEliminarflujo = em.createStoredProcedureQuery("P_ELIMINARFLUJOTAREA",Flujotarea.class);
        spEliminarflujo.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        spEliminarflujo.registerStoredProcedureParameter("C_IDFLUJOTAREA", Short.class, ParameterMode.OUT);
        
        spEliminarflujo.setParameter(1, flujotarea.getIdflujotarea());
        spEliminarflujo.execute();
        var = (short) spEliminarflujo.getOutputParameterValue("C_IDFLUJOTAREA");
        if(var==1) bandera = true;
        return bandera;
    }

    @Override
    public List<Flujotarea> findIdFlujoTarea(Flujotarea flujotarea) {
        List<Flujotarea> r_cursor = new  ArrayList<Flujotarea>();
        StoredProcedureQuery spFindByIdFlujo = em.createStoredProcedureQuery("P_LISTARFLUJOTAREA",Flujotarea.class);
        spFindByIdFlujo.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        spFindByIdFlujo.registerStoredProcedureParameter("C_IDFLUJOTAREA", void.class, ParameterMode.REF_CURSOR);
        
        spFindByIdFlujo.setParameter(1, flujotarea.getIdflujotarea());
        r_cursor = spFindByIdFlujo.getResultList();
        return r_cursor;
    }

    @Override
    public List<Flujotarea> findAllFlujoTarea() {
        List<Flujotarea> r_cursor = new  ArrayList<Flujotarea>();
        StoredProcedureQuery spFindAllFlujo = em.createStoredProcedureQuery("P_LISTARFLUJOTAREAALL",Flujotarea.class);
        spFindAllFlujo.registerStoredProcedureParameter("C_IDFLUJOTAREA", void.class, ParameterMode.REF_CURSOR);
        
        r_cursor = spFindAllFlujo.getResultList();               
          
        return r_cursor;
    }
    
}
