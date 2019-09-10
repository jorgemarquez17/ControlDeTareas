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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "RESPONSABLETAREA")
@NamedQueries({
    @NamedQuery(name = "Responsabletarea.findAll", query = "SELECT r FROM Responsabletarea r"),
    @NamedQuery(name = "Responsabletarea.findByIdresponsabletarea", query = "SELECT r FROM Responsabletarea r WHERE r.idresponsabletarea = :idresponsabletarea"),
    @NamedQuery(name = "Responsabletarea.findByBlasignado", query = "SELECT r FROM Responsabletarea r WHERE r.blasignado = :blasignado"),
    @NamedQuery(name = "Responsabletarea.findByBlvigente", query = "SELECT r FROM Responsabletarea r WHERE r.blvigente = :blvigente"),
    @NamedQuery(name = "Responsabletarea.findByDcnivelresponsable", query = "SELECT r FROM Responsabletarea r WHERE r.dcnivelresponsable = :dcnivelresponsable"),
    @NamedQuery(name = "Responsabletarea.findByDgapellidoresponsable", query = "SELECT r FROM Responsabletarea r WHERE r.dgapellidoresponsable = :dgapellidoresponsable"),
    @NamedQuery(name = "Responsabletarea.findByDgcontactoresponsable", query = "SELECT r FROM Responsabletarea r WHERE r.dgcontactoresponsable = :dgcontactoresponsable"),
    @NamedQuery(name = "Responsabletarea.findByDgcorreoresponsable", query = "SELECT r FROM Responsabletarea r WHERE r.dgcorreoresponsable = :dgcorreoresponsable"),
    @NamedQuery(name = "Responsabletarea.findByDgnombreresponsable", query = "SELECT r FROM Responsabletarea r WHERE r.dgnombreresponsable = :dgnombreresponsable")})
public class Responsabletarea implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDRESPONSABLETAREA")
    private BigDecimal idresponsabletarea;
    @Column(name = "BLASIGNADO")
    private Character blasignado;
    @Column(name = "BLVIGENTE")
    private Character blvigente;
    @Column(name = "DCNIVELRESPONSABLE")
    private BigInteger dcnivelresponsable;
    @Size(max = 255)
    @Column(name = "DGAPELLIDORESPONSABLE")
    private String dgapellidoresponsable;
    @Size(max = 255)
    @Column(name = "DGCONTACTORESPONSABLE")
    private String dgcontactoresponsable;
    @Size(max = 255)
    @Column(name = "DGCORREORESPONSABLE")
    private String dgcorreoresponsable;
    @Size(max = 255)
    @Column(name = "DGNOMBRERESPONSABLE")
    private String dgnombreresponsable;
    @JoinColumn(name = "IDTIPOROL_RESPONSABLETAREA", referencedColumnName = "IDTIPOROL")
    @ManyToOne
    private Tiporol idtiporolResponsabletarea;
    @OneToMany(mappedBy = "idresponsabletareaTarea")
    private Collection<Tarea> tareaCollection;

    public Responsabletarea() {
    }

    public Responsabletarea(BigDecimal idresponsabletarea) {
        this.idresponsabletarea = idresponsabletarea;
    }

    public BigDecimal getIdresponsabletarea() {
        return idresponsabletarea;
    }

    public void setIdresponsabletarea(BigDecimal idresponsabletarea) {
        this.idresponsabletarea = idresponsabletarea;
    }

    public Character getBlasignado() {
        return blasignado;
    }

    public void setBlasignado(Character blasignado) {
        this.blasignado = blasignado;
    }

    public Character getBlvigente() {
        return blvigente;
    }

    public void setBlvigente(Character blvigente) {
        this.blvigente = blvigente;
    }

    public BigInteger getDcnivelresponsable() {
        return dcnivelresponsable;
    }

    public void setDcnivelresponsable(BigInteger dcnivelresponsable) {
        this.dcnivelresponsable = dcnivelresponsable;
    }

    public String getDgapellidoresponsable() {
        return dgapellidoresponsable;
    }

    public void setDgapellidoresponsable(String dgapellidoresponsable) {
        this.dgapellidoresponsable = dgapellidoresponsable;
    }

    public String getDgcontactoresponsable() {
        return dgcontactoresponsable;
    }

    public void setDgcontactoresponsable(String dgcontactoresponsable) {
        this.dgcontactoresponsable = dgcontactoresponsable;
    }

    public String getDgcorreoresponsable() {
        return dgcorreoresponsable;
    }

    public void setDgcorreoresponsable(String dgcorreoresponsable) {
        this.dgcorreoresponsable = dgcorreoresponsable;
    }

    public String getDgnombreresponsable() {
        return dgnombreresponsable;
    }

    public void setDgnombreresponsable(String dgnombreresponsable) {
        this.dgnombreresponsable = dgnombreresponsable;
    }

    public Tiporol getIdtiporolResponsabletarea() {
        return idtiporolResponsabletarea;
    }

    public void setIdtiporolResponsabletarea(Tiporol idtiporolResponsabletarea) {
        this.idtiporolResponsabletarea = idtiporolResponsabletarea;
    }

    public Collection<Tarea> getTareaCollection() {
        return tareaCollection;
    }

    public void setTareaCollection(Collection<Tarea> tareaCollection) {
        this.tareaCollection = tareaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresponsabletarea != null ? idresponsabletarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsabletarea)) {
            return false;
        }
        Responsabletarea other = (Responsabletarea) object;
        if ((this.idresponsabletarea == null && other.idresponsabletarea != null) || (this.idresponsabletarea != null && !this.idresponsabletarea.equals(other.idresponsabletarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.processtask.entity.Responsabletarea[ idresponsabletarea=" + idresponsabletarea + " ]";
    }
    
}
