/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.servicio;

import cl.duoc.processtask.eis.TareaDao;
import cl.duoc.processtask.entity.Tarea;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jorge
 */
@Stateless
public class TareaServiceImpl implements TareaService{
    
    @EJB
    TareaDao tareaDao;

    @Override
    public boolean ingresarTarea(Tarea tarea) {
        
        return tareaDao.insertTarea(tarea);
    }

    @Override
    public List<Tarea> listarTarea(Tarea tarea) {
        
        return tareaDao.findByIdTarea(tarea);
    }
    
}
