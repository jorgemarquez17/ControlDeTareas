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
        StoredProcedureQuery spInsertarEmpresa= em.createNamedStoredProcedureQuery("INGRESAREMPRESA");
//        spInsertarEmpresa.registerStoredProcedureParameter("dgrut", String.class , ParameterMode.IN);
//        spInsertarEmpresa.registerStoredProcedureParameter("dgdirreccion", String.class, ParameterMode.IN);
//        spInsertarEmpresa.registerStoredProcedureParameter("dgnombreempresa", String.class, ParameterMode.IN);
//        spInsertarEmpresa.registerStoredProcedureParameter("dgcontacto", String.class, ParameterMode.IN);
//        spInsertarEmpresa.registerStoredProcedureParameter("dgcorreo", String.class, ParameterMode.IN);
//        spInsertarEmpresa.registerStoredProcedureParameter("dgvigente", Integer.class, ParameterMode.IN);
        
        spInsertarEmpresa.setParameter("DGRUT", empresa.getDgrut());
        spInsertarEmpresa.setParameter("DGDIRECCION", empresa.getDgdireccion());
        spInsertarEmpresa.setParameter("DGNOMBREEMPRESA", empresa.getDgnombreempresa());
        spInsertarEmpresa.setParameter("DGCONTACTO", empresa.getDgcontacto());
        spInsertarEmpresa.setParameter("DGCORREO", empresa.getDgcorreo());
        spInsertarEmpresa.setParameter("BLVIGENTE", empresa.getBlvigente());
        
        boolean bandera =spInsertarEmpresa.execute();
        if(bandera)System.out.println("Insertado Correctamente");
        
    }
    
    
}
