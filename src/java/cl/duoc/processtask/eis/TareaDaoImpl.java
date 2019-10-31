/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.eis;

import cl.duoc.processtask.entity.Tarea;
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
public class TareaDaoImpl implements TareaDao{
    
    @PersistenceContext(unitName = "ProcessTaskPU")//ProcessTaskPU
    EntityManager em;

    @Override
    public List<Tarea> insertTarea(Tarea tarea) {
        List<Tarea> r_refcursor = new ArrayList<Tarea>();
        StoredProcedureQuery spInsertTarea = em.createStoredProcedureQuery("INGRESARTAREA",Tarea.class);
        spInsertTarea.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN);
        spInsertTarea.registerStoredProcedureParameter(3, Long.class, ParameterMode.IN);
        spInsertTarea.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        spInsertTarea.registerStoredProcedureParameter(5, Long.class, ParameterMode.IN);        
        spInsertTarea.registerStoredProcedureParameter(6, Date.class, ParameterMode.IN);
        spInsertTarea.registerStoredProcedureParameter(7, Date.class, ParameterMode.IN);
        spInsertTarea.registerStoredProcedureParameter(8, Date.class, ParameterMode.IN);
        spInsertTarea.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
        spInsertTarea.registerStoredProcedureParameter(10, Short.class, ParameterMode.IN);
        spInsertTarea.registerStoredProcedureParameter(11, Short.class, ParameterMode.IN);
        spInsertTarea.registerStoredProcedureParameter(12, Short.class, ParameterMode.IN);
        
        spInsertTarea.registerStoredProcedureParameter("INGRESARTAREA", void.class, ParameterMode.REF_CURSOR);
        
        spInsertTarea.setParameter(2, tarea.getIdflujotareaTarea().getIdflujotarea());
        spInsertTarea.setParameter(3, tarea.getIdresponsabletareaUsuario().getIdusuario());
        spInsertTarea.setParameter(4, tarea.getDgnombretarea());
        spInsertTarea.setParameter(5, tarea.getDcporccompletado());
        spInsertTarea.setParameter(6, tarea.getDcfechacreacion());
        spInsertTarea.setParameter(7, tarea.getDcfechaemision());
        spInsertTarea.setParameter(8, tarea.getDcfechatermino());
        spInsertTarea.setParameter(9, tarea.getDgjustificacion());
        spInsertTarea.setParameter(10, tarea.getBlrechazado());
        spInsertTarea.setParameter(11, tarea.getBlestado());
        spInsertTarea.setParameter(12, tarea.getBlvigente());
        
        r_refcursor = spInsertTarea.getResultList();        
        
        return r_refcursor;
    }

    @Override
    public List<Tarea> updateTarea(Tarea tarea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tarea> deleteTarea(Tarea tarea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tarea> findByIdTarea(Tarea tarea) {
         List<Tarea> r_cursor = new ArrayList<Tarea>();
         
         StoredProcedureQuery spListarTarea = em.createStoredProcedureQuery("P_LISTARTAREA", Tarea.class);
         spListarTarea.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
         spListarTarea.registerStoredProcedureParameter("C_IDTAREA", void.class, ParameterMode.REF_CURSOR);
         
         spListarTarea.setParameter(1, tarea.getIdtarea());
         
         return r_cursor;
    }
    
}
