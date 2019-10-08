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
@Table(name = "TIPOPERFIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoperfil.findAll", query = "SELECT t FROM Tipoperfil t"),
    @NamedQuery(name = "Tipoperfil.findByIdtipoperfil", query = "SELECT t FROM Tipoperfil t WHERE t.idtipoperfil = :idtipoperfil"),
    @NamedQuery(name = "Tipoperfil.findByDgnombretipoperfil", query = "SELECT t FROM Tipoperfil t WHERE t.dgnombretipoperfil = :dgnombretipoperfil"),
    @NamedQuery(name = "Tipoperfil.findByBlvigente", query = "SELECT t FROM Tipoperfil t WHERE t.blvigente = :blvigente")})
public class Tipoperfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTIPOPERFIL")
    private Long idtipoperfil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "DGNOMBRETIPOPERFIL")
    private String dgnombretipoperfil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BLVIGENTE")
    private short blvigente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoperfilUsuario")
    private Collection<Usuario> usuarioCollection;

    public Tipoperfil() {
    }

    public Tipoperfil(Long idtipoperfil) {
        this.idtipoperfil = idtipoperfil;
    }

    public Tipoperfil(Long idtipoperfil, String dgnombretipoperfil, short blvigente) {
        this.idtipoperfil = idtipoperfil;
        this.dgnombretipoperfil = dgnombretipoperfil;
        this.blvigente = blvigente;
    }

    public Long getIdtipoperfil() {
        return idtipoperfil;
    }

    public void setIdtipoperfil(Long idtipoperfil) {
        this.idtipoperfil = idtipoperfil;
    }

    public String getDgnombretipoperfil() {
        return dgnombretipoperfil;
    }

    public void setDgnombretipoperfil(String dgnombretipoperfil) {
        this.dgnombretipoperfil = dgnombretipoperfil;
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
        hash += (idtipoperfil != null ? idtipoperfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoperfil)) {
            return false;
        }
        Tipoperfil other = (Tipoperfil) object;
        if ((this.idtipoperfil == null && other.idtipoperfil != null) || (this.idtipoperfil != null && !this.idtipoperfil.equals(other.idtipoperfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.processtask.entity.Tipoperfil[ idtipoperfil=" + idtipoperfil + " ]";
    }
    
}
