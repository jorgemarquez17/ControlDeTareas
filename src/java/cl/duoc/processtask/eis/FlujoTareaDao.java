/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.eis;

import cl.duoc.processtask.entity.Flujotarea;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface FlujoTareaDao {
    
    public boolean insertFlujoTarea(Flujotarea flujotarea);
    
    public boolean updateFlujoTarea(Flujotarea flujotarea);
    
    public boolean deleteFlujoTarea(Flujotarea flujotarea);
    
    public List<Flujotarea> findIdFlujoTarea(Flujotarea flujotarea);
    
    public List<Flujotarea> findAllFlujoTarea();
    
}
