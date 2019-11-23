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
    public boolean insertTarea(Tarea tarea) {
        boolean bandera = false;
        short var;
        StoredProcedureQuery spInsertTarea = em.createStoredProcedureQuery("INGRESARTAREA",Tarea.class);
        spInsertTarea.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        spInsertTarea.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN);
        spInsertTarea.registerStoredProcedureParameter(3, Long.class, ParameterMode.IN);
        spInsertTarea.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        spInsertTarea.registerStoredProcedureParameter(5, Long.class, ParameterMode.IN);        
        //spInsertTarea.registerStoredProcedureParameter(6, Date.class, ParameterMode.IN);
        spInsertTarea.registerStoredProcedureParameter(6, Date.class, ParameterMode.IN);
        spInsertTarea.registerStoredProcedureParameter(7, Date.class, ParameterMode.IN);
        spInsertTarea.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
        spInsertTarea.registerStoredProcedureParameter(9, Short.class, ParameterMode.IN);
        spInsertTarea.registerStoredProcedureParameter(10, Short.class, ParameterMode.IN);
        spInsertTarea.registerStoredProcedureParameter(11, Short.class, ParameterMode.IN);
        
        spInsertTarea.registerStoredProcedureParameter("C_TAREA", Short.class, ParameterMode.OUT);
        
        spInsertTarea.setParameter(1, tarea.getIdtarea());
        spInsertTarea.setParameter(2, tarea.getIdflujotareaTarea().getIdflujotarea());
        spInsertTarea.setParameter(3, tarea.getIdresponsabletareaUsuario().getIdusuario());
        spInsertTarea.setParameter(4, tarea.getDgnombretarea());
        spInsertTarea.setParameter(5, tarea.getDcporccompletado());
        //spInsertTarea.setParameter(6, tarea.getDcfechacreacion());
        spInsertTarea.setParameter(6, tarea.getDcfechaemision());
        spInsertTarea.setParameter(7, tarea.getDcfechatermino());
        spInsertTarea.setParameter(8, tarea.getDgjustificacion());
        spInsertTarea.setParameter(9, tarea.getBlrechazado());
        spInsertTarea.setParameter(10, tarea.getBlestado());
        spInsertTarea.setParameter(11, tarea.getBlvigente());
        
        spInsertTarea.execute();
        var = (short) spInsertTarea.getOutputParameterValue("C_TAREA");
        if(var==1) bandera = true;
        return bandera;
    }

    @Override
    public boolean updateTarea(Tarea tarea) {
        boolean bandera = false;
        short var;
        StoredProcedureQuery spUpdateTarea = em.createStoredProcedureQuery("P_ACTUALIZARTAREA",Tarea.class);
        spUpdateTarea.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        spUpdateTarea.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN);
        spUpdateTarea.registerStoredProcedureParameter(3, Long.class, ParameterMode.IN);
        spUpdateTarea.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        spUpdateTarea.registerStoredProcedureParameter(5, Long.class, ParameterMode.IN);        
        //spInsertTarea.registerStoredProcedureParameter(6, Date.class, ParameterMode.IN);
        spUpdateTarea.registerStoredProcedureParameter(6, Date.class, ParameterMode.IN);
        spUpdateTarea.registerStoredProcedureParameter(7, Date.class, ParameterMode.IN);
        spUpdateTarea.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
        spUpdateTarea.registerStoredProcedureParameter(9, Short.class, ParameterMode.IN);
        spUpdateTarea.registerStoredProcedureParameter(10, Short.class, ParameterMode.IN);
        spUpdateTarea.registerStoredProcedureParameter(11, Short.class, ParameterMode.IN);
        
        spUpdateTarea.registerStoredProcedureParameter("C_TAREA", Short.class, ParameterMode.OUT);
        
        
         spUpdateTarea.setParameter(1, tarea.getIdtarea());
        spUpdateTarea.setParameter(2, tarea.getIdflujotareaTarea().getIdflujotarea());
        spUpdateTarea.setParameter(3, tarea.getIdresponsabletareaUsuario().getIdusuario());
        spUpdateTarea.setParameter(4, tarea.getDgnombretarea());
        spUpdateTarea.setParameter(5, tarea.getDcporccompletado());
        //spInsertTarea.setParameter(6, tarea.getDcfechacreacion());
        spUpdateTarea.setParameter(6, tarea.getDcfechaemision());
        spUpdateTarea.setParameter(7, tarea.getDcfechatermino());
        spUpdateTarea.setParameter(8, tarea.getDgjustificacion());
        spUpdateTarea.setParameter(9, tarea.getBlrechazado());
        spUpdateTarea.setParameter(10, tarea.getBlestado());
        spUpdateTarea.setParameter(11, tarea.getBlvigente());
        
        spUpdateTarea.execute();
        var = (short) spUpdateTarea.getOutputParameterValue("C_TAREA");
         if(var==1) bandera = true;
        return bandera;
    }

    @Override
    public boolean deleteTarea(Tarea tarea) {
        boolean bandera = false;
        short var;
        try{
        StoredProcedureQuery spEliminarTaraea = em.createStoredProcedureQuery("P_ELIMINARTAREA",Tarea.class);
        spEliminarTaraea.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        spEliminarTaraea.registerStoredProcedureParameter("C_IDTAREA", Short.class, ParameterMode.OUT);
        
        spEliminarTaraea.setParameter(1, tarea.getIdtarea());
        
        spEliminarTaraea.execute();
        var = (short) spEliminarTaraea.getOutputParameterValue("C_IDTAREA");
        if(var==1) bandera = true;
        }
        catch(Exception e){
            e.printStackTrace();
            bandera = false;
        }
        return bandera;
    }

    @Override
    public List<Tarea> findByIdTarea(Tarea tarea) {
         List<Tarea> r_cursor = new ArrayList<Tarea>();
         
         StoredProcedureQuery spListarTarea = em.createStoredProcedureQuery("P_LISTARTAREA", Tarea.class);
         spListarTarea.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
         spListarTarea.registerStoredProcedureParameter("C_IDTAREA", void.class, ParameterMode.REF_CURSOR);
         
         spListarTarea.setParameter(1, tarea.getIdtarea());
         r_cursor =spListarTarea.getResultList();
         
         return r_cursor;
    }

    @Override
    public List<Tarea> findAllTarea() {
        List<Tarea> r_cursor = new ArrayList<Tarea>();
        StoredProcedureQuery spFindAllTarea = em.createStoredProcedureQuery("P_LISTARTAREAALL",Tarea.class);
        spFindAllTarea.registerStoredProcedureParameter("C_IDTAREA",void.class,ParameterMode.REF_CURSOR);
        r_cursor = spFindAllTarea.getResultList();
        return r_cursor;
    }
    
}
