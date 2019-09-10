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
import javax.persistence.PersistenceContext;

/**
 *
 * @author jorge
 */
@Stateless
public class EmpresaDaoImpl implements EmpresaDao{

    @PersistenceContext(unitName = "ProcessTaskPU")
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
        em.remove(empresa);
    }
    
    
}
