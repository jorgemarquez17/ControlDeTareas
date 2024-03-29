/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.eis;

import cl.duoc.processtask.entity.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author jorge
 */
@Stateless
public class UsuarioDaoImpl implements UsuarioDao{
    
    @PersistenceContext(unitName = "ProcessTaskPU")//ProcessTaskPU
    EntityManager em;

    @Override
    public List<Usuario> insertUsuario(Usuario usuario) {
        List<Usuario> ref_cursor = new ArrayList<Usuario>();
        StoredProcedureQuery spInsertarUsuario= em.createStoredProcedureQuery("INGRESARUSUARIO",Usuario.class);
        
        spInsertarUsuario.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN);
        spInsertarUsuario.registerStoredProcedureParameter(3, Long.class, ParameterMode.IN);        
        spInsertarUsuario.registerStoredProcedureParameter(4, Long.class, ParameterMode.IN);
        spInsertarUsuario.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
        spInsertarUsuario.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
        spInsertarUsuario.registerStoredProcedureParameter(7, Date.class, ParameterMode.IN);
        spInsertarUsuario.registerStoredProcedureParameter(8, Short.class, ParameterMode.IN);
        spInsertarUsuario.registerStoredProcedureParameter(9, Short.class, ParameterMode.IN);
        spInsertarUsuario.registerStoredProcedureParameter("c_usuario", void.class, ParameterMode.REF_CURSOR);

        
        spInsertarUsuario.setParameter(2, usuario.getIdtipoperfilUsuario());
        spInsertarUsuario.setParameter(3, usuario.getIdtiporolUsuario());
        spInsertarUsuario.setParameter(4, usuario.getIdnotificacionUsuario());
        spInsertarUsuario.setParameter(5, usuario.getDgusername());
        spInsertarUsuario.setParameter(6, usuario.getDgpassword());
        spInsertarUsuario.setParameter(7, usuario.getDcfechacreacion());
        spInsertarUsuario.setParameter(8, usuario.getBlhabilitado());
        spInsertarUsuario.setParameter(9, usuario.getBlvigente());
        
        ref_cursor = spInsertarUsuario.getResultList();
                

        return ref_cursor;
    }

    @Override
    public List<Usuario> deleteUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public List<Usuario> updateUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public List<Usuario> findAllUsuario(Usuario usuario) {
        List<Usuario> r_cursor = new ArrayList<Usuario>();
        StoredProcedureQuery spListUsuario = em.createStoredProcedureQuery("P_LISTARUSUARIO",Usuario.class);
        spListUsuario.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        spListUsuario.registerStoredProcedureParameter("c_usuario", void.class, ParameterMode.REF_CURSOR);
        
        spListUsuario.setParameter(1, usuario.getIdusuario());
        
        r_cursor = spListUsuario.getResultList();
        
        return r_cursor;
    }
    
}
