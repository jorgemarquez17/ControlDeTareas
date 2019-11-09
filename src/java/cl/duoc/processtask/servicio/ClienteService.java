/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.servicio;

import cl.duoc.processtask.entity.Cliente;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jorge
 */
@Remote
public interface ClienteService {
    
    public List<Cliente> registrarCliente(Cliente cliente);
    
    public List<Cliente> buscarByIdCliente(Cliente cliente);
    
    public List<Cliente> eliminarCliente(Cliente cliente);
    
    public List<Cliente> modificarCliente(Cliente cliente);
    
    public List<Cliente> buscarAllCliente();
    
}
