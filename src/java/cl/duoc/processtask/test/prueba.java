/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.processtask.test;


import cl.duoc.processtask.entity.Empresa;
import cl.duoc.processtask.servicio.EmpresaService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
/**
 *
 * @author jorge
 */
public class prueba {

    
    public static void main(String[] args) {       

        try {
            Context jndi = new InitialContext();
            EmpresaService ci = (EmpresaService) jndi.lookup("java:global/ProcessTask/EmpresaServiceImpl!cl.duoc.processtask.servicio.EmpresaService");

           
           //Ingresar Empresa
            Empresa empresa = new Empresa();
            //empresa.setIdempresa(BigDecimal.ONE);
            empresa.setDgrut("898956-8");
            empresa.setDgdireccion("Renca");
            empresa.setDgnombreempresa("Empresa1");
            empresa.setDgcontacto("Jorge Marquez");
            empresa.setDgcorreo("jmar@mail.com");
            //empresa.setBlvigente(2);
            ci.registrarEmpresa2(empresa);
            //ci.registrarEmpresa(empresa);
            
            //BuscarporId
//              Empresa emp =ci.buscarEmpresaById(new Empresa(new BigDecimal(21)));
//              
//              System.out.println("La empresa encontrada es :" + emp.toString());
            
            
            //Buscar Todas Las Empresas
//            List<Empresa> listEmpresa = new ArrayList<Empresa>();
//            listEmpresa =  ci.buscarAllEmpresas();
//            System.out.println("Listado de empresas es : ");
//            for(Empresa emp : listEmpresa){
//                System.out.println( emp.toString());
//            }
            
            //MOdificar
//            Empresa emp =ci.buscarEmpresaById(new Empresa(new BigDecimal(2)));
//            emp.setDgrut("55555-5");
//            emp.setDgcontacto("Alberto");
//            emp.setDgcorreo("Alberto@alumnos.duoc.cl");
//            ci.modificarEmpresa(emp);
            
            //Eliminar
//            Empresa emp = new Empresa();
//             emp =ci.buscarEmpresaById(new Empresa( 27L));
//            
//            //ci.modificarEmpresa(em);
//            System.out.println(emp.toString());
//            ci.eliminarEmpresa(emp);
            

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void buscarEmpresa(){
        
    }
}
