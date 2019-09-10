/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.processtask.ws;

import cl.duoc.processtask.entity.Empresa;
import cl.duoc.processtask.servicio.EmpresaService;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author jorge
 */
@WebService(serviceName = "wsEmpresa")
//@WebService(endpointInterface = "cl.duoc.processtask.servicio.EmpresaService")
@Stateless()
public class wsEmpresa {

    @EJB
    private EmpresaService ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "registrarEmpresa")
    //@Oneway
    public void registrarEmpresa(@WebParam(name = "rut") String rut, @WebParam(name = "direccion") String Direccion,
            @WebParam(name = "contacto") String contacto, @WebParam(name = "correo") String correo) {
        Empresa empresa = new Empresa();
        
        try {
            Context jndi = new InitialContext();
            EmpresaService ci = (EmpresaService) jndi.lookup("java:global/ProcessTask/EmpresaServiceImpl!cl.duoc.processtask.servicio.EmpresaService");
            
            empresa.setIdempresa(new BigDecimal(2));
            empresa.setDgrut(rut);
            empresa.setDgdireccion(Direccion);
            empresa.setDgcontacto(contacto);
            empresa.setDgcorreo(correo);
            //ci.registrarEmpresa(empresa);
            ejbRef.registrarEmpresa(empresa);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        //ejbRef.registrarEmpresa(empresa);
    }
    
}
