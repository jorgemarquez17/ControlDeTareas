/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.eis;

import cl.duoc.processtask.entity.Tarea;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface TareaDao {
    
    public boolean insertTarea(Tarea tarea);
    
    public boolean updateTarea(Tarea tarea);
    
    public boolean deleteTarea(Tarea tarea);
    
    public List<Tarea> findByIdTarea(Tarea tarea);
    
    public List<Tarea> findAllTarea();
}
