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
@Table(name = "EMPRESA")
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByIdempresa", query = "SELECT e FROM Empresa e WHERE e.idempresa = :idempresa"),
    @NamedQuery(name = "Empresa.findByDgcontacto", query = "SELECT e FROM Empresa e WHERE e.dgcontacto = :dgcontacto"),
    @NamedQuery(name = "Empresa.findByDgcorreo", query = "SELECT e FROM Empresa e WHERE e.dgcorreo = :dgcorreo"),
    @NamedQuery(name = "Empresa.findByDgdireccion", query = "SELECT e FROM Empresa e WHERE e.dgdireccion = :dgdireccion"),
    @NamedQuery(name = "Empresa.findByDgrut", query = "SELECT e FROM Empresa e WHERE e.dgrut = :dgrut")})
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "EMPRESA_SEQ")
    @SequenceGenerator(sequenceName = "EMPRESA_SECUENCE",allocationSize = 1,name = "EMPRESA_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEMPRESA")
    private BigDecimal idempresa;
    @Size(max = 255)
    @Column(name = "DGCONTACTO")
    private String dgcontacto;
    @Size(max = 255)
    @Column(name = "DGCORREO")
    private String dgcorreo;
    @Size(max = 255)
    @Column(name = "DGDIRECCION")
    private String dgdireccion;
    @Size(max = 255)
    @Column(name = "DGRUT")
    private String dgrut;
    @OneToMany(mappedBy = "idempresaCliente")
    private Collection<Cliente> clienteCollection;

    public Empresa() {
    }

    public Empresa(BigDecimal idempresa) {
        this.idempresa = idempresa;
    }

    public BigDecimal getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(BigDecimal idempresa) {
        this.idempresa = idempresa;
    }

    public String getDgcontacto() {
        return dgcontacto;
    }

    public void setDgcontacto(String dgcontacto) {
        this.dgcontacto = dgcontacto;
    }

    public String getDgcorreo() {
        return dgcorreo;
    }

    public void setDgcorreo(String dgcorreo) {
        this.dgcorreo = dgcorreo;
    }

    public String getDgdireccion() {
        return dgdireccion;
    }

    public void setDgdireccion(String dgdireccion) {
        this.dgdireccion = dgdireccion;
    }

    public String getDgrut() {
        return dgrut;
    }

    public void setDgrut(String dgrut) {
        this.dgrut = dgrut;
    }

    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempresa != null ? idempresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idempresa == null && other.idempresa != null) || (this.idempresa != null && !this.idempresa.equals(other.idempresa))) {
            return false;
        }
        return true;
    }

//    }

//    @Override
//    public String toString() {
//        return "cl.duoc.processtask.entity.Empresa[ idempresa=" + idempresa + " ]";
    @Override
    public String toString() {
        return "Empresa{" + "idempresa=" + idempresa + ", dgcontacto=" + dgcontacto + ", dgcorreo=" + dgcorreo + ", dgdireccion=" + dgdireccion + ", dgrut=" + dgrut + ", clienteCollection=" + clienteCollection + '}';
    }
    
}
