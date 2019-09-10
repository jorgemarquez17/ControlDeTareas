/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "USUARIO")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario"),
    @NamedQuery(name = "Usuario.findByBlhabilitado", query = "SELECT u FROM Usuario u WHERE u.blhabilitado = :blhabilitado"),
    @NamedQuery(name = "Usuario.findByBlvigente", query = "SELECT u FROM Usuario u WHERE u.blvigente = :blvigente"),
    @NamedQuery(name = "Usuario.findByDcfechacreacion", query = "SELECT u FROM Usuario u WHERE u.dcfechacreacion = :dcfechacreacion"),
    @NamedQuery(name = "Usuario.findByDcfechatermino", query = "SELECT u FROM Usuario u WHERE u.dcfechatermino = :dcfechatermino"),
    @NamedQuery(name = "Usuario.findByDgpassword", query = "SELECT u FROM Usuario u WHERE u.dgpassword = :dgpassword"),
    @NamedQuery(name = "Usuario.findByDgusername", query = "SELECT u FROM Usuario u WHERE u.dgusername = :dgusername")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUSUARIO")
    private BigDecimal idusuario;
    @Column(name = "BLHABILITADO")
    private Character blhabilitado;
    @Column(name = "BLVIGENTE")
    private Character blvigente;
    @Column(name = "DCFECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dcfechacreacion;
    @Column(name = "DCFECHATERMINO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dcfechatermino;
    @Size(max = 255)
    @Column(name = "DGPASSWORD")
    private String dgpassword;
    @Size(max = 255)
    @Column(name = "DGUSERNAME")
    private String dgusername;
    @JoinColumn(name = "IDTIPOPERFIL_USUARIO", referencedColumnName = "IDTIPOPERFIL")
    @ManyToOne
    private Tipoperfil idtipoperfilUsuario;
    @OneToMany(mappedBy = "idusuarioFlujotarea")
    private Collection<Flujotarea> flujotareaCollection;

    public Usuario() {
    }

    public Usuario(BigDecimal idusuario) {
        this.idusuario = idusuario;
    }

    public BigDecimal getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(BigDecimal idusuario) {
        this.idusuario = idusuario;
    }

    public Character getBlhabilitado() {
        return blhabilitado;
    }

    public void setBlhabilitado(Character blhabilitado) {
        this.blhabilitado = blhabilitado;
    }

    public Character getBlvigente() {
        return blvigente;
    }

    public void setBlvigente(Character blvigente) {
        this.blvigente = blvigente;
    }

    public Date getDcfechacreacion() {
        return dcfechacreacion;
    }

    public void setDcfechacreacion(Date dcfechacreacion) {
        this.dcfechacreacion = dcfechacreacion;
    }

    public Date getDcfechatermino() {
        return dcfechatermino;
    }

    public void setDcfechatermino(Date dcfechatermino) {
        this.dcfechatermino = dcfechatermino;
    }

    public String getDgpassword() {
        return dgpassword;
    }

    public void setDgpassword(String dgpassword) {
        this.dgpassword = dgpassword;
    }

    public String getDgusername() {
        return dgusername;
    }

    public void setDgusername(String dgusername) {
        this.dgusername = dgusername;
    }

    public Tipoperfil getIdtipoperfilUsuario() {
        return idtipoperfilUsuario;
    }

    public void setIdtipoperfilUsuario(Tipoperfil idtipoperfilUsuario) {
        this.idtipoperfilUsuario = idtipoperfilUsuario;
    }

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
