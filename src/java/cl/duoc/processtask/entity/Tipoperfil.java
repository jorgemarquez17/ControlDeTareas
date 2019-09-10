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
import javax.persistence.Id;
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
@Table(name = "TIPOPERFIL")
@NamedQueries({
    @NamedQuery(name = "Tipoperfil.findAll", query = "SELECT t FROM Tipoperfil t"),
    @NamedQuery(name = "Tipoperfil.findByIdtipoperfil", query = "SELECT t FROM Tipoperfil t WHERE t.idtipoperfil = :idtipoperfil"),
    @NamedQuery(name = "Tipoperfil.findByBlvigente", query = "SELECT t FROM Tipoperfil t WHERE t.blvigente = :blvigente"),
    @NamedQuery(name = "Tipoperfil.findByDgnombretipoperfil", query = "SELECT t FROM Tipoperfil t WHERE t.dgnombretipoperfil = :dgnombretipoperfil")})
public class Tipoperfil implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTIPOPERFIL")
    private BigDecimal idtipoperfil;
    @Column(name = "BLVIGENTE")
    private Character blvigente;
    @Size(max = 255)
    @Column(name = "DGNOMBRETIPOPERFIL")
    private String dgnombretipoperfil;
    @OneToMany(mappedBy = "idtipoperfilUsuario")
    private Collection<Usuario> usuarioCollection;

    public Tipoperfil() {
    }

    public Tipoperfil(BigDecimal idtipoperfil) {
        this.idtipoperfil = idtipoperfil;
    }

    public BigDecimal getIdtipoperfil() {
        return idtipoperfil;
    }

    public void setIdtipoperfil(BigDecimal idtipoperfil) {
        this.idtipoperfil = idtipoperfil;
    }

    public Character getBlvigente() {
        return blvigente;
    }

    public void setBlvigente(Character blvigente) {
        this.blvigente = blvigente;
    }

    public String getDgnombretipoperfil() {
        return dgnombretipoperfil;
    }

    public void setDgnombretipoperfil(String dgnombretipoperfil) {
        this.dgnombretipoperfil = dgnombretipoperfil;
    }

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
