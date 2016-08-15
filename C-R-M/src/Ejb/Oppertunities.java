/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejb;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Oppertunities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oppertunities.findAll", query = "SELECT o FROM Oppertunities o"),
    @NamedQuery(name = "Oppertunities.findByOid", query = "SELECT o FROM Oppertunities o WHERE o.oid = :oid"),
    @NamedQuery(name = "Oppertunities.findByEmri", query = "SELECT o FROM Oppertunities o WHERE o.emri = :emri")})
public class Oppertunities implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "O_id")
    @GeneratedValue(generator="Oid")
    @SequenceGenerator(name="Oid",sequenceName="O_Id", allocationSize=1)
    private Integer oid;
    @Basic(optional = false)
    @Column(name = "Emri")
    private String emri;
    @OneToMany(mappedBy = "oid")
    private Collection<Klienti> klientiCollection;
    @JoinColumn(name = "Lead_id", referencedColumnName = "Lead_id")
    @ManyToOne(optional = false)
    private OpenLead leadid;

    public Oppertunities() {
    }

    public Oppertunities(Integer oid) {
        this.oid = oid;
    }

    public Oppertunities(Integer oid, String emri) {
        this.oid = oid;
        this.emri = emri;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    @XmlTransient
    public Collection<Klienti> getKlientiCollection() {
        return klientiCollection;
    }

    public void setKlientiCollection(Collection<Klienti> klientiCollection) {
        this.klientiCollection = klientiCollection;
    }

    public OpenLead getLeadid() {
        return leadid;
    }

    public void setLeadid(OpenLead leadid) {
        this.leadid = leadid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oppertunities)) {
            return false;
        }
        Oppertunities other = (Oppertunities) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emri;
    }
    
}
