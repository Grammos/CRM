/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejb;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gramos
 */
@Entity
@Table(name = "Qmimorja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Qmimorja.findAll", query = "SELECT q FROM Qmimorja q"),
    @NamedQuery(name = "Qmimorja.findByQmimorjaid", query = "SELECT q FROM Qmimorja q WHERE q.qmimorjaid = :qmimorjaid"),
    @NamedQuery(name = "Qmimorja.findByEmri", query = "SELECT q FROM Qmimorja q WHERE q.emri = :emri"),
    @NamedQuery(name = "Qmimorja.findByQmimi", query = "SELECT q FROM Qmimorja q WHERE q.qmimi = :qmimi")})
public class Qmimorja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Qmimorja_id")
    @GeneratedValue(generator="Qid")
    @SequenceGenerator(name="Qid",sequenceName="Q_Id", allocationSize=1)
    private Integer qmimorjaid;
    @Basic(optional = false)
    @Column(name = "Emri")
    private String emri;
    @Basic(optional = false)
    @Column(name = "Qmimi")
    private long qmimi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qmimorjaid")
    private Collection<Produkti> produktiCollection;

    public Qmimorja() {
    }

    public Qmimorja(Integer qmimorjaid) {
        this.qmimorjaid = qmimorjaid;
    }

    public Qmimorja(Integer qmimorjaid, String emri, long qmimi) {
        this.qmimorjaid = qmimorjaid;
        this.emri = emri;
        this.qmimi = qmimi;
    }

    public Integer getQmimorjaid() {
        return qmimorjaid;
    }

    public void setQmimorjaid(Integer qmimorjaid) {
        this.qmimorjaid = qmimorjaid;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public long getQmimi() {
        return qmimi;
    }

    public void setQmimi(long qmimi) {
        this.qmimi = qmimi;
    }

    @XmlTransient
    public Collection<Produkti> getProduktiCollection() {
        return produktiCollection;
    }

    public void setProduktiCollection(Collection<Produkti> produktiCollection) {
        this.produktiCollection = produktiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (qmimorjaid != null ? qmimorjaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Qmimorja)) {
            return false;
        }
        Qmimorja other = (Qmimorja) object;
        if ((this.qmimorjaid == null && other.qmimorjaid != null) || (this.qmimorjaid != null && !this.qmimorjaid.equals(other.qmimorjaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emri;
    }
    
}
