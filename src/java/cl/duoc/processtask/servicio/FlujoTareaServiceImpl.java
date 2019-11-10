/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.servicio;

import cl.duoc.processtask.eis.FlujoTareaDao;
import cl.duoc.processtask.entity.Flujotarea;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jorge
 */
@Stateless
public class FlujoTareaServiceImpl implements FlujoTareaService{
    
    @EJB
    FlujoTareaDao flujotareaDao;

    @Override
    public boolean ingresarFlujoTarea(Flujotarea flujotarea) {
        return flujotareaDao.insertFlujoTarea(flujotarea);
    }

    @Override
    public List<Flujotarea> findAllFlujoTarea() {
        return flujotareaDao.findAllFlujoTarea();
    }

    @Override
    public boolean modificarFlujoTarea(Flujotarea flujotarea) {
        return flujotareaDao.updateFlujoTarea(flujotarea);
    }

    @Override
    public boolean eliminarFlujoTarea(Flujotarea flujotarea) {
        return flujotareaDao.deleteFlujoTarea(flujotarea);
    }

    @Override
    public List<Flujotarea> findByIdFlujoTarea(Flujotarea flujotarea) {
        return flujotareaDao.findIdFlujoTarea(flujotarea);
    }
    
   
    
}
