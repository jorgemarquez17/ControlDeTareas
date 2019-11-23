/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.ws;

import cl.duoc.processtask.eis.TipoperfilDao;
import cl.duoc.processtask.eis.TiporolDao;
import cl.duoc.processtask.eis.UsuarioDao;
import cl.duoc.processtask.entity.Flujotarea;
import cl.duoc.processtask.entity.Tarea;
import cl.duoc.processtask.entity.Usuario;
import cl.duoc.processtask.servicio.TareaService;
import java.text.SimpleDateFormat;
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
    @EJB
    UsuarioDao ejbUsusarioDao;

    @WebMethod(operationName = "ingresarTarea")
    public boolean ingresarTarea(
            @WebParam(name = "idFlujoTarea") Long idFlujoTarea,
            @WebParam(name="idUsuario") Long idUsuario,
            @WebParam(name = "nombreTarea") String nombreTarea, 
            @WebParam(name = "ccompletado") Long ccompletado,
            @WebParam(name = "fechaEmisionT") String fechaEmisionT,
            @WebParam(name = "fechaTerminoT") String fechaTerminoT,
            @WebParam(name = "justificacion") String justificacion, 
            @WebParam(name = "rechazado") Short rechazado,
            @WebParam(name = "estado") Short estado, 
            @WebParam( name = "vigente") Short vigente) {
        
        Tarea tarea = new Tarea();
        Usuario usuario = new Usuario();
        Flujotarea flujoTarea = new Flujotarea();
        List<Usuario> listUsuario = ejbUsusarioDao.findByIdUsuario(usuario);
        boolean bandera = false;
        
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            Date parsedDate = dateFormat.parse(fechaEmisionT);
            Date parsedDate2 = dateFormat.parse(fechaEmisionT);
            usuario.setIdusuario(idUsuario);
            flujoTarea.setIdflujotarea(idFlujoTarea);
            tarea.setIdflujotareaTarea(flujoTarea);
            tarea.setIdresponsabletareaUsuario(usuario);
            tarea.setDgnombretarea(nombreTarea);
            tarea.setDcporccompletado(ccompletado);
            tarea.setDcfechaemision(parsedDate);
            tarea.setDcfechatermino(parsedDate2);
            tarea.setDgjustificacion(justificacion);
            tarea.setBlrechazado(rechazado);
            tarea.setBlestado(estado);
            tarea.setBlvigente(vigente);
            
            bandera = ejbRef.ingresarTarea(tarea);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return bandera;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listAll")
    public List<Tarea> listAll() {
        //TODO write your implementation code here:
        return ejbRef.listarTareas();
    }

    /**
     * Web service operation
     * @param idTarea
     */
    @WebMethod(operationName = "listarById")
    public List<Tarea> listarById(@WebParam(name = "idTarea") Long idTarea) {
        List<Tarea> listaTarea;
        Tarea  tarea = new Tarea();
        tarea.setIdtarea(idTarea);
        listaTarea= ejbRef.listarTareaById(tarea);
        return listaTarea;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminarTarea")
    public boolean eliminarTarea(@WebParam(name = "idTarea") Long idTarea) {
        //TODO write your implementation code here:
        boolean bandera = false;
        try{        
        Tarea tarea = new Tarea();
        tarea.setIdtarea(idTarea);
        bandera = ejbRef.eliminarTarea(tarea);
        }
        catch(Exception e)
        {
            System.out.println("Error: "+ e.getMessage());
                     
        }
        
        return bandera;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "modificarTarea")
    public boolean modificarTarea(
            @WebParam(name = "idTarea") Long idTarea,
            @WebParam(name = "idflujoTarea") Long idflujoTarea, 
            @WebParam(name = "idUsuario") Long idUsuario,
            @WebParam(name = "nombreTarea") String nombreTarea, 
            @WebParam(name = "ccompletado") Long ccompletado,            
            @WebParam(name = "fechaEmisionT") String fechaEmisionT, 
            @WebParam(name = "fechaTerminoT") String fechaTerminoT,
            @WebParam(name = "justificacion") String justificacion, 
            @WebParam(name = "rechazado") Short rechazado,
            @WebParam(name = "estado") Short estado, 
            @WebParam(name = "vigente") Short vigente) {
        //TODO write your implementation code here:
        
        Tarea tarea = new Tarea();
        Usuario usuario = new Usuario();
        Flujotarea flujoTarea = new Flujotarea();
        boolean bandera = false;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            Date parsedDate = dateFormat.parse(fechaEmisionT);
            Date parsedDate2 = dateFormat.parse(fechaEmisionT);
            tarea.setIdtarea(idTarea);
            usuario.setIdusuario(idUsuario);
            flujoTarea.setIdflujotarea(idflujoTarea);
            tarea.setIdflujotareaTarea(flujoTarea);
            tarea.setIdresponsabletareaUsuario(usuario);
            tarea.setDgnombretarea(nombreTarea);
            tarea.setDcporccompletado(ccompletado);
            tarea.setDcfechaemision(parsedDate);
            tarea.setDcfechatermino(parsedDate2);
            tarea.setDgjustificacion(justificacion);
            tarea.setBlrechazado(rechazado);
            tarea.setBlestado(estado);
            tarea.setBlvigente(vigente);
            
            bandera = ejbRef.modificarTarea(tarea);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return bandera;
    }
    
    
    
    
    
}
