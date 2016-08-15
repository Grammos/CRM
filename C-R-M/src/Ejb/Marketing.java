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
@Table(name = "Marketing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marketing.findAll", query = "SELECT m FROM Marketing m"),
    @NamedQuery(name = "Marketing.findByMid", query = "SELECT m FROM Marketing m WHERE m.mid = :mid"),
    @NamedQuery(name = "Marketing.findByEmri", query = "SELECT m FROM Marketing m WHERE m.emri = :emri")})
public class Marketing implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mid")
    private Collection<Oferta> ofertaCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "M_id")
    @GeneratedValue(generator="Mid")
    @SequenceGenerator(name="Mid",sequenceName="M_Id", allocationSize=1)
    private Integer mid;
    @Basic(optional = false)
    @Column(name = "Emri")
    private String emri;
    @JoinColumn(name = "Departamenti_id", referencedColumnName = "D_ID")
    @ManyToOne(optional = false)
    private Departamenti departamentiid;

    public Marketing() {
    }

    public Marketing(Integer mid) {
        this.mid = mid;
    }

    public Marketing(Integer mid, String emri) {
        this.mid = mid;
        this.emri = emri;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public Departamenti getDepartamentiid() {
        return departamentiid;
    }

    public void setDepartamentiid(Departamenti departamentiid) {
        this.departamentiid = departamentiid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mid != null ? mid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marketing)) {
            return false;
        }
        Marketing other = (Marketing) object;
        if ((this.mid == null && other.mid != null) || (this.mid != null && !this.mid.equals(other.mid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emri;
    }

    @XmlTransient
    public Collection<Oferta> getOfertaCollection() {
        return ofertaCollection;
    }

    public void setOfertaCollection(Collection<Oferta> ofertaCollection) {
        this.ofertaCollection = ofertaCollection;
    }
    
}
