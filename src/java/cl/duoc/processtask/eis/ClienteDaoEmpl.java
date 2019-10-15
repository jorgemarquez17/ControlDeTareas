/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.eis;

import cl.duoc.processtask.entity.Cliente;
import java.util.ArrayList;
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
public class ClienteDaoEmpl implements ClienteDao{
    
    @PersistenceContext(unitName = "ProcessTaskPU")//ProcessTaskPU
    EntityManager em;

    @Override
    public void modifyEmpresa(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> findIdEmpresa(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> findIdEmpresa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> deleteEmpresa(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> insertCliente(Cliente cliente) {
        List<Cliente> r_cursor =  new ArrayList<Cliente>();
        StoredProcedureQuery spInsertarCliente= em.createStoredProcedureQuery("INGRESARCLIENTE",Cliente.class);
        spInsertarCliente.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN);
        spInsertarCliente.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        spInsertarCliente.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        spInsertarCliente.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
        spInsertarCliente.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
        spInsertarCliente.registerStoredProcedureParameter(7, Short.class, ParameterMode.IN);
        spInsertarCliente.registerStoredProcedureParameter("C_CLIENTE", void.class, ParameterMode.REF_CURSOR);
        
        spInsertarCliente.setParameter(2, cliente.getIdempresaCliente());
        spInsertarCliente.setParameter(3, cliente.getDgnombre());
        spInsertarCliente.setParameter(4, cliente.getDgapellido());
        spInsertarCliente.setParameter(5, cliente.getDgcontacto());
        spInsertarCliente.setParameter(6, cliente.getDgcorreo());
        spInsertarCliente.setParameter(7, cliente.getBlvigente());
        
        r_cursor = (ArrayList<Cliente>) spInsertarCliente.getResultList();
        
        
        return r_cursor;
    }
    
}
