/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.servicio;

import cl.duoc.processtask.entity.Tiporol;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jorge
 */
@Remote
public interface TipoRolService {
    
    public List<Tiporol> listarTipoRol(Tiporol tiporol);
    
    public List<Tiporol> ingresarTipoRol(Tiporol tiporol);
    
    public List<Tiporol> actualizarTipoRol(Tiporol tiporol);
    
    public List<Tiporol> eliminarTipoRol(Tiporol tiporol);
    
    
}
