/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.ws;

import cl.duoc.processtask.entity.Flujotarea;
import cl.duoc.processtask.entity.Usuario;
import cl.duoc.processtask.servicio.FlujoTareaService;
import cl.duoc.processtask.servicio.UsuarioService;
import com.oracle.jrockit.jfr.FlightRecorder;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
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
@WebService(serviceName = "wsFlujoTarea")
public class wsFlujoTarea {
    @EJB
     FlujoTareaService ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")
    @EJB
    UsuarioService ejbUsuario;

    @WebMethod(operationName = "ingresarFlujoTarea")
    public boolean ingresarFlujoTarea(@WebParam(name = "idUsuario") Long idUsuario,
            @WebParam(name = "idReporte")Long idReporte ,@WebParam(name="nombreFlujo") String nombreflujo,
            @WebParam(name="fechaEmision")String fechaEmision,@WebParam(name="fechaTermino")String fechaTermino,
            @WebParam(name="porcentajeAvan")BigDecimal porcentajeAvan,@WebParam(name="estadoAvance") Short estadoAvance, 
            @WebParam(name="vigente") Short vigente) throws ParseException {
        
        
        Usuario objUsuario = new Usuario();
        objUsuario.setIdusuario(idUsuario);
        List<Usuario> listUsu = ejbUsuario.listarUsuario(objUsuario); 
        
        Flujotarea flujito = new Flujotarea();
        
        for(Usuario u : listUsu){
            objUsuario = u;
        }
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date parsedDate = dateFormat.parse(fechaEmision);
        Timestamp timestamp1 = new java.sql.Timestamp(parsedDate.getTime());
        
        Date parsedDate2 = dateFormat.parse(fechaTermino);
        Timestamp timestamp2 = new java.sql.Timestamp(parsedDate2.getTime());
        
        
        flujito.setIdusuarioFlujotarea(objUsuario);
        flujito.setIdreporteFlujotarea(idReporte);
        flujito.setGnombreflujotarea(nombreflujo);
        //flujito.setDcfechacreacion(fechaCreacion);
        flujito.setDcfechaemision(timestamp1);
        flujito.setDcfechatermino(timestamp2);
        flujito.setDcporcentajeavance(porcentajeAvan.ZERO);
        flujito.setBlestadoavance(estadoAvance);
        flujito.setBlvigente(vigente);
        
        
        return ejbRef.ingresarFlujoTarea(flujito);
    }

    @WebMethod(operationName = "findAllFlujoTarea")
    public List<Flujotarea> findAllFlujoTarea() {
        return ejbRef.findAllFlujoTarea();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "modificarFlujoTarea")
    public boolean modificarFlujoTarea(@WebParam(name = "idFlujoTarea") long idFlujoTarea, 
            @WebParam(name = "idUsuario") long idUsuario, @WebParam(name = "idReporte") long idReporte, 
            @WebParam(name = "nombreFlujo") String nombreFlujo,
            @WebParam(name = "fechaCreacion") Date fechaCreacion, 
            @WebParam(name = "fechaEmision") Date fechaEmision, @WebParam(name = "fechaTermino") Date fechaTermino,
            @WebParam(name = "porcentajeAvance") BigDecimal porcentajeAvance, 
            @WebParam(name = "habilitado") short habilitado, @WebParam(name = "vigente") short vigente) {
        //TODO write your implementation code here:
        Usuario objUsuario = new Usuario();
        List<Usuario> listUsu = new ArrayList<Usuario>();
        Flujotarea objFlujo = new Flujotarea();
        
        objUsuario.setIdusuario(idUsuario);
        for(Usuario us: listUsu){
            objUsuario = us;
        }
        objFlujo.setIdusuarioFlujotarea(objUsuario);
        objFlujo.setIdreporteFlujotarea(idReporte);
        objFlujo.setGnombreflujotarea(nombreFlujo);
        objFlujo.setDcfechacreacion(fechaCreacion);
        objFlujo.setDcfechaemision(fechaEmision);
        objFlujo.setDcfechatermino(fechaTermino);
        objFlujo.setDcporcentajeavance(BigDecimal.ZERO);
        objFlujo.setBlestadoavance(habilitado);
        objFlujo.setBlvigente(vigente);
        
        
        return ejbRef.modificarFlujoTarea(objFlujo);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "buscarByIdFlujoTarea")
    public List<Flujotarea> buscarByIdFlujoTarea(@WebParam(name = "idFlujoTarea") long idFlujoTarea) {
        List<Flujotarea> listaFlujo ;
        Flujotarea flu = new Flujotarea();
        
        flu.setIdflujotarea(idFlujoTarea);
        listaFlujo = ejbRef.findByIdFlujoTarea(flu);
        return listaFlujo;
    }
    
}
