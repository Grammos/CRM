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
@Table(name = "Oferta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o"),
    @NamedQuery(name = "Oferta.findByOfertaid", query = "SELECT o FROM Oferta o WHERE o.ofertaid = :ofertaid"),
    @NamedQuery(name = "Oferta.findByOfertaEmri", query = "SELECT o FROM Oferta o WHERE o.ofertaEmri = :ofertaEmri"),
    @NamedQuery(name = "Oferta.findByQmimiOfertues", query = "SELECT o FROM Oferta o WHERE o.qmimiOfertues = :qmimiOfertues")})
public class Oferta implements Serializable {
    @OneToMany(mappedBy = "oferta")
    private Collection<Klienti> klientiCollection;
    @OneToMany(mappedBy = "ofertaid")
    private Collection<OpenLead> openLeadCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Oferta_id")
    @GeneratedValue(generator="Oid")
    @SequenceGenerator(name="Oid",sequenceName="O_Id", allocationSize=1)
    private Integer ofertaid;
    @Basic(optional = false)
    @Column(name = "Oferta_Emri")
    private String ofertaEmri;
    @Basic(optional = false)
    @Column(name = "QmimiOfertues")
    private long qmimiOfertues;
    @JoinColumn(name = "P_id", referencedColumnName = "P_id")
    @ManyToOne(optional = false)
    private Produkti pid;
    @JoinColumn(name = "M_id", referencedColumnName = "M_id")
    @ManyToOne(optional = false)
    private Marketing mid;
    @JoinColumn(name = "Klienti_id", referencedColumnName = "Klienti_id")
    @ManyToOne(optional = false)
    private Klienti klientiid;

    public Oferta() {
    }

    public Oferta(Integer ofertaid) {
        this.ofertaid = ofertaid;
    }

    public Oferta(Integer ofertaid, String ofertaEmri, long qmimiOfertues) {
        this.ofertaid = ofertaid;
        this.ofertaEmri = ofertaEmri;
        this.qmimiOfertues = qmimiOfertues;
    }

    public Integer getOfertaid() {
        return ofertaid;
    }

    public void setOfertaid(Integer ofertaid) {
        this.ofertaid = ofertaid;
    }

    public String getOfertaEmri() {
        return ofertaEmri;
    }

    public void setOfertaEmri(String ofertaEmri) {
        this.ofertaEmri = ofertaEmri;
    }

    public long getQmimiOfertues() {
        return qmimiOfertues;
    }

    public void setQmimiOfertues(long qmimiOfertues) {
        this.qmimiOfertues = qmimiOfertues;
    }

    public Produkti getPid() {
        return pid;
    }

    public void setPid(Produkti pid) {
        this.pid = pid;
    }

    public Marketing getMid() {
        return mid;
    }

    public void setMid(Marketing mid) {
        this.mid = mid;
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
        hash += (ofertaid != null ? ofertaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.ofertaid == null && other.ofertaid != null) || (this.ofertaid != null && !this.ofertaid.equals(other.ofertaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ofertaEmri;
    }

    @XmlTransient
    public Collection<OpenLead> getOpenLeadCollection() {
        return openLeadCollection;
    }

    public void setOpenLeadCollection(Collection<OpenLead> openLeadCollection) {
        this.openLeadCollection = openLeadCollection;
    }

    @XmlTransient
    public Collection<Klienti> getKlientiCollection() {
        return klientiCollection;
    }

    public void setKlientiCollection(Collection<Klienti> klientiCollection) {
        this.klientiCollection = klientiCollection;
    }
    
}
