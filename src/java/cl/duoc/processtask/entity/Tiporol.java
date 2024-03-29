/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "TIPOROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiporol.findAll", query = "SELECT t FROM Tiporol t"),
    @NamedQuery(name = "Tiporol.findByIdtiporol", query = "SELECT t FROM Tiporol t WHERE t.idtiporol = :idtiporol"),
    @NamedQuery(name = "Tiporol.findByDgnombretiporol", query = "SELECT t FROM Tiporol t WHERE t.dgnombretiporol = :dgnombretiporol"),
    @NamedQuery(name = "Tiporol.findByBlvigente", query = "SELECT t FROM Tiporol t WHERE t.blvigente = :blvigente")})
public class Tiporol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTIPOROL")
    private Long idtiporol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "DGNOMBRETIPOROL")
    private String dgnombretiporol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BLVIGENTE")
    private short blvigente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtiporolUsuario")
    private Collection<Usuario> usuarioCollection;

    public Tiporol() {
    }

    public Tiporol(Long idtiporol) {
        this.idtiporol = idtiporol;
    }

    public Tiporol(Long idtiporol, String dgnombretiporol, short blvigente) {
        this.idtiporol = idtiporol;
        this.dgnombretiporol = dgnombretiporol;
        this.blvigente = blvigente;
    }

    public Long getIdtiporol() {
        return idtiporol;
    }

    public void setIdtiporol(Long idtiporol) {
        this.idtiporol = idtiporol;
    }

    public String getDgnombretiporol() {
        return dgnombretiporol;
    }

    public void setDgnombretiporol(String dgnombretiporol) {
        this.dgnombretiporol = dgnombretiporol;
    }

    public short getBlvigente() {
        return blvigente;
    }

    public void setBlvigente(short blvigente) {
        this.blvigente = blvigente;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
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
