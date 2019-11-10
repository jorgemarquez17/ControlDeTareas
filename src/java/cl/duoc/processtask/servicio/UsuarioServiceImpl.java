/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.servicio;

import cl.duoc.processtask.eis.UsuarioDao;
import cl.duoc.processtask.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jorge
 */
@Stateless
public class UsuarioServiceImpl implements UsuarioService{
    @EJB
    UsuarioDao usuarioDao;

    @Override
    public List<Usuario> ingresarUsuario(Usuario usuario) {
        
        return usuarioDao.insertUsuario(usuario);
    }

    @Override
    public List<Usuario> actualizarUsuario(Usuario usuario) {
        
        return usuarioDao.updateUsuario(usuario);
    }

    @Override
    public List<Usuario> eliminarUsuario(Usuario usuario) {
       
        return usuarioDao.deleteUsuario(usuario);
    }

    @Override
    public List<Usuario> listarUsuario(Usuario usuario) {
        
        return usuarioDao.findByIdUsuario(usuario);
    }

    @Override
    public List<Usuario> listarAllUsuarios() {
        return usuarioDao.findAllUsuarios();
    }
    
}
