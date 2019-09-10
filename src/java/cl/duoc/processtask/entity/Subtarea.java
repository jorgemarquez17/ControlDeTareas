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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SUBTAREA")
@NamedQueries({
    @NamedQuery(name = "Subtarea.findAll", query = "SELECT s FROM Subtarea s"),
    @NamedQuery(name = "Subtarea.findByIdsubtarea", query = "SELECT s FROM Subtarea s WHERE s.idsubtarea = :idsubtarea"),
    @NamedQuery(name = "Subtarea.findByBlrechazo", query = "SELECT s FROM Subtarea s WHERE s.blrechazo = :blrechazo"),
    @NamedQuery(name = "Subtarea.findByBlvigente", query = "SELECT s FROM Subtarea s WHERE s.blvigente = :blvigente"),
    @NamedQuery(name = "Subtarea.findByDcfechacreacion", query = "SELECT s FROM Subtarea s WHERE s.dcfechacreacion = :dcfechacreacion"),
    @NamedQuery(name = "Subtarea.findByDcfechaemision", query = "SELECT s FROM Subtarea s WHERE s.dcfechaemision = :dcfechaemision"),
    @NamedQuery(name = "Subtarea.findByDcfechatermino", query = "SELECT s FROM Subtarea s WHERE s.dcfechatermino = :dcfechatermino"),
    @NamedQuery(name = "Subtarea.findByDcidresponsabletarea", query = "SELECT s FROM Subtarea s WHERE s.dcidresponsabletarea = :dcidresponsabletarea"),
    @NamedQuery(name = "Subtarea.findByDgjustificacion", query = "SELECT s FROM Subtarea s WHERE s.dgjustificacion = :dgjustificacion"),
    @NamedQuery(name = "Subtarea.findByDgnombresubtarea", query = "SELECT s FROM Subtarea s WHERE s.dgnombresubtarea = :dgnombresubtarea")})
public class Subtarea implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSUBTAREA")
    private BigDecimal idsubtarea;
    @Column(name = "BLRECHAZO")
    private Character blrechazo;
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
    @Column(name = "DCIDRESPONSABLETAREA")
    private BigInteger dcidresponsabletarea;
    @Size(max = 255)
    @Column(name = "DGJUSTIFICACION")
    private String dgjustificacion;
    @Size(max = 255)
    @Column(name = "DGNOMBRESUBTAREA")
    private String dgnombresubtarea;
    @JoinColumn(name = "IDTAREA_SUBTAREA", referencedColumnName = "IDTAREA")
    @ManyToOne
    private Tarea idtareaSubtarea;
    @JoinColumn(name = "IDSEMAFORO_SUBTAREA", referencedColumnName = "IDSEMAFORO")
    @ManyToOne
    private Semaforo idsemaforoSubtarea;

    public Subtarea() {
    }

    public Subtarea(BigDecimal idsubtarea) {
        this.idsubtarea = idsubtarea;
    }

    public BigDecimal getIdsubtarea() {
        return idsubtarea;
    }

    public void setIdsubtarea(BigDecimal idsubtarea) {
        this.idsubtarea = idsubtarea;
    }

    public Character getBlrechazo() {
        return blrechazo;
    }

    public void setBlrechazo(Character blrechazo) {
        this.blrechazo = blrechazo;
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

    public BigInteger getDcidresponsabletarea() {
        return dcidresponsabletarea;
    }

    public void setDcidresponsabletarea(BigInteger dcidresponsabletarea) {
        this.dcidresponsabletarea = dcidresponsabletarea;
    }

    public String getDgjustificacion() {
        return dgjustificacion;
    }

    public void setDgjustificacion(String dgjustificacion) {
        this.dgjustificacion = dgjustificacion;
    }

    public String getDgnombresubtarea() {
        return dgnombresubtarea;
    }

    public void setDgnombresubtarea(String dgnombresubtarea) {
        this.dgnombresubtarea = dgnombresubtarea;
    }

    public Tarea getIdtareaSubtarea() {
        return idtareaSubtarea;
    }

    public void setIdtareaSubtarea(Tarea idtareaSubtarea) {
        this.idtareaSubtarea = idtareaSubtarea;
    }

    public Semaforo getIdsemaforoSubtarea() {
        return idsemaforoSubtarea;
    }

    public void setIdsemaforoSubtarea(Semaforo idsemaforoSubtarea) {
        this.idsemaforoSubtarea = idsemaforoSubtarea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubtarea != null ? idsubtarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subtarea)) {
            return false;
        }
        Subtarea other = (Subtarea) object;
        if ((this.idsubtarea == null && other.idsubtarea != null) || (this.idsubtarea != null && !this.idsubtarea.equals(other.idsubtarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.processtask.entity.Subtarea[ idsubtarea=" + idsubtarea + " ]";
    }
    
}
