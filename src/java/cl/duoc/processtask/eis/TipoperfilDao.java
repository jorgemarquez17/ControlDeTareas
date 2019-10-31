/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.eis;

import cl.duoc.processtask.entity.Tipoperfil;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface TipoperfilDao {
    
    public List<Tipoperfil> findAllTipoperfil();
    
}
