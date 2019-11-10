/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.servicio;

import cl.duoc.processtask.entity.Flujotarea;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jorge
 */
@Remote
public interface FlujoTareaService {
    
    public boolean ingresarFlujoTarea(Flujotarea flujotarea);
    
    public List<Flujotarea> findAllFlujoTarea();
    
    public boolean modificarFlujoTarea(Flujotarea flujotarea);
    
    public boolean eliminarFlujoTarea(Flujotarea flujotarea);
    
    public List<Flujotarea> findByIdFlujoTarea(Flujotarea flujotarea);
    
}
