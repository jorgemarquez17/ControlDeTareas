/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "SEMAFORO")
@NamedQueries({
    @NamedQuery(name = "Semaforo.findAll", query = "SELECT s FROM Semaforo s"),
    @NamedQuery(name = "Semaforo.findByIdsemaforo", query = "SELECT s FROM Semaforo s WHERE s.idsemaforo = :idsemaforo"),
    @NamedQuery(name = "Semaforo.findByBlvigente", query = "SELECT s FROM Semaforo s WHERE s.blvigente = :blvigente"),
    @NamedQuery(name = "Semaforo.findByDcporcentaje", query = "SELECT s FROM Semaforo s WHERE s.dcporcentaje = :dcporcentaje"),
    @NamedQuery(name = "Semaforo.findByDgnombresemaforo", query = "SELECT s FROM Semaforo s WHERE s.dgnombresemaforo = :dgnombresemaforo")})
public class Semaforo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSEMAFORO")
    private BigDecimal idsemaforo;
    @Column(name = "BLVIGENTE")
    private Character blvigente;
    @Column(name = "DCPORCENTAJE")
    private BigInteger dcporcentaje;
    @Size(max = 255)
    @Column(name = "DGNOMBRESEMAFORO")
    private String dgnombresemaforo;
    @OneToMany(mappedBy = "idsemaforoSubtarea")
    private Collection<Subtarea> subtareaCollection;

    public Semaforo() {
    }

    public Semaforo(BigDecimal idsemaforo) {
        this.idsemaforo = idsemaforo;
    }

    public BigDecimal getIdsemaforo() {
        return idsemaforo;
    }

    public void setIdsemaforo(BigDecimal idsemaforo) {
        this.idsemaforo = idsemaforo;
    }

    public Character getBlvigente() {
        return blvigente;
    }

    public void setBlvigente(Character blvigente) {
        this.blvigente = blvigente;
    }

    public BigInteger getDcporcentaje() {
        return dcporcentaje;
    }

    public void setDcporcentaje(BigInteger dcporcentaje) {
        this.dcporcentaje = dcporcentaje;
    }

    public String getDgnombresemaforo() {
        return dgnombresemaforo;
    }

    public void setDgnombresemaforo(String dgnombresemaforo) {
        this.dgnombresemaforo = dgnombresemaforo;
    }

    public Collection<Subtarea> getSubtareaCollection() {
        return subtareaCollection;
    }

    public void setSubtareaCollection(Collection<Subtarea> subtareaCollection) {
        this.subtareaCollection = subtareaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsemaforo != null ? idsemaforo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Semaforo)) {
            return false;
        }
        Semaforo other = (Semaforo) object;
        if ((this.idsemaforo == null && other.idsemaforo != null) || (this.idsemaforo != null && !this.idsemaforo.equals(other.idsemaforo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.processtask.entity.Semaforo[ idsemaforo=" + idsemaforo + " ]";
    }
    
}
