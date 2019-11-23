/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.servicio;

import cl.duoc.processtask.entity.Tipoperfil;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jorge
 */
@Remote
public interface TipoPerfilService {
    
    public List<Tipoperfil> listarallTipoPerfil();
    public List<Tipoperfil> listarbyIdTipoPerfil(Tipoperfil tipoperfil);
    
    
}
