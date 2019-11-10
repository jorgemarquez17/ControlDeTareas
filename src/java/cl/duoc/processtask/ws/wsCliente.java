/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.ws;

import cl.duoc.processtask.entity.Cliente;
import cl.duoc.processtask.entity.Empresa;
import cl.duoc.processtask.servicio.ClienteService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author jorge
 */
@WebService(serviceName = "wsCliente")
@Stateless
public class wsCliente {
    
    @EJB
    ClienteService ejbRef3;
    
    private List<Cliente> listCli;

    /**
     * Web service operation
     * @param idEmpresa
     * @param nombre
     * @param apellido
     * @param contacto
     * @param correo
     * @param vigente
     * @return 
     */
    @WebMethod(operationName = "ingresarCliente")
    public boolean ingresarCliente(@WebParam(name = "idEmpresa") Long idEmpresa, 
            @WebParam(name = "nombre") String nombre, 
            @WebParam(name = "apellido") String apellido,
            @WebParam(name = "contacto") String contacto, 
            @WebParam(name = "correo") String correo, 
            @WebParam(name = "vigente") Short vigente) {
        //TODO write your implementation code here:
        boolean bandera= false;
        Cliente cliente = new Cliente();
        Empresa empresa = new Empresa();
        List<Empresa> listEmpresa = new ArrayList<Empresa>();
        try{
        Context jndiCliente = new InitialContext();
        ClienteService ci = (ClienteService) jndiCliente.lookup("java:global/ProcessTask/ClienteServiceImpl!cl.duoc.processtask.servicio.ClienteService");
           // listEmp = new ArrayList<Empresa>();
            //empresa.setIdempresa(1L);
            empresa.setIdempresa(idEmpresa);
           
            for(Empresa emp : listEmpresa){
                empresa = emp;
            }
            cliente.setIdempresaCliente(empresa);
            cliente.setDgnombre(nombre);
            cliente.setDgapellido(apellido);
            cliente.setDgcontacto(contacto);
            cliente.setDgcorreo(correo);
            cliente.setBlvigente(vigente);
            
            //ejbRef.registrarEmpresa(empresa);
            bandera = ejbRef3.registrarCliente(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bandera;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listarCliente")
    public List<Cliente> listarCliente(@WebParam(name = "idCliente") long idCliente) {
        //TODO write your implementation code here:
        Cliente cliente = new Cliente();
        List<Cliente> listCliente;
        
        cliente.setIdcliente(idCliente);
        listCliente = ejbRef3.buscarByIdCliente(cliente);
        return listCliente;
    }
    
    
     @WebMethod(operationName = "eliminarCliente")
    public boolean eliminarCliente(@WebParam(name = "idCliente") long idCliente) {
        //TODO write your implementation code here:
        boolean bandera = false;
        Cliente cliente = new Cliente();
        List<Cliente> listCliente;
        cliente.setIdcliente(idCliente);
        
        bandera = ejbRef3.eliminarCliente(cliente);
        return bandera;
    }
    
    @WebMethod(operationName = "actualizarCliente")
    public boolean actualizarCliente(
            @WebParam(name ="idCliente" ) Long idCliente,
            @WebParam(name = "idempresa") Long idEmpresa,
            @WebParam(name = "nombre") String nombre, 
            @WebParam(name = "apellido") String apellido,
            @WebParam(name = "contacto") String contacto, 
            @WebParam(name = "correo") String correo, 
            @WebParam(name = "vigente") Short vigente){
        boolean bandera = false;
        Cliente cliente = new Cliente();
        Empresa empresa = new Empresa();
        List<Empresa> listEmp =new ArrayList<Empresa>();
        try{
           empresa.setIdempresa(idEmpresa);
           
            for(Empresa emp : listEmp){
                empresa = emp;
            }
           // System.out.println("Empresa Rescatada:"+empresa.toString());
            cliente.setIdcliente(idCliente);
            cliente.setIdempresaCliente(empresa);
            cliente.setDgnombre(nombre);
            cliente.setDgapellido(apellido);
            cliente.setDgcontacto(contacto);
            cliente.setDgcorreo(correo);
            cliente.setBlvigente(vigente);
            
            //ejbRef.registrarEmpresa(empresa);
            bandera = ejbRef3.modificarCliente(cliente); 
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return bandera;
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "buscarAllCliente")
    public List<Cliente> buscarAllCliente() {
        //TODO write your implementation code here:
        List<Cliente> listCliente;
        listCliente = ejbRef3.buscarAllCliente();
        return listCliente ;
    }
}
