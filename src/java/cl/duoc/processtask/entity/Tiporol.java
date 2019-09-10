/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "TIPOROL")
@NamedQueries({
    @NamedQuery(name = "Tiporol.findAll", query = "SELECT t FROM Tiporol t"),
    @NamedQuery(name = "Tiporol.findByIdtiporol", query = "SELECT t FROM Tiporol t WHERE t.idtiporol = :idtiporol"),
    @NamedQuery(name = "Tiporol.findByBlvigente", query = "SELECT t FROM Tiporol t WHERE t.blvigente = :blvigente"),
    @NamedQuery(name = "Tiporol.findByDgnombretiporol", query = "SELECT t FROM Tiporol t WHERE t.dgnombretiporol = :dgnombretiporol")})
public class Tiporol implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "TIPOROL_SEQ")
    @SequenceGenerator(sequenceName = "TIPOROL_SEQUENCE",allocationSize = 1,name = "TIPOROL_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTIPOROL")
    private BigDecimal idtiporol;
    @Column(name = "BLVIGENTE")
    private Character blvigente;
    @Size(max = 255)
    @Column(name = "DGNOMBRETIPOROL")
    private String dgnombretiporol;
    @OneToMany(mappedBy = "idtiporolResponsabletarea")
    private Collection<Responsabletarea> responsabletareaCollection;

    public Tiporol() {
    }

    public Tiporol(BigDecimal idtiporol) {
        this.idtiporol = idtiporol;
    }

    public BigDecimal getIdtiporol() {
        return idtiporol;
    }

    public void setIdtiporol(BigDecimal idtiporol) {
        this.idtiporol = idtiporol;
    }

    public Character getBlvigente() {
        return blvigente;
    }

    public void setBlvigente(Character blvigente) {
        this.blvigente = blvigente;
    }

    public String getDgnombretiporol() {
        return dgnombretiporol;
    }

    public void setDgnombretiporol(String dgnombretiporol) {
        this.dgnombretiporol = dgnombretiporol;
    }

    public Collection<Responsabletarea> getResponsabletareaCollection() {
        return responsabletareaCollection;
    }

    public void setResponsabletareaCollection(Collection<Responsabletarea> responsabletareaCollection) {
        this.responsabletareaCollection = responsabletareaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtiporol != null ? idtiporol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiporol)) {
            return false;
        }
        Tiporol other = (Tiporol) object;
        if ((this.idtiporol == null && other.idtiporol != null) || (this.idtiporol != null && !this.idtiporol.equals(other.idtiporol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.processtask.entity.Tiporol[ idtiporol=" + idtiporol + " ]";
    }
    
}
