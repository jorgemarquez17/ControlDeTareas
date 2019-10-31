/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.ws;

import cl.duoc.processtask.eis.TipoperfilDao;
import cl.duoc.processtask.eis.TiporolDao;
import cl.duoc.processtask.entity.Flujotarea;
import cl.duoc.processtask.entity.Tarea;
import cl.duoc.processtask.entity.Tipoperfil;
import cl.duoc.processtask.entity.Tiporol;
import cl.duoc.processtask.entity.Usuario;
import cl.duoc.processtask.servicio.TareaService;
import java.util.ArrayList;
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
    @EJB
    private TiporolDao ejbTiporol;
    @EJB
    private TipoperfilDao ejbTipoPerfil;

    @WebMethod(operationName = "ingresarTarea")
    public List<Tarea> ingresarTarea(@WebParam(name = "idFlujoTarea") Long idFlujoTarea,@WebParam(name="idUsuario") Long idUsuario,
            @WebParam(name = "nombreTarea") String nombreTarea, @WebParam(name = "ccompletado") Long ccompletado,
            @WebParam(name = "fechaCreacionT") Date fechaCreacionT,
            @WebParam(name = "fechaEmisionT") Date fechaEmisionT ,@WebParam(name = "fechaTerminoT") Date fechaTerminoT,
            @WebParam(name = "justificacion") String justificacion, @WebParam(name = "rechazado") Short rechazado,
            @WebParam(name = "estado") Short estado, @WebParam( name = "vigente") Short vigente) {
        
        Tarea tarea = new Tarea();
        Usuario usuario = new Usuario();
        Flujotarea flujoTarea = new Flujotarea();
        List<Tarea> listTarea = new ArrayList<Tarea>();
//        List<Tipoperfil> listTipoPerfil =ejbTipoPerfil.findAllTipoperfil();
//        List<Tiporol> listTipoRol = ejbTiporol.findByAllTipoRol();
        
        try{
//            for(Tiporol trol : listTipoRol){
//                if(trol.getIdtiporol()==id)
//            }
            usuario.setIdusuario(idUsuario);
            flujoTarea.setIdflujotarea(idFlujoTarea);
            tarea.setIdflujotareaTarea(flujoTarea);
            tarea.setIdresponsabletareaUsuario(usuario);
            tarea.setDgnombretarea(nombreTarea);
            tarea.setDcporccompletado(ccompletado);
            tarea.setDcfechacreacion(fechaCreacionT);
            tarea.setDcfechaemision(fechaEmisionT);
            tarea.setDcfechatermino(fechaTerminoT);
            tarea.setDgjustificacion(justificacion);
            tarea.setBlrechazado(rechazado);
            tarea.setBlestado(estado);
            tarea.setBlvigente(vigente);
            
            listTarea = ejbRef.ingresarTarea(tarea);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        //return ejbRef.ingresarTarea(tarea);
        return listTarea;
    }
    
}
