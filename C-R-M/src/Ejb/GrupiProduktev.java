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
@Table(name = "Grupi_Produktev")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupiProduktev.findAll", query = "SELECT g FROM GrupiProduktev g"),
    @NamedQuery(name = "GrupiProduktev.findByGid", query = "SELECT g FROM GrupiProduktev g WHERE g.gid = :gid"),
    @NamedQuery(name = "GrupiProduktev.findByPershkrimi", query = "SELECT g FROM GrupiProduktev g WHERE g.pershkrimi = :pershkrimi")})
public class GrupiProduktev implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "G_id")
    @GeneratedValue(generator="GKid")
    @SequenceGenerator(name="GKid",sequenceName="GK_Id", allocationSize=1)
    private Integer gid;
    @Basic(optional = false)
    @Column(name = "Pershkrimi")
    private String pershkrimi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gid")
    private Collection<Produkti> produktiCollection;

    public GrupiProduktev() {
    }

    public GrupiProduktev(Integer gid) {
        this.gid = gid;
    }

    public GrupiProduktev(Integer gid, String pershkrimi) {
        this.gid = gid;
        this.pershkrimi = pershkrimi;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getPershkrimi() {
        return pershkrimi;
    }

    public void setPershkrimi(String pershkrimi) {
        this.pershkrimi = pershkrimi;
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
        hash += (gid != null ? gid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupiProduktev)) {
            return false;
        }
        GrupiProduktev other = (GrupiProduktev) object;
        if ((this.gid == null && other.gid != null) || (this.gid != null && !this.gid.equals(other.gid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pershkrimi;
    }
    
}
