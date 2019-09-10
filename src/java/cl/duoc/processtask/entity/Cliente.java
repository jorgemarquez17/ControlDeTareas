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
@Table(name = "CLIENTE")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdcliente", query = "SELECT c FROM Cliente c WHERE c.idcliente = :idcliente"),
    @NamedQuery(name = "Cliente.findByBlvigente", query = "SELECT c FROM Cliente c WHERE c.blvigente = :blvigente"),
    @NamedQuery(name = "Cliente.findByDgapellido", query = "SELECT c FROM Cliente c WHERE c.dgapellido = :dgapellido"),
    @NamedQuery(name = "Cliente.findByDgcontacto", query = "SELECT c FROM Cliente c WHERE c.dgcontacto = :dgcontacto"),
    @NamedQuery(name = "Cliente.findByDgcorreo", query = "SELECT c FROM Cliente c WHERE c.dgcorreo = :dgcorreo"),
    @NamedQuery(name = "Cliente.findByDgnombre", query = "SELECT c FROM Cliente c WHERE c.dgnombre = :dgnombre")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCLIENTE")
    private BigDecimal idcliente;
    @Column(name = "BLVIGENTE")
    private Character blvigente;
    @Size(max = 255)
    @Column(name = "DGAPELLIDO")
    private String dgapellido;
    @Size(max = 255)
    @Column(name = "DGCONTACTO")
    private String dgcontacto;
    @Size(max = 255)
    @Column(name = "DGCORREO")
    private String dgcorreo;
    @Size(max = 255)
    @Column(name = "DGNOMBRE")
    private String dgnombre;
    @JoinColumn(name = "IDEMPRESA_CLIENTE", referencedColumnName = "IDEMPRESA")
    @ManyToOne
    private Empresa idempresaCliente;
    @OneToMany(mappedBy = "idclienteFlujotareacliente")
    private Collection<Flujotareacliente> flujotareaclienteCollection;

    public Cliente() {
    }

    public Cliente(BigDecimal idcliente) {
        this.idcliente = idcliente;
    }

    public BigDecimal getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(BigDecimal idcliente) {
        this.idcliente = idcliente;
    }

    public Character getBlvigente() {
        return blvigente;
    }

    public void setBlvigente(Character blvigente) {
        this.blvigente = blvigente;
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

    public String getDgnombre() {
        return dgnombre;
    }

    public void setDgnombre(String dgnombre) {
        this.dgnombre = dgnombre;
    }

    public Empresa getIdempresaCliente() {
        return idempresaCliente;
    }

    public void setIdempresaCliente(Empresa idempresaCliente) {
        this.idempresaCliente = idempresaCliente;
    }

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
