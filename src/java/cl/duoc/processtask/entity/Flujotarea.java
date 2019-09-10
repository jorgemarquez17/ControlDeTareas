/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "FLUJOTAREA")
@NamedQueries({
    @NamedQuery(name = "Flujotarea.findAll", query = "SELECT f FROM Flujotarea f"),
    @NamedQuery(name = "Flujotarea.findByIdflujotarea", query = "SELECT f FROM Flujotarea f WHERE f.idflujotarea = :idflujotarea"),
    @NamedQuery(name = "Flujotarea.findByBlestadoavance", query = "SELECT f FROM Flujotarea f WHERE f.blestadoavance = :blestadoavance"),
    @NamedQuery(name = "Flujotarea.findByBlvigente", query = "SELECT f FROM Flujotarea f WHERE f.blvigente = :blvigente"),
    @NamedQuery(name = "Flujotarea.findByDcfechacreacion", query = "SELECT f FROM Flujotarea f WHERE f.dcfechacreacion = :dcfechacreacion"),
    @NamedQuery(name = "Flujotarea.findByDcfechaemision", query = "SELECT f FROM Flujotarea f WHERE f.dcfechaemision = :dcfechaemision"),
    @NamedQuery(name = "Flujotarea.findByDcfechatermino", query = "SELECT f FROM Flujotarea f WHERE f.dcfechatermino = :dcfechatermino"),
    @NamedQuery(name = "Flujotarea.findByDcporcentajeavance", query = "SELECT f FROM Flujotarea f WHERE f.dcporcentajeavance = :dcporcentajeavance"),
    @NamedQuery(name = "Flujotarea.findByGnombreflujotarea", query = "SELECT f FROM Flujotarea f WHERE f.gnombreflujotarea = :gnombreflujotarea"),
    @NamedQuery(name = "Flujotarea.findByIdreporteFlujotarea", query = "SELECT f FROM Flujotarea f WHERE f.idreporteFlujotarea = :idreporteFlujotarea")})
public class Flujotarea implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFLUJOTAREA")
    private BigDecimal idflujotarea;
    @Column(name = "BLESTADOAVANCE")
    private Character blestadoavance;
    @Column(name = "BLVIGENTE")
    private Character blvigente;
    @Column(name = "DCFECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dcfechacreacion;
    @Column(name = "DCFECHAEMISION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dcfechaemision;
    @Column(name = "DCFECHATERMINO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dcfechatermino;
    @Column(name = "DCPORCENTAJEAVANCE")
    private BigInteger dcporcentajeavance;
    @Size(max = 255)
    @Column(name = "GNOMBREFLUJOTAREA")
    private String gnombreflujotarea;
    @Column(name = "IDREPORTE_FLUJOTAREA")
    private BigInteger idreporteFlujotarea;
    @OneToMany(mappedBy = "idflujotareaTarea")
    private Collection<Tarea> tareaCollection;
    @OneToMany(mappedBy = "idflujotareaFlujotareacliente")
    private Collection<Flujotareacliente> flujotareaclienteCollection;
    @JoinColumn(name = "IDUSUARIO_FLUJOTAREA", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario idusuarioFlujotarea;

    public Flujotarea() {
    }

    public Flujotarea(BigDecimal idflujotarea) {
        this.idflujotarea = idflujotarea;
    }

    public BigDecimal getIdflujotarea() {
        return idflujotarea;
    }

    public void setIdflujotarea(BigDecimal idflujotarea) {
        this.idflujotarea = idflujotarea;
    }

    public Character getBlestadoavance() {
        return blestadoavance;
    }

    public void setBlestadoavance(Character blestadoavance) {
        this.blestadoavance = blestadoavance;
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

    public BigInteger getDcporcentajeavance() {
        return dcporcentajeavance;
    }

    public void setDcporcentajeavance(BigInteger dcporcentajeavance) {
        this.dcporcentajeavance = dcporcentajeavance;
    }

    public String getGnombreflujotarea() {
        return gnombreflujotarea;
    }

    public void setGnombreflujotarea(String gnombreflujotarea) {
        this.gnombreflujotarea = gnombreflujotarea;
    }

    public BigInteger getIdreporteFlujotarea() {
        return idreporteFlujotarea;
    }

    public void setIdreporteFlujotarea(BigInteger idreporteFlujotarea) {
        this.idreporteFlujotarea = idreporteFlujotarea;
    }

    public Collection<Tarea> getTareaCollection() {
        return tareaCollection;
    }

    public void setTareaCollection(Collection<Tarea> tareaCollection) {
        this.tareaCollection = tareaCollection;
    }

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
