/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.servicio;

import cl.duoc.processtask.entity.Empresa;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author jorge
 */
@WebService
public interface EmpresaServiceWS {
    
    @WebMethod
    public void registrarEmpresa(Empresa empresa);
    
}
