/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.servicio;

import cl.duoc.processtask.eis.TipoperfilDao;
import cl.duoc.processtask.entity.Tipoperfil;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jorge
 */
@Stateless
public class TipoPerfilServiceImpl implements TipoPerfilService{
    
    @EJB
    TipoperfilDao tipoperfilDao;

    @Override
    public List<Tipoperfil> listarallTipoPerfil() {
       return tipoperfilDao.findAllTipoperfil();
    }

    @Override
    public List<Tipoperfil> listarbyIdTipoPerfil(Tipoperfil tipoperfil) {
        return null;
    }
    
}
