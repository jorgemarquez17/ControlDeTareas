/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.servicio;

import cl.duoc.processtask.eis.TiporolDao;
import cl.duoc.processtask.entity.Tiporol;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jorge
 */
@Stateless
public class TipoRolServiceImpl implements TipoRolService{
    
    @EJB 
    TiporolDao tiporolDao;

    @Override
    public List<Tiporol> listarTipoRol(Tiporol tiporol) {
       return tiporolDao.findByAllTipoRol();
    }

    @Override
    public List<Tiporol> ingresarTipoRol(Tiporol tiporol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tiporol> actualizarTipoRol(Tiporol tiporol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tiporol> eliminarTipoRol(Tiporol tiporol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
