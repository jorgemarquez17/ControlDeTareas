/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.eis;

import cl.duoc.processtask.entity.Usuario;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface UsuarioDao {
    
    public List<Usuario> insertUsuario(Usuario usuario);
    public List<Usuario> deleteUsuario(Usuario usuario);
    public List<Usuario> updateUsuario(Usuario usuario);
    public List<Usuario> findByIdUsuario(Usuario usuario);
    public List<Usuario> findAllUsuarios();
}
