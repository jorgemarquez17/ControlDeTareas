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
    public boolean insertCliente(Cliente cliente) {
        boolean bandera = false;
        short var;
        StoredProcedureQuery spInsertarCliente= em.createStoredProcedureQuery("INGRESARCLIENTE",Cliente.class);
        
        spInsertarCliente.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN);
        spInsertarCliente.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        spInsertarCliente.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        spInsertarCliente.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
        spInsertarCliente.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
        spInsertarCliente.registerStoredProcedureParameter(7, Short.class, ParameterMode.IN);
        spInsertarCliente.registerStoredProcedureParameter("C_CLIENTE", Short.class, ParameterMode.OUT);
        
       
        spInsertarCliente.setParameter(2, cliente.getIdempresaCliente().getIdempresa());
        spInsertarCliente.setParameter(3, cliente.getDgnombre());
        spInsertarCliente.setParameter(4, cliente.getDgapellido());
        spInsertarCliente.setParameter(5, cliente.getDgcontacto());
        spInsertarCliente.setParameter(6, cliente.getDgcorreo());
        spInsertarCliente.setParameter(7, cliente.getBlvigente());
        
        //r_cursor = (ArrayList<Cliente>) spInsertarCliente.getResultList();
        spInsertarCliente.execute();
        var = (short) spInsertarCliente.getOutputParameterValue("C_CLIENTE");
        if(var==1){
            bandera = true;
        }        
        return bandera;
    }

    @Override
    public List<Cliente> findIdCliente(Cliente cliente) {
         List<Cliente> r_cursor =  new ArrayList<Cliente>();
         StoredProcedureQuery spfindByIdCliente = em.createStoredProcedureQuery("P_LISTARCLIENTE",Cliente.class);
         spfindByIdCliente.registerStoredProcedureParameter(1, Long.class , ParameterMode.IN);
         spfindByIdCliente.registerStoredProcedureParameter("C_IDCLIENTE", void.class, ParameterMode.REF_CURSOR);
         
         spfindByIdCliente.setParameter(1, cliente.getIdcliente());
         
         r_cursor = spfindByIdCliente.getResultList();
        return r_cursor;
    }

    @Override
    public boolean deleteCliente(Cliente cliente) {
        boolean bandera = false;
        short var;
        StoredProcedureQuery spEliminarCliente = em.createStoredProcedureQuery("P_ELIMINARCLIENTE",Cliente.class);
        spEliminarCliente.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        spEliminarCliente.registerStoredProcedureParameter("C_IDCLIENTE", Short.class, ParameterMode.OUT);
        
        spEliminarCliente.setParameter(1, cliente.getIdcliente());
        
        spEliminarCliente.execute();
        var = (short) spEliminarCliente.getOutputParameterValue("C_IDCLIENTE");
        if(var==1) bandera= true;
        return bandera;
    }

    @Override
    public boolean updateCliente(Cliente cliente) {
        boolean bandera = false;
        short var;
        //List<Cliente> r_cursor = new ArrayList<Cliente>();
        StoredProcedureQuery spActualizarCliente = em.createStoredProcedureQuery("P_ACTUALIZARCLIENTE",Cliente.class);
        spActualizarCliente.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        spActualizarCliente.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN);
        spActualizarCliente.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        spActualizarCliente.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        spActualizarCliente.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
        spActualizarCliente.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
        spActualizarCliente.registerStoredProcedureParameter(7, Short.class, ParameterMode.IN);
        spActualizarCliente.registerStoredProcedureParameter("C_CLIENTE", Short.class, ParameterMode.OUT);
        
        spActualizarCliente.setParameter(1, cliente.getIdcliente());        
        spActualizarCliente.setParameter(2, cliente.getIdempresaCliente().getIdempresa());
        spActualizarCliente.setParameter(3, cliente.getDgnombre());
        spActualizarCliente.setParameter(4, cliente.getDgapellido());
        spActualizarCliente.setParameter(5, cliente.getDgcontacto());
        spActualizarCliente.setParameter(6, cliente.getDgcorreo());
        spActualizarCliente.setParameter(7, cliente.getBlvigente());
        
        //r_cursor = spActualizarCliente.getResultList();    
        spActualizarCliente.execute();
        var = (short) spActualizarCliente.getOutputParameterValue("C_CLIENTE");
        if(var==1) bandera = true;       
        return bandera;
    }

    @Override
    public List<Cliente> findAllCliente() {
        List<Cliente> r_cursor = new ArrayList<Cliente>();
        StoredProcedureQuery spfindAllCliente = em.createStoredProcedureQuery("P_LISTARCLIENTEALL",Cliente.class);
        
        spfindAllCliente.registerStoredProcedureParameter("C_IDCLIENTE", void.class, ParameterMode.REF_CURSOR);        
        r_cursor = spfindAllCliente.getResultList();        
        return r_cursor;
        
    }
    
}
