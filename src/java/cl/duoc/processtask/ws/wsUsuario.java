/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.ws;

import cl.duoc.processtask.entity.Usuario;
import cl.duoc.processtask.servicio.UsuarioService;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author jorge
 */
@WebService(serviceName = "wsUsuario")
public class wsUsuario {
    @EJB
    private UsuarioService ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "ingresarUsuario")
    public List<Usuario> ingresarUsuario(@WebParam(name = "usuario") Long idUsuario) {
        return null;
    }

    @WebMethod(operationName = "actualizarUsuario")
    public List<Usuario> actualizarUsuario(@WebParam(name = "usuario") Long idUsuario) {
        return null;
    }

    @WebMethod(operationName = "eliminarUsuario")
    public List<Usuario> eliminarUsuario(@WebParam(name = "usuario") Long idUsuario) {
        return null;
    }

    @WebMethod(operationName = "listarUsuario")
    public List<Usuario> listarUsuario(@WebParam(name = "usuario") Long idUsuario) {
        Usuario u = new Usuario();
        u.setIdusuario(idUsuario);
        return ejbRef.listarUsuario(u);
    }
    
    @WebMethod(operationName = "listarAllUsuario")
    public List<Usuario> listarAllUsuario() {
        return ejbRef.listarAllUsuarios();
    }
    
}
