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
@Table(name = "Grupi_Klientav")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupiKlientav.findAll", query = "SELECT g FROM GrupiKlientav g"),
    @NamedQuery(name = "GrupiKlientav.findByGKid", query = "SELECT g FROM GrupiKlientav g WHERE g.gKid = :gKid"),
    @NamedQuery(name = "GrupiKlientav.findByPershkrimi", query = "SELECT g FROM GrupiKlientav g WHERE g.pershkrimi = :pershkrimi")})
public class GrupiKlientav implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "G_Kid")
    @GeneratedValue(generator="GKid")
    @SequenceGenerator(name="GKid",sequenceName="GK_Id", allocationSize=1)
    private Integer gKid;
    @Basic(optional = false)
    @Column(name = "Pershkrimi")
    private String pershkrimi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gKid")
    private Collection<Klienti> klientiCollection;

    public GrupiKlientav() {
    }

    public GrupiKlientav(Integer gKid) {
        this.gKid = gKid;
    }

    public GrupiKlientav(Integer gKid, String pershkrimi) {
        this.gKid = gKid;
        this.pershkrimi = pershkrimi;
    }

    public Integer getGKid() {
        return gKid;
    }

    public void setGKid(Integer gKid) {
        this.gKid = gKid;
    }

    public String getPershkrimi() {
        return pershkrimi;
    }

    public void setPershkrimi(String pershkrimi) {
        this.pershkrimi = pershkrimi;
    }

    @XmlTransient
    public Collection<Klienti> getKlientiCollection() {
        return klientiCollection;
    }

    public void setKlientiCollection(Collection<Klienti> klientiCollection) {
        this.klientiCollection = klientiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gKid != null ? gKid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupiKlientav)) {
            return false;
        }
        GrupiKlientav other = (GrupiKlientav) object;
        if ((this.gKid == null && other.gKid != null) || (this.gKid != null && !this.gKid.equals(other.gKid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pershkrimi;
    }
    
}
