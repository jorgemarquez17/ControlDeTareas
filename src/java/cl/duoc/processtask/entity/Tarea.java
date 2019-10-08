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
@Table(name = "TAREA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarea.findAll", query = "SELECT t FROM Tarea t"),
    @NamedQuery(name = "Tarea.findByIdtarea", query = "SELECT t FROM Tarea t WHERE t.idtarea = :idtarea"),
    @NamedQuery(name = "Tarea.findByDgnombretarea", query = "SELECT t FROM Tarea t WHERE t.dgnombretarea = :dgnombretarea"),
    @NamedQuery(name = "Tarea.findByDcporccompletado", query = "SELECT t FROM Tarea t WHERE t.dcporccompletado = :dcporccompletado"),
    @NamedQuery(name = "Tarea.findByDcfechacreacion", query = "SELECT t FROM Tarea t WHERE t.dcfechacreacion = :dcfechacreacion"),
    @NamedQuery(name = "Tarea.findByDcfechaemision", query = "SELECT t FROM Tarea t WHERE t.dcfechaemision = :dcfechaemision"),
    @NamedQuery(name = "Tarea.findByDcfechatermino", query = "SELECT t FROM Tarea t WHERE t.dcfechatermino = :dcfechatermino"),
    @NamedQuery(name = "Tarea.findByDgjustificacion", query = "SELECT t FROM Tarea t WHERE t.dgjustificacion = :dgjustificacion"),
    @NamedQuery(name = "Tarea.findByBlrechazado", query = "SELECT t FROM Tarea t WHERE t.blrechazado = :blrechazado"),
    @NamedQuery(name = "Tarea.findByBlestado", query = "SELECT t FROM Tarea t WHERE t.blestado = :blestado"),
    @NamedQuery(name = "Tarea.findByBlvigente", query = "SELECT t FROM Tarea t WHERE t.blvigente = :blvigente")})
public class Tarea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTAREA")
    private Long idtarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "DGNOMBRETAREA")
    private String dgnombretarea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DCPORCCOMPLETADO")
    private long dcporccompletado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DCFECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dcfechacreacion;
    @Column(name = "DCFECHAEMISION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dcfechaemision;
    @Column(name = "DCFECHATERMINO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dcfechatermino;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "DGJUSTIFICACION")
    private String dgjustificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BLRECHAZADO")
    private short blrechazado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BLESTADO")
    private short blestado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BLVIGENTE")
    private short blvigente;
    @JoinColumn(name = "IDRESPONSABLETAREA_USUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario idresponsabletareaUsuario;
    @JoinColumn(name = "IDFLUJOTAREA_TAREA", referencedColumnName = "IDFLUJOTAREA")
    @ManyToOne(optional = false)
    private Flujotarea idflujotareaTarea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtareaSubtarea")
    private Collection<Subtarea> subtareaCollection;

    public Tarea() {
    }

    public Tarea(Long idtarea) {
        this.idtarea = idtarea;
    }

    public Tarea(Long idtarea, String dgnombretarea, long dcporccompletado, Date dcfechacreacion, String dgjustificacion, short blrechazado, short blestado, short blvigente) {
        this.idtarea = idtarea;
        this.dgnombretarea = dgnombretarea;
        this.dcporccompletado = dcporccompletado;
        this.dcfechacreacion = dcfechacreacion;
        this.dgjustificacion = dgjustificacion;
        this.blrechazado = blrechazado;
        this.blestado = blestado;
        this.blvigente = blvigente;
    }

    public Long getIdtarea() {
        return idtarea;
    }

    public void setIdtarea(Long idtarea) {
        this.idtarea = idtarea;
    }

    public String getDgnombretarea() {
        return dgnombretarea;
    }

    public void setDgnombretarea(String dgnombretarea) {
        this.dgnombretarea = dgnombretarea;
    }

    public long getDcporccompletado() {
        return dcporccompletado;
    }

    public void setDcporccompletado(long dcporccompletado) {
        this.dcporccompletado = dcporccompletado;
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

    public String getDgjustificacion() {
        return dgjustificacion;
    }

    public void setDgjustificacion(String dgjustificacion) {
        this.dgjustificacion = dgjustificacion;
    }

    public short getBlrechazado() {
        return blrechazado;
    }

    public void setBlrechazado(short blrechazado) {
        this.blrechazado = blrechazado;
    }

    public short getBlestado() {
        return blestado;
    }

    public void setBlestado(short blestado) {
        this.blestado = blestado;
    }

    public short getBlvigente() {
        return blvigente;
    }

    public void setBlvigente(short blvigente) {
        this.blvigente = blvigente;
    }

    public Usuario getIdresponsabletareaUsuario() {
        return idresponsabletareaUsuario;
    }

    public void setIdresponsabletareaUsuario(Usuario idresponsabletareaUsuario) {
        this.idresponsabletareaUsuario = idresponsabletareaUsuario;
    }

    public Flujotarea getIdflujotareaTarea() {
        return idflujotareaTarea;
    }

    public void setIdflujotareaTarea(Flujotarea idflujotareaTarea) {
        this.idflujotareaTarea = idflujotareaTarea;
    }

    @XmlTransient
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
