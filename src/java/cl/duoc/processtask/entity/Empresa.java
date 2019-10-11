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
@Table(name = "EMPRESA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByIdempresa", query = "SELECT e FROM Empresa e WHERE e.idempresa = :idempresa"),
    @NamedQuery(name = "Empresa.findByDgrut", query = "SELECT e FROM Empresa e WHERE e.dgrut = :dgrut"),
    @NamedQuery(name = "Empresa.findByDgdireccion", query = "SELECT e FROM Empresa e WHERE e.dgdireccion = :dgdireccion"),
    @NamedQuery(name = "Empresa.findByDgnombreempresa", query = "SELECT e FROM Empresa e WHERE e.dgnombreempresa = :dgnombreempresa"),
    @NamedQuery(name = "Empresa.findByDgcontacto", query = "SELECT e FROM Empresa e WHERE e.dgcontacto = :dgcontacto"),
    @NamedQuery(name = "Empresa.findByDgcorreo", query = "SELECT e FROM Empresa e WHERE e.dgcorreo = :dgcorreo"),
    @NamedQuery(name = "Empresa.findByBlvigente", query = "SELECT e FROM Empresa e WHERE e.blvigente = :blvigente")})
    
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEMPRESA")
    private Long idempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "DGRUT")
    private String dgrut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "DGDIRECCION")
    private String dgdireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "DGNOMBREEMPRESA")
    private String dgnombreempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "DGCONTACTO")
    private String dgcontacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "DGCORREO")
    private String dgcorreo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BLVIGENTE")
    private short blvigente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idempresaCliente")
    private Collection<Cliente> clienteCollection;

    public Empresa() {
    }

    public Empresa(Long idempresa) {
        this.idempresa = idempresa;
    }

    public Empresa(Long idempresa, String dgrut, String dgdireccion, String dgnombreempresa, String dgcontacto, String dgcorreo, short blvigente) {
        this.idempresa = idempresa;
        this.dgrut = dgrut;
        this.dgdireccion = dgdireccion;
        this.dgnombreempresa = dgnombreempresa;
        this.dgcontacto = dgcontacto;
        this.dgcorreo = dgcorreo;
        this.blvigente = blvigente;
    }

    public Long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }

    public String getDgrut() {
        return dgrut;
    }

    public void setDgrut(String dgrut) {
        this.dgrut = dgrut;
    }

    public String getDgdireccion() {
        return dgdireccion;
    }

    public void setDgdireccion(String dgdireccion) {
        this.dgdireccion = dgdireccion;
    }

    public String getDgnombreempresa() {
        return dgnombreempresa;
    }

    public void setDgnombreempresa(String dgnombreempresa) {
        this.dgnombreempresa = dgnombreempresa;
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

    public short getBlvigente() {
        return blvigente;
    }

    public void setBlvigente(short blvigente) {
        this.blvigente = blvigente;
    }

    @XmlTransient
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

    @Override
    public String toString() {
        return "Empresa id: "+idempresa+" direccion: "+dgdireccion+" nombreEmpresa: "+dgnombreempresa+" contacto: "+dgcontacto
                +" correo: "+dgcorreo+ " vigente: "+blvigente;
    }
    
}
