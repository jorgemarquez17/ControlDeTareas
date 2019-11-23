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
import java.math.BigDecimal;
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
        try{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Date parsedDate = dateFormat.parse(fechaEmision);
        Date date1 = new java.sql.Date(parsedDate.getTime());
        
        Date parsedDate2 = dateFormat.parse(fechaTermino);
        Date date2 = new java.sql.Date(parsedDate2.getTime());
        
        
        flujito.setIdusuarioFlujotarea(objUsuario);
        flujito.setIdreporteFlujotarea(idReporte);
        flujito.setGnombreflujotarea(nombreflujo);
        //flujito.setDcfechacreacion(fechaCreacion);
        flujito.setDcfechaemision(date1);
        flujito.setDcfechatermino(date2);
        flujito.setDcporcentajeavance(porcentajeAvan.ZERO);
        flujito.setBlestadoavance(estadoAvance);
        flujito.setBlvigente(vigente);       
             return ejbRef.ingresarFlujoTarea(flujito);
        }
        catch(Exception e ){
            System.out.println("###############################");
            System.out.println(" ERROR" + e.getMessage());
            return false;
        }
      
    }

    @WebMethod(operationName = "findAllFlujoTarea")
    public List<Flujotarea> findAllFlujoTarea() {
        return ejbRef.findAllFlujoTarea();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "modificarFlujoTarea")
    public boolean modificarFlujoTarea(
            @WebParam(name = "idFlujoTarea") long idFlujoTarea, 
            @WebParam(name = "idUsuario") long idUsuario, 
            @WebParam(name = "idReporte") long idReporte, 
            @WebParam(name = "nombreFlujo") String nombreFlujo,
            @WebParam(name = "fechaEmision") String fechaEmision,
            @WebParam(name = "fechaTermino") String fechaTermino,
            @WebParam(name = "porcentajeAvance") BigDecimal porcentajeAvance, 
            @WebParam(name = "habilitado") short habilitado, 
            @WebParam(name = "vigente") short vigente) {
        Usuario objUsuario = new Usuario();
        List<Usuario> listUsu = new ArrayList<Usuario>();
        Flujotarea objFlujo = new Flujotarea();
        
        objUsuario.setIdusuario(idUsuario);
        for(Usuario us: listUsu){
            objUsuario = us;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            Date parsedDate = dateFormat.parse(fechaEmision);
            Date date1 = new java.sql.Date(parsedDate.getTime());

            Date parsedDate2 = dateFormat.parse(fechaTermino);
            Date date2 = new java.sql.Date(parsedDate2.getTime());
            objFlujo.setIdflujotarea(idFlujoTarea);
            objFlujo.setIdusuarioFlujotarea(objUsuario);
            objFlujo.setIdreporteFlujotarea(idReporte);
            objFlujo.setGnombreflujotarea(nombreFlujo);
            objFlujo.setDcfechaemision(parsedDate);
            objFlujo.setDcfechatermino(parsedDate2);
            objFlujo.setDcporcentajeavance(BigDecimal.ZERO);
            objFlujo.setBlestadoavance(habilitado);
            objFlujo.setBlvigente(vigente);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "EliminarFlujoTarea")
    public boolean EliminarFlujoTarea(@WebParam(name = "idFlujoTarea") Long idFlujoTarea) {
        boolean bandera = false;
        Flujotarea ft = new Flujotarea();
        ft.setIdflujotarea(idFlujoTarea);
        bandera = ejbRef.eliminarFlujoTarea(ft);
        return bandera;
    }
    
}
