/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.processtask.eis;

import cl.duoc.processtask.entity.Empresa;
import java.util.List;
/**
 *
 * @author jorge
 */
public interface EmpresaDao {
    
    public void insertEmpresa(Empresa empresa);
    
    public void modifyEmpresa(Empresa empresa);
    
    public Empresa findIdEmpresa(Empresa empresa);
    
    public List<Empresa> findIdEmpresa();
    
    public void deleteEmpresa(Empresa empresa);
    
    public List<Empresa> insertEmpresa2(Empresa empresa);
    
}
