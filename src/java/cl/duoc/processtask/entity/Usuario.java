/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario"),
    @NamedQuery(name = "Usuario.findByDgusername", query = "SELECT u FROM Usuario u WHERE u.dgusername = :dgusername"),
    @NamedQuery(name = "Usuario.findByDgpassword", query = "SELECT u FROM Usuario u WHERE u.dgpassword = :dgpassword"),
    @NamedQuery(name = "Usuario.findByDcfechacreacion", query = "SELECT u FROM Usuario u WHERE u.dcfechacreacion = :dcfechacreacion"),
    @NamedQuery(name = "Usuario.findByBlhabilitado", query = "SELECT u FROM Usuario u WHERE u.blhabilitado = :blhabilitado"),
    @NamedQuery(name = "Usuario.findByBlvigente", query = "SELECT u FROM Usuario u WHERE u.blvigente = :blvigente")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUSUARIO")
    private Long idusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "DGUSERNAME")
    private String dgusername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "DGPASSWORD")
    private String dgpassword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DCFECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dcfechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BLHABILITADO")
    private short blhabilitado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BLVIGENTE")
    private short blvigente;
    @OneToMany(mappedBy = "idresponsabletareaUsuario")
    private Collection<Tarea> tareaCollection;
    @JoinColumn(name = "IDTIPOROL_USUARIO", referencedColumnName = "IDTIPOROL")
    @ManyToOne(optional = false)
    private Tiporol idtiporolUsuario;
    @JoinColumn(name = "IDTIPOPERFIL_USUARIO", referencedColumnName = "IDTIPOPERFIL")
    @ManyToOne(optional = false)
    private Tipoperfil idtipoperfilUsuario;
    @JoinColumn(name = "IDNOTIFICACION_USUARIO", referencedColumnName = "IDNOTIFICACION")
    @ManyToOne(optional = false)
    private Notificacion idnotificacionUsuario;
    @OneToMany(mappedBy = "idresponsablesubtareaUsuario")
    private Collection<Subtarea> subtareaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioFlujotarea")
    private Collection<Flujotarea> flujotareaCollection;

    public Usuario() {
    }

    public Usuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(Long idusuario, String dgusername, String dgpassword, Date dcfechacreacion, short blhabilitado, short blvigente) {
        this.idusuario = idusuario;
        this.dgusername = dgusername;
        this.dgpassword = dgpassword;
        this.dcfechacreacion = dcfechacreacion;
        this.blhabilitado = blhabilitado;
        this.blvigente = blvigente;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getDgusername() {
        return dgusername;
    }

    public void setDgusername(String dgusername) {
        this.dgusername = dgusername;
    }

    public String getDgpassword() {
        return dgpassword;
    }

    public void setDgpassword(String dgpassword) {
        this.dgpassword = dgpassword;
    }

    public Date getDcfechacreacion() {
        return dcfechacreacion;
    }

    public void setDcfechacreacion(Date dcfechacreacion) {
        this.dcfechacreacion = dcfechacreacion;
    }

    public short getBlhabilitado() {
        return blhabilitado;
    }

    public void setBlhabilitado(short blhabilitado) {
        this.blhabilitado = blhabilitado;
    }

    public short getBlvigente() {
        return blvigente;
    }

    public void setBlvigente(short blvigente) {
        this.blvigente = blvigente;
    }

    @XmlTransient
    public Collection<Tarea> getTareaCollection() {
        return tareaCollection;
    }

    public void setTareaCollection(Collection<Tarea> tareaCollection) {
        this.tareaCollection = tareaCollection;
    }

    public Tiporol getIdtiporolUsuario() {
        return idtiporolUsuario;
    }

    public void setIdtiporolUsuario(Tiporol idtiporolUsuario) {
        this.idtiporolUsuario = idtiporolUsuario;
    }

    public Tipoperfil getIdtipoperfilUsuario() {
        return idtipoperfilUsuario;
    }

    public void setIdtipoperfilUsuario(Tipoperfil idtipoperfilUsuario) {
        this.idtipoperfilUsuario = idtipoperfilUsuario;
    }

    public Notificacion getIdnotificacionUsuario() {
        return idnotificacionUsuario;
    }

    public void setIdnotificacionUsuario(Notificacion idnotificacionUsuario) {
        this.idnotificacionUsuario = idnotificacionUsuario;
    }

    @XmlTransient
    public Collection<Subtarea> getSubtareaCollection() {
        return subtareaCollection;
    }

    public void setSubtareaCollection(Collection<Subtarea> subtareaCollection) {
        this.subtareaCollection = subtareaCollection;
    }

    @XmlTransient
    public Collection<Flujotarea> getFlujotareaCollection() {
        return flujotareaCollection;
    }

    public void setFlujotareaCollection(Collection<Flujotarea> flujotareaCollection) {
        this.flujotareaCollection = flujotareaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.processtask.entity.Usuario[ idusuario=" + idusuario + " ]";
    }
    
}
