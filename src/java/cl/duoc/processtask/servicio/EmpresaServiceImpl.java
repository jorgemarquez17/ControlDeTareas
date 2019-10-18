/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.processtask.servicio;

import cl.duoc.processtask.eis.EmpresaDao;
import cl.duoc.processtask.entity.Empresa;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
/**
 *
 * @author jorge
 */
@Stateless
public class EmpresaServiceImpl implements EmpresaService, EmpresaServiceWS{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @EJB
    EmpresaDao empresaDao;

    @Override
    public void registrarEmpresa(Empresa empresa) {
        empresaDao.insertEmpresa(empresa);
    }

    @Override
    public List<Empresa> buscarEmpresaById(Empresa empresa) {
        return empresaDao.findIdEmpresa(empresa);
    }

    @Override
    public List<Empresa> buscarAllEmpresas() {
        return empresaDao.findIdEmpresa();
    }

    @Override
    public List<Empresa> modificarEmpresa(Empresa empresa) {
        //empresaDao.modifyEmpresa(empresa);
        return empresaDao.modifyEmpresa(empresa);
    }

    @Override
    public List<Empresa> eliminarEmpresa(Empresa empresa) {
        return empresaDao.deleteEmpresa(empresa);
    }

    @Override
    public List<Empresa> registrarEmpresa2(Empresa empresa) {
        return empresaDao.insertEmpresa2(empresa);
    }
    
}
