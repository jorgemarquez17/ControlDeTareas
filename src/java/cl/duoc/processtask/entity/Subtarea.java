/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "SUBTAREA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subtarea.findAll", query = "SELECT s FROM Subtarea s"),
    @NamedQuery(name = "Subtarea.findByIdsubtarea", query = "SELECT s FROM Subtarea s WHERE s.idsubtarea = :idsubtarea"),
    @NamedQuery(name = "Subtarea.findByDgnombresubtarea", query = "SELECT s FROM Subtarea s WHERE s.dgnombresubtarea = :dgnombresubtarea"),
    @NamedQuery(name = "Subtarea.findByDcfechacreacion", query = "SELECT s FROM Subtarea s WHERE s.dcfechacreacion = :dcfechacreacion"),
    @NamedQuery(name = "Subtarea.findByDcfechaemision", query = "SELECT s FROM Subtarea s WHERE s.dcfechaemision = :dcfechaemision"),
    @NamedQuery(name = "Subtarea.findByDcfechatermino", query = "SELECT s FROM Subtarea s WHERE s.dcfechatermino = :dcfechatermino"),
    @NamedQuery(name = "Subtarea.findByDgjustificacion", query = "SELECT s FROM Subtarea s WHERE s.dgjustificacion = :dgjustificacion"),
    @NamedQuery(name = "Subtarea.findByBlrechazo", query = "SELECT s FROM Subtarea s WHERE s.blrechazo = :blrechazo"),
    @NamedQuery(name = "Subtarea.findByBlvigente", query = "SELECT s FROM Subtarea s WHERE s.blvigente = :blvigente")})
public class Subtarea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSUBTAREA")
    private Long idsubtarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "DGNOMBRESUBTAREA")
    private String dgnombresubtarea;
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
    @Size(max = 40)
    @Column(name = "DGJUSTIFICACION")
    private String dgjustificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BLRECHAZO")
    private short blrechazo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BLVIGENTE")
    private short blvigente;
    @JoinColumn(name = "IDRESPONSABLESUBTAREA_USUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario idresponsablesubtareaUsuario;
    @JoinColumn(name = "IDTAREA_SUBTAREA", referencedColumnName = "IDTAREA")
    @ManyToOne(optional = false)
    private Tarea idtareaSubtarea;
    @JoinColumn(name = "IDSEMAFORO_SUBTAREA", referencedColumnName = "IDSEMAFORO")
    @ManyToOne(optional = false)
    private Semaforo idsemaforoSubtarea;

    public Subtarea() {
    }

    public Subtarea(Long idsubtarea) {
        this.idsubtarea = idsubtarea;
    }

    public Subtarea(Long idsubtarea, String dgnombresubtarea, Date dcfechacreacion, short blrechazo, short blvigente) {
        this.idsubtarea = idsubtarea;
        this.dgnombresubtarea = dgnombresubtarea;
        this.dcfechacreacion = dcfechacreacion;
        this.blrechazo = blrechazo;
        this.blvigente = blvigente;
    }

    public Long getIdsubtarea() {
        return idsubtarea;
    }

    public void setIdsubtarea(Long idsubtarea) {
        this.idsubtarea = idsubtarea;
    }

    public String getDgnombresubtarea() {
        return dgnombresubtarea;
    }

    public void setDgnombresubtarea(String dgnombresubtarea) {
        this.dgnombresubtarea = dgnombresubtarea;
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

    public short getBlrechazo() {
        return blrechazo;
    }

    public void setBlrechazo(short blrechazo) {
        this.blrechazo = blrechazo;
    }

    public short getBlvigente() {
        return blvigente;
    }

    public void setBlvigente(short blvigente) {
        this.blvigente = blvigente;
    }

    public Usuario getIdresponsablesubtareaUsuario() {
        return idresponsablesubtareaUsuario;
    }

    public void setIdresponsablesubtareaUsuario(Usuario idresponsablesubtareaUsuario) {
        this.idresponsablesubtareaUsuario = idresponsablesubtareaUsuario;
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
