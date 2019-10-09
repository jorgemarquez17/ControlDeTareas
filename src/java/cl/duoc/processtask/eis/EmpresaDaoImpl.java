/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.processtask.eis;

import cl.duoc.processtask.entity.Empresa;
import java.math.BigDecimal;
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
    public void modifyEmpresa(Empresa empresa) {
       em.merge(empresa);
    }

    @Override
    public Empresa findIdEmpresa(Empresa empresa) {
        return em.find(Empresa.class, empresa.getIdempresa());
    }

    @Override
    public List<Empresa> findIdEmpresa() {
        return em.createNamedQuery("Empresa.findAll").getResultList();
    }

    @Override
    public void deleteEmpresa(Empresa empresa) {
        
        Empresa emp = em.merge(empresa);
        
        em.remove(emp);
    }

    @Override
    public void insertEmpresa2(Empresa empresa) {
        StoredProcedureQuery spInsertarEmpresa= em.createStoredProcedureQuery("INGRESAREMPRESA");
        spInsertarEmpresa.registerStoredProcedureParameter(2, String.class , ParameterMode.IN);
        spInsertarEmpresa.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        spInsertarEmpresa.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        spInsertarEmpresa.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
        spInsertarEmpresa.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
        spInsertarEmpresa.registerStoredProcedureParameter(7, Integer.class, ParameterMode.IN);
        
        spInsertarEmpresa.setParameter(2, empresa.getDgrut());
        spInsertarEmpresa.setParameter(3, empresa.getDgdireccion());
        spInsertarEmpresa.setParameter(4, empresa.getDgnombreempresa());
        spInsertarEmpresa.setParameter(5, empresa.getDgcontacto());
        spInsertarEmpresa.setParameter(6, empresa.getDgcorreo());
        spInsertarEmpresa.setParameter(7, empresa.getBlvigente());
        
        spInsertarEmpresa.execute();
       
    }
    
    
}
