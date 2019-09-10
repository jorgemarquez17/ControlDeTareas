/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "REPORTE")
@NamedQueries({
    @NamedQuery(name = "Reporte.findAll", query = "SELECT r FROM Reporte r"),
    @NamedQuery(name = "Reporte.findByIdreporte", query = "SELECT r FROM Reporte r WHERE r.idreporte = :idreporte"),
    @NamedQuery(name = "Reporte.findByBlestadoreporte", query = "SELECT r FROM Reporte r WHERE r.blestadoreporte = :blestadoreporte"),
    @NamedQuery(name = "Reporte.findByBlvigente", query = "SELECT r FROM Reporte r WHERE r.blvigente = :blvigente"),
    @NamedQuery(name = "Reporte.findByDcfechacreacion", query = "SELECT r FROM Reporte r WHERE r.dcfechacreacion = :dcfechacreacion"),
    @NamedQuery(name = "Reporte.findByDcfechaemision", query = "SELECT r FROM Reporte r WHERE r.dcfechaemision = :dcfechaemision"),
    @NamedQuery(name = "Reporte.findByDcfechatermino", query = "SELECT r FROM Reporte r WHERE r.dcfechatermino = :dcfechatermino"),
    @NamedQuery(name = "Reporte.findByDcporcentaje", query = "SELECT r FROM Reporte r WHERE r.dcporcentaje = :dcporcentaje"),
    @NamedQuery(name = "Reporte.findByDgnombrereporte", query = "SELECT r FROM Reporte r WHERE r.dgnombrereporte = :dgnombrereporte")})
public class Reporte implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDREPORTE")
    private BigDecimal idreporte;
    @Column(name = "BLESTADOREPORTE")
    private Character blestadoreporte;
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
    @Column(name = "DCPORCENTAJE")
    private BigInteger dcporcentaje;
    @Size(max = 255)
    @Column(name = "DGNOMBREREPORTE")
    private String dgnombrereporte;

    public Reporte() {
    }

    public Reporte(BigDecimal idreporte) {
        this.idreporte = idreporte;
    }

    public BigDecimal getIdreporte() {
        return idreporte;
    }

    public void setIdreporte(BigDecimal idreporte) {
        this.idreporte = idreporte;
    }

    public Character getBlestadoreporte() {
        return blestadoreporte;
    }

    public void setBlestadoreporte(Character blestadoreporte) {
        this.blestadoreporte = blestadoreporte;
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

    public BigInteger getDcporcentaje() {
        return dcporcentaje;
    }

    public void setDcporcentaje(BigInteger dcporcentaje) {
        this.dcporcentaje = dcporcentaje;
    }

    public String getDgnombrereporte() {
        return dgnombrereporte;
    }

    public void setDgnombrereporte(String dgnombrereporte) {
        this.dgnombrereporte = dgnombrereporte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreporte != null ? idreporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reporte)) {
            return false;
        }
        Reporte other = (Reporte) object;
        if ((this.idreporte == null && other.idreporte != null) || (this.idreporte != null && !this.idreporte.equals(other.idreporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.processtask.entity.Reporte[ idreporte=" + idreporte + " ]";
    }
    
}
