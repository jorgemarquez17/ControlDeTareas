/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.servicio;

import cl.duoc.processtask.eis.ClienteDao;
import cl.duoc.processtask.eis.EmpresaDao;
import cl.duoc.processtask.entity.Cliente;
import cl.duoc.processtask.entity.Empresa;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jorge
 */
@Stateless
public class ClienteServiceImpl implements ClienteService, ClienteServicesWS{
    
    @EJB
    ClienteDao clienteDao;
    
    @EJB
    EmpresaDao empresaDao;

    @Override
    public boolean registrarCliente(Cliente cliente) {
        return clienteDao.insertCliente(cliente);
    }

    @Override
    public List<Cliente> buscarByIdCliente(Cliente cliente) {
        return clienteDao.findIdCliente(cliente);
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        return clienteDao.deleteCliente(cliente);
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        return clienteDao.updateCliente(cliente);
    }

    @Override
    public List<Cliente> buscarAllCliente() {
        return clienteDao.findAllCliente();
    }
}
