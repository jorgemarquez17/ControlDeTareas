/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.servicio;

import cl.duoc.processtask.eis.ClienteDao;
import cl.duoc.processtask.entity.Cliente;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author jorge
 */
public class ClienteServiceImpl implements ClienteService{
    
    @EJB
    ClienteDao clienteDao;

    @Override
    public List<Cliente> registrarCliente(Cliente cliente) {
        return clienteDao.insertCliente(cliente);
    }

    @Override
    public List<Cliente> buscarByIdCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> eliminarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
