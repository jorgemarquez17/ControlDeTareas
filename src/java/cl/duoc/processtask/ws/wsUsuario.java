/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.ws;

import cl.duoc.processtask.entity.Notificacion;
import cl.duoc.processtask.entity.Tipoperfil;
import cl.duoc.processtask.entity.Tiporol;
import cl.duoc.processtask.entity.Usuario;
import cl.duoc.processtask.servicio.TipoPerfilService;
import cl.duoc.processtask.servicio.TipoRolService;
import cl.duoc.processtask.servicio.UsuarioService;
import java.util.ArrayList;
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
    @EJB
    TipoPerfilService ejbTipoPerfil;
    
    @EJB
    TipoRolService ejbTipoRol;

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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ingresarUsuario")
    public boolean ingresarUsuario(
            @WebParam(name = "idTipoPerfilUsuario") Long idTipoPerfilUsuario, 
            @WebParam(name = "idTipoRolUsuario") Long idTipoRolUsuario, 
            @WebParam(name = "idNotificacionUsuario") Long idNotificacionUsuario,
            @WebParam(name = "userName") String userName, 
            @WebParam(name = "habilitado") Short habilitado, 
            @WebParam(name = "vigente") Short vigente, 
            @WebParam(name = "password") String password) {
        
        boolean bandera=false;
        List<Tipoperfil> listTipoPerfil = new ArrayList<Tipoperfil>();
        List<Tiporol> listTipoRol = new ArrayList<Tiporol>();
        List<Notificacion> listNotificacion = new ArrayList<Notificacion>();
        
        Tipoperfil tp = new Tipoperfil();
        tp.setIdtipoperfil(idTipoPerfilUsuario);
        listTipoPerfil = ejbTipoPerfil.listarbyIdTipoPerfil(tp);
        
        Tiporol tr = new Tiporol();
        tr.setIdtiporol(idTipoRolUsuario);
        listTipoRol = ejbTipoRol.listarTipoRol(tr);
        
        Notificacion noti = new Notificacion();
        noti.setIdnotificacion(idNotificacionUsuario);
        //listNotificacion = ej
        
        
        for(Tiporol tiporol: listTipoRol){
            tr = tiporol;
        }
        
        for(Tipoperfil tipop:listTipoPerfil){
            tp = tipop;
        }
        
//        Usuario usu = new Usuario();
//        usu.setIdtipoperfilUsuario(tp);
//        usu.setIdtiporolUsuario(tr);
//        usu.setIdnotificacionUsuario(idNotificacionUsuario);
//        usu.setDgusername(userName);
//        usu.setDgpassword(password);
//        usu.setBlhabilitado(blhabilitado);
//        usu.setBlvigente(blvigente);
        
        return bandera;
    }
    
}
