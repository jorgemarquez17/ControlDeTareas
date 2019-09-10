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
@Table(name = "TAREA")
@NamedQueries({
    @NamedQuery(name = "Tarea.findAll", query = "SELECT t FROM Tarea t"),
    @NamedQuery(name = "Tarea.findByIdtarea", query = "SELECT t FROM Tarea t WHERE t.idtarea = :idtarea"),
    @NamedQuery(name = "Tarea.findByBlestado", query = "SELECT t FROM Tarea t WHERE t.blestado = :blestado"),
    @NamedQuery(name = "Tarea.findByBlrechazado", query = "SELECT t FROM Tarea t WHERE t.blrechazado = :blrechazado"),
    @NamedQuery(name = "Tarea.findByBlvigente", query = "SELECT t FROM Tarea t WHERE t.blvigente = :blvigente"),
    @NamedQuery(name = "Tarea.findByDcfechacreacion", query = "SELECT t FROM Tarea t WHERE t.dcfechacreacion = :dcfechacreacion"),
    @NamedQuery(name = "Tarea.findByDcfechaemision", query = "SELECT t FROM Tarea t WHERE t.dcfechaemision = :dcfechaemision"),
    @NamedQuery(name = "Tarea.findByDcfechatermino", query = "SELECT t FROM Tarea t WHERE t.dcfechatermino = :dcfechatermino"),
    @NamedQuery(name = "Tarea.findByDcporccompletado", query = "SELECT t FROM Tarea t WHERE t.dcporccompletado = :dcporccompletado"),
    @NamedQuery(name = "Tarea.findByDgjustificacion", query = "SELECT t FROM Tarea t WHERE t.dgjustificacion = :dgjustificacion"),
    @NamedQuery(name = "Tarea.findByDgnombretarea", query = "SELECT t FROM Tarea t WHERE t.dgnombretarea = :dgnombretarea")})
public class Tarea implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTAREA")
    private BigDecimal idtarea;
    @Column(name = "BLESTADO")
    private Character blestado;
    @Column(name = "BLRECHAZADO")
    private Character blrechazado;
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
    @Column(name = "DCPORCCOMPLETADO")
    private BigInteger dcporccompletado;
    @Size(max = 255)
    @Column(name = "DGJUSTIFICACION")
    private String dgjustificacion;
    @Size(max = 255)
    @Column(name = "DGNOMBRETAREA")
    private String dgnombretarea;
    @JoinColumn(name = "IDRESPONSABLETAREA_TAREA", referencedColumnName = "IDRESPONSABLETAREA")
    @ManyToOne
    private Responsabletarea idresponsabletareaTarea;
    @JoinColumn(name = "IDFLUJOTAREA_TAREA", referencedColumnName = "IDFLUJOTAREA")
    @ManyToOne
    private Flujotarea idflujotareaTarea;
    @OneToMany(mappedBy = "idtareaSubtarea")
    private Collection<Subtarea> subtareaCollection;

    public Tarea() {
    }

    public Tarea(BigDecimal idtarea) {
        this.idtarea = idtarea;
    }

    public BigDecimal getIdtarea() {
        return idtarea;
    }

    public void setIdtarea(BigDecimal idtarea) {
        this.idtarea = idtarea;
    }

    public Character getBlestado() {
        return blestado;
    }

    public void setBlestado(Character blestado) {
        this.blestado = blestado;
    }

    public Character getBlrechazado() {
        return blrechazado;
    }

    public void setBlrechazado(Character blrechazado) {
        this.blrechazado = blrechazado;
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

    public BigInteger getDcporccompletado() {
        return dcporccompletado;
    }

    public void setDcporccompletado(BigInteger dcporccompletado) {
        this.dcporccompletado = dcporccompletado;
    }

    public String getDgjustificacion() {
        return dgjustificacion;
    }

    public void setDgjustificacion(String dgjustificacion) {
        this.dgjustificacion = dgjustificacion;
    }

    public String getDgnombretarea() {
        return dgnombretarea;
    }

    public void setDgnombretarea(String dgnombretarea) {
        this.dgnombretarea = dgnombretarea;
    }

    public Responsabletarea getIdresponsabletareaTarea() {
        return idresponsabletareaTarea;
    }

    public void setIdresponsabletareaTarea(Responsabletarea idresponsabletareaTarea) {
        this.idresponsabletareaTarea = idresponsabletareaTarea;
    }

    public Flujotarea getIdflujotareaTarea() {
        return idflujotareaTarea;
    }

    public void setIdflujotareaTarea(Flujotarea idflujotareaTarea) {
        this.idflujotareaTarea = idflujotareaTarea;
    }

    public Collection<Subtarea> getSubtareaCollection() {
        return subtareaCollection;
    }

    public void setSubtareaCollection(Collection<Subtarea> subtareaCollection) {
        this.subtareaCollection = subtareaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtarea != null ? idtarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarea)) {
            return false;
        }
        Tarea other = (Tarea) object;
        if ((this.idtarea == null && other.idtarea != null) || (this.idtarea != null && !this.idtarea.equals(other.idtarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.processtask.entity.Tarea[ idtarea=" + idtarea + " ]";
    }
    
}
