/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.eis;

import cl.duoc.processtask.entity.Cliente;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface ClienteDao {
    
    public List<Cliente> findIdCliente(Cliente cliente);
    
    public List<Cliente> deleteCliente(Cliente cliente);
    
    public List<Cliente> insertCliente(Cliente cliente);
    
    public List<Cliente> updateCliente(Cliente cliente);
    
    public List<Cliente> findAllCliente();
}
