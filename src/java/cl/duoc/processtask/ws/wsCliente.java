/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author jorge
 */
@WebService(serviceName = "wsCliente")
public class wsCliente {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ingresarCliente")
    public String ingresarCliente(@WebParam(name = "idEmpresa") long idEmpresa, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "contacto") String contacto, @WebParam(name = "correo") String correo, @WebParam(name = "vigente") short vigente) {
        //TODO write your implementation code here:
        return null;
    }
}
