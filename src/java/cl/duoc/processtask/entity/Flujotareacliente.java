/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "FLUJOTAREACLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flujotareacliente.findAll", query = "SELECT f FROM Flujotareacliente f"),
    @NamedQuery(name = "Flujotareacliente.findByIdflujotareacliente", query = "SELECT f FROM Flujotareacliente f WHERE f.idflujotareacliente = :idflujotareacliente"),
    @NamedQuery(name = "Flujotareacliente.findByDgtipofujo", query = "SELECT f FROM Flujotareacliente f WHERE f.dgtipofujo = :dgtipofujo"),
    @NamedQuery(name = "Flujotareacliente.findByDccantidadcolumna", query = "SELECT f FROM Flujotareacliente f WHERE f.dccantidadcolumna = :dccantidadcolumna"),
    @NamedQuery(name = "Flujotareacliente.findByBlvigente", query = "SELECT f FROM Flujotareacliente f WHERE f.blvigente = :blvigente")})
public class Flujotareacliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFLUJOTAREACLIENTE")
    private Long idflujotareacliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "DGTIPOFUJO")
    private String dgtipofujo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DCCANTIDADCOLUMNA")
    private long dccantidadcolumna;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BLVIGENTE")
    private short blvigente;
    @JoinColumn(name = "IDFLUJOTAREA_FLUJOTAREACLIENTE", referencedColumnName = "IDFLUJOTAREA")
    @ManyToOne(optional = false)
    private Flujotarea idflujotareaFlujotareacliente;
    @JoinColumn(name = "IDCLIENTE_FLUJOTAREACLIENTE", referencedColumnName = "IDCLIENTE")
    @ManyToOne(optional = false)
    private Cliente idclienteFlujotareacliente;

    public Flujotareacliente() {
    }

    public Flujotareacliente(Long idflujotareacliente) {
        this.idflujotareacliente = idflujotareacliente;
    }

    public Flujotareacliente(Long idflujotareacliente, String dgtipofujo, long dccantidadcolumna, short blvigente) {
        this.idflujotareacliente = idflujotareacliente;
        this.dgtipofujo = dgtipofujo;
        this.dccantidadcolumna = dccantidadcolumna;
        this.blvigente = blvigente;
    }

    public Long getIdflujotareacliente() {
        return idflujotareacliente;
    }

    public void setIdflujotareacliente(Long idflujotareacliente) {
        this.idflujotareacliente = idflujotareacliente;
    }

    public String getDgtipofujo() {
        return dgtipofujo;
    }

    public void setDgtipofujo(String dgtipofujo) {
        this.dgtipofujo = dgtipofujo;
    }

    public long getDccantidadcolumna() {
        return dccantidadcolumna;
    }

    public void setDccantidadcolumna(long dccantidadcolumna) {
        this.dccantidadcolumna = dccantidadcolumna;
    }

    public short getBlvigente() {
        return blvigente;
    }

    public void setBlvigente(short blvigente) {
        this.blvigente = blvigente;
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
