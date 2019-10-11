/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.processtask.ws;

import cl.duoc.processtask.entity.Empresa;
import cl.duoc.processtask.servicio.EmpresaService;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.Oneway;
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
@WebService(serviceName = "wsEmpresa")
//@WebService(endpointInterface = "cl.duoc.processtask.servicio.EmpresaService")
@Stateless()
public class wsEmpresa {

    @EJB
    private EmpresaService ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")
    private List<Empresa> listEmp;

    @WebMethod(operationName = "registrarEmpresa")
    //@Oneway
    public List<Empresa> registrarEmpresa(@WebParam(name = "rut") String rut, @WebParam(name = "direccion") String Direccion,
            @WebParam(name="nombreEmpresa") String NombreEmpresa,
            @WebParam(name = "contacto") String contacto, @WebParam(name = "correo") String correo,
            @WebParam(name="vigente")Short vigente) {
        Empresa empresa = new Empresa();
        
        try {
            Context jndi = new InitialContext();
            EmpresaService ci = (EmpresaService) jndi.lookup("java:global/ProcessTask/EmpresaServiceImpl!cl.duoc.processtask.servicio.EmpresaService");
           // listEmp = new ArrayList<Empresa>();
            //empresa.setIdempresa(1L);
            empresa.setDgrut(rut);
            empresa.setDgdireccion(Direccion);
            empresa.setDgnombreempresa(NombreEmpresa);
            empresa.setDgcontacto(contacto);
            empresa.setDgcorreo(correo);
            empresa.setBlvigente(vigente);
            
            //ejbRef.registrarEmpresa(empresa);
            listEmp = ejbRef.registrarEmpresa2(empresa);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        //return "Se agrego la empresa correctamente";
        return listEmp;
        //ejbRef.registrarEmpresa(empresa);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "EliminarEmpresa")
    public void EliminarEmpresa(@WebParam(name = "idEmp") long idEmp) {
        Empresa emp2 = new Empresa() ;
        emp2.setIdempresa(idEmp);
        emp2 = ejbRef.buscarEmpresaById(emp2);
        //TODO write your implementation code here:
        ejbRef.eliminarEmpresa(emp2);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Modificar")
    @Oneway
    public void Modificar(@WebParam(name = "idEmpresa") long idEmpresa) {
         Empresa emp2 = new Empresa() ;
        emp2.setIdempresa(idEmpresa);
        emp2 = ejbRef.buscarEmpresaById(emp2);
        emp2.setDgcontacto("cesar burgos");
        ejbRef.modificarEmpresa(emp2);
    }
    
}
