/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.processtask.servicio;

import cl.duoc.processtask.entity.Empresa;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jorge
 */
@Remote
public interface EmpresaService {
    
    public void registrarEmpresa(Empresa empresa);
    
    public List<Empresa> buscarEmpresaById(Empresa empresa);
    
    public List<Empresa> buscarAllEmpresas();
    
    public List<Empresa> modificarEmpresa(Empresa empresa);
    
    public List<Empresa> eliminarEmpresa(Empresa empresa);

    public List<Empresa> registrarEmpresa2(Empresa empresa);
}
