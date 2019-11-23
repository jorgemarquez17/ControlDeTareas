/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.servicio;

import cl.duoc.processtask.entity.Tarea;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jorge
 */
@Remote
public interface TareaService {
    
    public boolean ingresarTarea(Tarea tarea);
    
    public List<Tarea> listarTareas();
    
    public List<Tarea> listarTareaById(Tarea tarea);
    
    public boolean modificarTarea(Tarea tarea);
    
    public boolean eliminarTarea(Tarea tarea);
    
}
