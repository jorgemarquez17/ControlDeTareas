
package cl.duoc.processtask.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "registrarEmpresa", namespace = "http://ws.processtask.duoc.cl/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registrarEmpresa", namespace = "http://ws.processtask.duoc.cl/", propOrder = {
    "rut",
    "direccion",
    "contacto",
    "correo"
})
public class RegistrarEmpresa {

    @XmlElement(name = "rut", namespace = "")
    private String rut;
    @XmlElement(name = "direccion", namespace = "")
    private String direccion;
    @XmlElement(name = "contacto", namespace = "")
    private String contacto;
    @XmlElement(name = "correo", namespace = "")
    private String correo;

    /**
     * 
     * @return
     *     returns String
     */
    public String getRut() {
        return this.rut;
    }

    /**
     * 
     * @param rut
     *     the value for the rut property
     */
    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getDireccion() {
        return this.direccion;
    }

    /**
     * 
     * @param direccion
     *     the value for the direccion property
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getContacto() {
        return this.contacto;
    }

    /**
     * 
     * @param contacto
     *     the value for the contacto property
     */
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getCorreo() {
        return this.correo;
    }

    /**
     * 
     * @param correo
     *     the value for the correo property
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
