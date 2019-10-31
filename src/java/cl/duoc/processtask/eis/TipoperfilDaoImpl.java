/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.eis;

import cl.duoc.processtask.entity.Tipoperfil;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

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
    
}
