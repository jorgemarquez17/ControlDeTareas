/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.eis;

import cl.duoc.processtask.entity.Tipoperfil;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceUnit;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author jorge
 */
@Stateless
public class TipoperfilDaoImpl implements TipoperfilDao{
    
    @PersistenceUnit( unitName = "ProcessTaskPU")
    EntityManager em;

    @Override
    public List<Tipoperfil> findAllTipoperfil() {
        return em.createNamedQuery("Tipoperfil.findAll").getResultList();
    }

    @Override
    public List<Tipoperfil> findByIdTipoPerfil(Tipoperfil tipoperfil) {
        List<Tipoperfil> r_cursor = new ArrayList<Tipoperfil>();
        StoredProcedureQuery spListarByIdTP = em.createStoredProcedureQuery("P_LISTARTIPOPERFILALL",Tipoperfil.class);
        spListarByIdTP.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        spListarByIdTP.registerStoredProcedureParameter("C_TIPOPERFIL", void.class, ParameterMode.REF_CURSOR);
        
        spListarByIdTP.setParameter(1, tipoperfil.getIdtipoperfil());
        r_cursor = spListarByIdTP.getResultList();
        return r_cursor;
    }
    
    
}
