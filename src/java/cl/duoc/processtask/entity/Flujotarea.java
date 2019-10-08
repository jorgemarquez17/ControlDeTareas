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
@Table(name = "FLUJOTAREA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flujotarea.findAll", query = "SELECT f FROM Flujotarea f"),
    @NamedQuery(name = "Flujotarea.findByIdflujotarea", query = "SELECT f FROM Flujotarea f WHERE f.idflujotarea = :idflujotarea"),
    @NamedQuery(name = "Flujotarea.findByIdreporteFlujotarea", query = "SELECT f FROM Flujotarea f WHERE f.idreporteFlujotarea = :idreporteFlujotarea"),
    @NamedQuery(name = "Flujotarea.findByGnombreflujotarea", query = "SELECT f FROM Flujotarea f WHERE f.gnombreflujotarea = :gnombreflujotarea"),
    @NamedQuery(name = "Flujotarea.findByDcfechacreacion", query = "SELECT f FROM Flujotarea f WHERE f.dcfechacreacion = :dcfechacreacion"),
    @NamedQuery(name = "Flujotarea.findByDcfechaemision", query = "SELECT f FROM Flujotarea f WHERE f.dcfechaemision = :dcfechaemision"),
    @NamedQuery(name = "Flujotarea.findByDcfechatermino", query = "SELECT f FROM Flujotarea f WHERE f.dcfechatermino = :dcfechatermino"),
    @NamedQuery(name = "Flujotarea.findByDcporcentajeavance", query = "SELECT f FROM Flujotarea f WHERE f.dcporcentajeavance = :dcporcentajeavance"),
    @NamedQuery(name = "Flujotarea.findByBlestadoavance", query = "SELECT f FROM Flujotarea f WHERE f.blestadoavance = :blestadoavance"),
    @NamedQuery(name = "Flujotarea.findByBlvigente", query = "SELECT f FROM Flujotarea f WHERE f.blvigente = :blvigente")})
public class Flujotarea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFLUJOTAREA")
    private Long idflujotarea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDREPORTE_FLUJOTAREA")
    private long idreporteFlujotarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "GNOMBREFLUJOTAREA")
    private String gnombreflujotarea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DCFECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dcfechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DCFECHAEMISION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dcfechaemision;
    @Column(name = "DCFECHATERMINO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dcfechatermino;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "DCPORCENTAJEAVANCE")
    private BigDecimal dcporcentajeavance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BLESTADOAVANCE")
    private short blestadoavance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BLVIGENTE")
    private short blvigente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idflujotareaTarea")
    private Collection<Tarea> tareaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idflujotareaFlujotareacliente")
    private Collection<Flujotareacliente> flujotareaclienteCollection;
    @JoinColumn(name = "IDUSUARIO_FLUJOTAREA", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false)
    private Usuario idusuarioFlujotarea;

    public Flujotarea() {
    }

    public Flujotarea(Long idflujotarea) {
        this.idflujotarea = idflujotarea;
    }

    public Flujotarea(Long idflujotarea, long idreporteFlujotarea, String gnombreflujotarea, Date dcfechacreacion, Date dcfechaemision, BigDecimal dcporcentajeavance, short blestadoavance, short blvigente) {
        this.idflujotarea = idflujotarea;
        this.idreporteFlujotarea = idreporteFlujotarea;
        this.gnombreflujotarea = gnombreflujotarea;
        this.dcfechacreacion = dcfechacreacion;
        this.dcfechaemision = dcfechaemision;
        this.dcporcentajeavance = dcporcentajeavance;
        this.blestadoavance = blestadoavance;
        this.blvigente = blvigente;
    }

    public Long getIdflujotarea() {
        return idflujotarea;
    }

    public void setIdflujotarea(Long idflujotarea) {
        this.idflujotarea = idflujotarea;
    }

    public long getIdreporteFlujotarea() {
        return idreporteFlujotarea;
    }

    public void setIdreporteFlujotarea(long idreporteFlujotarea) {
        this.idreporteFlujotarea = idreporteFlujotarea;
    }

    public String getGnombreflujotarea() {
        return gnombreflujotarea;
    }

    public void setGnombreflujotarea(String gnombreflujotarea) {
        this.gnombreflujotarea = gnombreflujotarea;
    }

    public Date getDcfechacreacion() {
        return dcfechacreacion;
    }

    public void setDcfechacreacion(Date dcfechacreacion) {
        this.dcfechacreacion = dcfechacreacion;
    }

    public Date getDcfechaemision() {
        return dcfechaemision;
    }

    public void setDcfechaemision(Date dcfechaemision) {
        this.dcfechaemision = dcfechaemision;
    }

    public Date getDcfechatermino() {
        return dcfechatermino;
    }

    public void setDcfechatermino(Date dcfechatermino) {
        this.dcfechatermino = dcfechatermino;
    }

    public BigDecimal getDcporcentajeavance() {
        return dcporcentajeavance;
    }

    public void setDcporcentajeavance(BigDecimal dcporcentajeavance) {
        this.dcporcentajeavance = dcporcentajeavance;
    }

    public short getBlestadoavance() {
        return blestadoavance;
    }

    public void setBlestadoavance(short blestadoavance) {
        this.blestadoavance = blestadoavance;
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

    @XmlTransient
    public Collection<Flujotareacliente> getFlujotareaclienteCollection() {
        return flujotareaclienteCollection;
    }

    public void setFlujotareaclienteCollection(Collection<Flujotareacliente> flujotareaclienteCollection) {
        this.flujotareaclienteCollection = flujotareaclienteCollection;
    }

    public Usuario getIdusuarioFlujotarea() {
        return idusuarioFlujotarea;
    }

    public void setIdusuarioFlujotarea(Usuario idusuarioFlujotarea) {
        this.idusuarioFlujotarea = idusuarioFlujotarea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idflujotarea != null ? idflujotarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flujotarea)) {
            return false;
        }
        Flujotarea other = (Flujotarea) object;
        if ((this.idflujotarea == null && other.idflujotarea != null) || (this.idflujotarea != null && !this.idflujotarea.equals(other.idflujotarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.processtask.entity.Flujotarea[ idflujotarea=" + idflujotarea + " ]";
    }
    
}
