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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdcliente", query = "SELECT c FROM Cliente c WHERE c.idcliente = :idcliente"),
    @NamedQuery(name = "Cliente.findByDgnombre", query = "SELECT c FROM Cliente c WHERE c.dgnombre = :dgnombre"),
    @NamedQuery(name = "Cliente.findByDgapellido", query = "SELECT c FROM Cliente c WHERE c.dgapellido = :dgapellido"),
    @NamedQuery(name = "Cliente.findByDgcontacto", query = "SELECT c FROM Cliente c WHERE c.dgcontacto = :dgcontacto"),
    @NamedQuery(name = "Cliente.findByDgcorreo", query = "SELECT c FROM Cliente c WHERE c.dgcorreo = :dgcorreo"),
    @NamedQuery(name = "Cliente.findByBlvigente", query = "SELECT c FROM Cliente c WHERE c.blvigente = :blvigente")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCLIENTE")
    private Long idcliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "DGNOMBRE")
    private String dgnombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "DGAPELLIDO")
    private String dgapellido;
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
    @JoinColumn(name = "IDEMPRESA_CLIENTE", referencedColumnName = "IDEMPRESA")
    @ManyToOne(optional = false)
    private Empresa idempresaCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclienteFlujotareacliente")
    private Collection<Flujotareacliente> flujotareaclienteCollection;

    public Cliente() {
    }

    public Cliente(Long idcliente) {
        this.idcliente = idcliente;
    }

    public Cliente(Long idcliente, String dgnombre, String dgapellido, String dgcontacto, String dgcorreo, short blvigente) {
        this.idcliente = idcliente;
        this.dgnombre = dgnombre;
        this.dgapellido = dgapellido;
        this.dgcontacto = dgcontacto;
        this.dgcorreo = dgcorreo;
        this.blvigente = blvigente;
    }

    public Long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Long idcliente) {
        this.idcliente = idcliente;
    }

    public String getDgnombre() {
        return dgnombre;
    }

    public void setDgnombre(String dgnombre) {
        this.dgnombre = dgnombre;
    }

    public String getDgapellido() {
        return dgapellido;
    }

    public void setDgapellido(String dgapellido) {
        this.dgapellido = dgapellido;
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

    public Empresa getIdempresaCliente() {
        return idempresaCliente;
    }

    public void setIdempresaCliente(Empresa idempresaCliente) {
        this.idempresaCliente = idempresaCliente;
    }

    @XmlTransient
    public Collection<Flujotareacliente> getFlujotareaclienteCollection() {
        return flujotareaclienteCollection;
    }

    public void setFlujotareaclienteCollection(Collection<Flujotareacliente> flujotareaclienteCollection) {
        this.flujotareaclienteCollection = flujotareaclienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.processtask.entity.Cliente[ idcliente=" + idcliente + " ]";
    }
    
}
