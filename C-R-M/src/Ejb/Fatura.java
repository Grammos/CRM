/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejb;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gramos
 */
@Entity
@Table(name = "Fatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fatura.findAll", query = "SELECT f FROM Fatura f"),
    @NamedQuery(name = "Fatura.findByFid", query = "SELECT f FROM Fatura f WHERE f.fid = :fid"),
    @NamedQuery(name = "Fatura.findByDatakoha", query = "SELECT f FROM Fatura f WHERE f.datakoha = :datakoha"),
    @NamedQuery(name = "Fatura.findByEpaguar", query = "SELECT f FROM Fatura f WHERE f.epaguar = :epaguar")})
public class Fatura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "F_id")
    private Integer fid;
    @Basic(optional = false)
    @Column(name = "Data_koha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datakoha;
    @Basic(optional = false)
    @Column(name = "Epaguar")
    private String epaguar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fid")
    private Collection<FaturaDetale> faturaDetaleCollection;
    @JoinColumn(name = "Klienti_id", referencedColumnName = "Klienti_id")
    @ManyToOne(optional = false)
    private Klienti klientiid;

    public Fatura() {
    }

    public Fatura(Integer fid) {
        this.fid = fid;
    }

    public Fatura(Integer fid, Date datakoha, String epaguar) {
        this.fid = fid;
        this.datakoha = datakoha;
        this.epaguar = epaguar;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Date getDatakoha() {
        return datakoha;
    }

    public void setDatakoha(Date datakoha) {
        this.datakoha = datakoha;
    }

    public String getEpaguar() {
        return epaguar;
    }

    public void setEpaguar(String epaguar) {
        this.epaguar = epaguar;
    }

    @XmlTransient
    public Collection<FaturaDetale> getFaturaDetaleCollection() {
        return faturaDetaleCollection;
    }

    public void setFaturaDetaleCollection(Collection<FaturaDetale> faturaDetaleCollection) {
        this.faturaDetaleCollection = faturaDetaleCollection;
    }

    public Klienti getKlientiid() {
        return klientiid;
    }

    public void setKlientiid(Klienti klientiid) {
        this.klientiid = klientiid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fid != null ? fid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fatura)) {
            return false;
        }
        Fatura other = (Fatura) object;
        if ((this.fid == null && other.fid != null) || (this.fid != null && !this.fid.equals(other.fid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ejb.Fatura[ fid=" + fid + " ]";
    }
    
}
