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
@Table(name = "Departamenti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamenti.findAll", query = "SELECT d FROM Departamenti d"),
    @NamedQuery(name = "Departamenti.findByDId", query = "SELECT d FROM Departamenti d WHERE d.dId = :dId"),
    @NamedQuery(name = "Departamenti.findByDEmri", query = "SELECT d FROM Departamenti d WHERE d.dEmri = :dEmri")})
public class Departamenti implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "did")
    private Collection<Punetori> punetoriCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentiid")
    private Collection<Marketing> marketingCollection;
   
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "D_ID")
    @GeneratedValue(generator="Did")
    @SequenceGenerator(name="Did",sequenceName="D_Id", allocationSize=1)
    private Integer dId;
    @Basic(optional = false)
    @Column(name = "D_Emri")
    private String dEmri;

    public Departamenti() {
    }

    public Departamenti(Integer dId) {
        this.dId = dId;
    }

    public Departamenti(Integer dId, String dEmri) {
        this.dId = dId;
        this.dEmri = dEmri;
    }

    public Integer getDId() {
        return dId;
    }

    public void setDId(Integer dId) {
        this.dId = dId;
    }

    public String getDEmri() {
        return dEmri;
    }

    public void setDEmri(String dEmri) {
        this.dEmri = dEmri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dId != null ? dId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamenti)) {
            return false;
        }
        Departamenti other = (Departamenti) object;
        if ((this.dId == null && other.dId != null) || (this.dId != null && !this.dId.equals(other.dId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return dEmri;
    }

    

    @XmlTransient
    public Collection<Marketing> getMarketingCollection() {
        return marketingCollection;
    }

    public void setMarketingCollection(Collection<Marketing> marketingCollection) {
        this.marketingCollection = marketingCollection;
    }

    @XmlTransient
    public Collection<Punetori> getPunetoriCollection() {
        return punetoriCollection;
    }

    public void setPunetoriCollection(Collection<Punetori> punetoriCollection) {
        this.punetoriCollection = punetoriCollection;
    }
    
}
