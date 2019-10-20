/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.ws;

import cl.duoc.processtask.entity.Tarea;
import cl.duoc.processtask.servicio.TareaService;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author jorge
 */
@WebService(serviceName = "wsTarea")
public class wsTarea {
    @EJB
    private TareaService ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "ingresarTarea")
    public List<Tarea> ingresarTarea(@WebParam(name = "idFlujoTarea") Long idFlujoTarea,@WebParam(name="idUsuario") Long idUsuario,
            @WebParam(name = "nombreTarea") String nombreTarea, @WebParam(name = "fechaCreacionT") Date fechaCreacionT,
            @WebParam(name = "fechaEmisionT") Date fechaEmisionT ,@WebParam(name = "fechaTerminoT") Date fechaTerminoT,
            @WebParam(name = "justificacion") String justificacion, @WebParam(name = "rechazado") Short rechazado,
            @WebParam(name = "estado") Short estado, @WebParam( name = "vigente") Short vigente) {
        
        Tarea tarea = new Tarea();
        
        
        return ejbRef.ingresarTarea(tarea);
    }
    
}
