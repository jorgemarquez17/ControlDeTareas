/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.processtask.eis;

import cl.duoc.processtask.entity.Empresa;
import java.util.ArrayList;
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
public class EmpresaDaoImpl implements EmpresaDao{

    @PersistenceContext(unitName = "ProcessTaskPU")//ProcessTaskPU
    EntityManager em;
    
    @Override
    public void insertEmpresa(Empresa empresa) {
        em.persist(empresa);
    }

    @Override
    public boolean modifyEmpresa(Empresa empresa) {
       //em.merge(empresa);
        boolean bandera ;
        short var;
        StoredProcedureQuery spUpdateEmpresa = em.createStoredProcedureQuery("P_ACTUALIZAREMPRESA",Empresa.class);
        spUpdateEmpresa.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        spUpdateEmpresa.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        spUpdateEmpresa.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        spUpdateEmpresa.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        spUpdateEmpresa.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
        spUpdateEmpresa.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
        spUpdateEmpresa.registerStoredProcedureParameter(7, Short.class, ParameterMode.IN);
        spUpdateEmpresa.registerStoredProcedureParameter("C_EMPRESA", Short.class, ParameterMode.OUT);
        
        spUpdateEmpresa.setParameter(1, empresa.getIdempresa());
        spUpdateEmpresa.setParameter(2, empresa.getDgrut());
        spUpdateEmpresa.setParameter(3, empresa.getDgdireccion());
        spUpdateEmpresa.setParameter(4, empresa.getDgnombreempresa());
        spUpdateEmpresa.setParameter(5, empresa.getDgcontacto());
        spUpdateEmpresa.setParameter(6, empresa.getDgcorreo());
        spUpdateEmpresa.setParameter(7, empresa.getBlvigente());
        
        spUpdateEmpresa.execute();
        var = (short) spUpdateEmpresa.getOutputParameterValue("C_EMPRESA");
        if(var==1){
            bandera = true;
        }
        else{
            bandera = false;
        }        
        return bandera;
    }

    @Override
    public List<Empresa> findIdEmpresa(Empresa empresa) {
        //return em.find(Empresa.class, empresa.getIdempresa());
        List<Empresa> r_cursor =  new ArrayList<Empresa>();
        StoredProcedureQuery spfindByIdEmpresa = em.createStoredProcedureQuery("P_LISTAREMPRESA",Empresa.class);
        spfindByIdEmpresa.registerStoredProcedureParameter(1, Long.class , ParameterMode.IN);
        spfindByIdEmpresa.registerStoredProcedureParameter("C_IDEMPRESA", void.class, ParameterMode.REF_CURSOR);
        
         spfindByIdEmpresa.setParameter(1, empresa.getIdempresa());
         
         //(ArrayList<Empresa>) para castear el resultado
         r_cursor =  spfindByIdEmpresa.getResultList();
        
        return r_cursor;
    }

    @Override
    public List<Empresa> findAllEmpresa() {
        //return em.createNamedQuery("Empresa.findAll").getResultList();
        List<Empresa> r_cursor =  new ArrayList<Empresa>();
         StoredProcedureQuery spfindByIdEmpresa = em.createStoredProcedureQuery("P_LISTAREMPRESAALL",Empresa.class);
         spfindByIdEmpresa.registerStoredProcedureParameter("C_IDEMPRESA", void.class, ParameterMode.REF_CURSOR);
          r_cursor =  spfindByIdEmpresa.getResultList();
          return r_cursor;
    }

    @Override
    public boolean deleteEmpresa(Empresa empresa) {
        boolean bandera;
        short var;
        StoredProcedureQuery spEliminarEmpresa= em.createStoredProcedureQuery("P_ELIMINAREMPRESA",Empresa.class);
        spEliminarEmpresa.registerStoredProcedureParameter(1, Long.class , ParameterMode.IN);
        spEliminarEmpresa.registerStoredProcedureParameter("C_IDEMPRESA", Short.class, ParameterMode.OUT);
        
        spEliminarEmpresa.setParameter(1, empresa.getIdempresa());
        //r_cursor = (ArrayList<Empresa>) spEliminarEmpresa.getResultList();
        spEliminarEmpresa.execute();
        var = (short) spEliminarEmpresa.getOutputParameterValue("C_IDEMPRESA");
        if(var == 1){
            bandera = true;
        }
        else{
            bandera = false;
        }
        return bandera;
    }

    @Override
    //public List<Empresa> insertEmpresa2(Empresa empresa) {
    public boolean insertEmpresa2(Empresa empresa) {
        //List<Empresa> r_cursor =  new ArrayList<Empresa>();
        boolean bandera = false;
        short var ;
        StoredProcedureQuery spInsertarEmpresa= em.createStoredProcedureQuery("INGRESAREMPRESA",Empresa.class);
        spInsertarEmpresa.registerStoredProcedureParameter(2, String.class , ParameterMode.IN);
        spInsertarEmpresa.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        spInsertarEmpresa.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        spInsertarEmpresa.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
        spInsertarEmpresa.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
        spInsertarEmpresa.registerStoredProcedureParameter(7, Short.class, ParameterMode.IN);
        spInsertarEmpresa.registerStoredProcedureParameter("C_EMPRESA", Short.class, ParameterMode.OUT);
        
        spInsertarEmpresa.setParameter(2, empresa.getDgrut());
        spInsertarEmpresa.setParameter(3, empresa.getDgdireccion());
        spInsertarEmpresa.setParameter(4, empresa.getDgnombreempresa());
        spInsertarEmpresa.setParameter(5, empresa.getDgcontacto());
        spInsertarEmpresa.setParameter(6, empresa.getDgcorreo());
        spInsertarEmpresa.setParameter(7, empresa.getBlvigente());
        
        //r_cursor = (ArrayList<Empresa>) spInsertarEmpresa.getResultList();
        spInsertarEmpresa.execute();
        var =  (short) spInsertarEmpresa.getOutputParameterValue("C_EMPRESA");
        if(var == 1) {
            bandera = true;
        }
        else{
            bandera = false;
        }
       return bandera;
       
    }
    
    
}
