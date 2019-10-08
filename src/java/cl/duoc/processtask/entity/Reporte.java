/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "REPORTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reporte.findAll", query = "SELECT r FROM Reporte r"),
    @NamedQuery(name = "Reporte.findByIdreporte", query = "SELECT r FROM Reporte r WHERE r.idreporte = :idreporte"),
    @NamedQuery(name = "Reporte.findByDcfechacreacion", query = "SELECT r FROM Reporte r WHERE r.dcfechacreacion = :dcfechacreacion"),
    @NamedQuery(name = "Reporte.findByDcfechaemision", query = "SELECT r FROM Reporte r WHERE r.dcfechaemision = :dcfechaemision"),
    @NamedQuery(name = "Reporte.findByDcfechatermino", query = "SELECT r FROM Reporte r WHERE r.dcfechatermino = :dcfechatermino"),
    @NamedQuery(name = "Reporte.findByDgnombrereporte", query = "SELECT r FROM Reporte r WHERE r.dgnombrereporte = :dgnombrereporte"),
    @NamedQuery(name = "Reporte.findByDcporcentaje", query = "SELECT r FROM Reporte r WHERE r.dcporcentaje = :dcporcentaje"),
    @NamedQuery(name = "Reporte.findByBlestadoreporte", query = "SELECT r FROM Reporte r WHERE r.blestadoreporte = :blestadoreporte"),
    @NamedQuery(name = "Reporte.findByBlvigente", query = "SELECT r FROM Reporte r WHERE r.blvigente = :blvigente")})
public class Reporte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDREPORTE")
    private Long idreporte;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "DCFECHATERMINO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dcfechatermino;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "DGNOMBREREPORTE")
    private String dgnombrereporte;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "DCPORCENTAJE")
    private BigDecimal dcporcentaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BLESTADOREPORTE")
    private short blestadoreporte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BLVIGENTE")
    private short blvigente;

    public Reporte() {
    }

    public Reporte(Long idreporte) {
        this.idreporte = idreporte;
    }

    public Reporte(Long idreporte, Date dcfechacreacion, Date dcfechaemision, Date dcfechatermino, String dgnombrereporte, BigDecimal dcporcentaje, short blestadoreporte, short blvigente) {
        this.idreporte = idreporte;
        this.dcfechacreacion = dcfechacreacion;
        this.dcfechaemision = dcfechaemision;
        this.dcfechatermino = dcfechatermino;
        this.dgnombrereporte = dgnombrereporte;
        this.dcporcentaje = dcporcentaje;
        this.blestadoreporte = blestadoreporte;
        this.blvigente = blvigente;
    }

    public Long getIdreporte() {
        return idreporte;
    }

    public void setIdreporte(Long idreporte) {
        this.idreporte = idreporte;
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

    public String getDgnombrereporte() {
        return dgnombrereporte;
    }

    public void setDgnombrereporte(String dgnombrereporte) {
        this.dgnombrereporte = dgnombrereporte;
    }

    public BigDecimal getDcporcentaje() {
        return dcporcentaje;
    }

    public void setDcporcentaje(BigDecimal dcporcentaje) {
        this.dcporcentaje = dcporcentaje;
    }

    public short getBlestadoreporte() {
        return blestadoreporte;
    }

    public void setBlestadoreporte(short blestadoreporte) {
        this.blestadoreporte = blestadoreporte;
    }

    public short getBlvigente() {
        return blvigente;
    }

    public void setBlvigente(short blvigente) {
        this.blvigente = blvigente;
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
