/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.servicio;

import cl.duoc.processtask.entity.Usuario;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jorge
 */
@Remote
public interface UsuarioService {
    
    public List<Usuario> ingresarUsuario(Usuario usuario);
    
    public List<Usuario> actualizarUsuario(Usuario usuario);
    
    public List<Usuario> eliminarUsuario(Usuario usuario);
    
    public List<Usuario> listarUsuario(Usuario usuario);
    
    public List<Usuario> listarAllUsuarios();
    
}
