/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.servicio;

import cl.duoc.processtask.entity.Cliente;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author jorge
 */
@WebService
public interface ClienteServicesWS {
    
    @WebMethod
    public boolean registrarCliente(Cliente cliente);
    
    @WebMethod
    public List<Cliente> buscarByIdCliente(Cliente cliente);
    
    
    
}
