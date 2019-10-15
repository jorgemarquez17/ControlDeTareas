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
    
    public void modifyEmpresa(Cliente cliente);
    
    public List<Cliente> findIdEmpresa(Cliente cliente);
    
    public List<Cliente> findIdEmpresa();
    
    public List<Cliente> deleteEmpresa(Cliente cliente);
    
    public List<Cliente> insertCliente(Cliente cliente);
}
