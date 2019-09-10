/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "FLUJOTAREACLIENTE")
@NamedQueries({
    @NamedQuery(name = "Flujotareacliente.findAll", query = "SELECT f FROM Flujotareacliente f"),
    @NamedQuery(name = "Flujotareacliente.findByIdflujotareacliente", query = "SELECT f FROM Flujotareacliente f WHERE f.idflujotareacliente = :idflujotareacliente"),
    @NamedQuery(name = "Flujotareacliente.findByBlvigente", query = "SELECT f FROM Flujotareacliente f WHERE f.blvigente = :blvigente"),
    @NamedQuery(name = "Flujotareacliente.findByDccantidadcolumna", query = "SELECT f FROM Flujotareacliente f WHERE f.dccantidadcolumna = :dccantidadcolumna"),
    @NamedQuery(name = "Flujotareacliente.findByDgtipofujo", query = "SELECT f FROM Flujotareacliente f WHERE f.dgtipofujo = :dgtipofujo")})
public class Flujotareacliente implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFLUJOTAREACLIENTE")
    private BigDecimal idflujotareacliente;
    @Column(name = "BLVIGENTE")
    private Character blvigente;
    @Column(name = "DCCANTIDADCOLUMNA")
    private BigInteger dccantidadcolumna;
    @Size(max = 255)
    @Column(name = "DGTIPOFUJO")
    private String dgtipofujo;
    @JoinColumn(name = "IDFLUJOTAREA_FLUJOTAREACLIENTE", referencedColumnName = "IDFLUJOTAREA")
    @ManyToOne
    private Flujotarea idflujotareaFlujotareacliente;
    @JoinColumn(name = "IDCLIENTE_FLUJOTAREACLIENTE", referencedColumnName = "IDCLIENTE")
    @ManyToOne
    private Cliente idclienteFlujotareacliente;

    public Flujotareacliente() {
    }

    public Flujotareacliente(BigDecimal idflujotareacliente) {
        this.idflujotareacliente = idflujotareacliente;
    }

    public BigDecimal getIdflujotareacliente() {
        return idflujotareacliente;
    }

    public void setIdflujotareacliente(BigDecimal idflujotareacliente) {
        this.idflujotareacliente = idflujotareacliente;
    }

    public Character getBlvigente() {
        return blvigente;
    }

    public void setBlvigente(Character blvigente) {
        this.blvigente = blvigente;
    }

    public BigInteger getDccantidadcolumna() {
        return dccantidadcolumna;
    }

    public void setDccantidadcolumna(BigInteger dccantidadcolumna) {
        this.dccantidadcolumna = dccantidadcolumna;
    }

    public String getDgtipofujo() {
        return dgtipofujo;
    }

    public void setDgtipofujo(String dgtipofujo) {
        this.dgtipofujo = dgtipofujo;
    }

    public Flujotarea getIdflujotareaFlujotareacliente() {
        return idflujotareaFlujotareacliente;
    }

    public void setIdflujotareaFlujotareacliente(Flujotarea idflujotareaFlujotareacliente) {
        this.idflujotareaFlujotareacliente = idflujotareaFlujotareacliente;
    }

    public Cliente getIdclienteFlujotareacliente() {
        return idclienteFlujotareacliente;
    }

    public void setIdclienteFlujotareacliente(Cliente idclienteFlujotareacliente) {
        this.idclienteFlujotareacliente = idclienteFlujotareacliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idflujotareacliente != null ? idflujotareacliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flujotareacliente)) {
            return false;
        }
        Flujotareacliente other = (Flujotareacliente) object;
        if ((this.idflujotareacliente == null && other.idflujotareacliente != null) || (this.idflujotareacliente != null && !this.idflujotareacliente.equals(other.idflujotareacliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.processtask.entity.Flujotareacliente[ idflujotareacliente=" + idflujotareacliente + " ]";
    }
    
}
