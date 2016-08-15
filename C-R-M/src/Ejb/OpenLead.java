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
@Table(name = "OpenLead")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpenLead.findAll", query = "SELECT o FROM OpenLead o"),
    @NamedQuery(name = "OpenLead.findByLeadid", query = "SELECT o FROM OpenLead o WHERE o.leadid = :leadid"),
    @NamedQuery(name = "OpenLead.findByEmri", query = "SELECT o FROM OpenLead o WHERE o.emri = :emri"),
    @NamedQuery(name = "OpenLead.findByMbiemri", query = "SELECT o FROM OpenLead o WHERE o.mbiemri = :mbiemri"),
    @NamedQuery(name = "OpenLead.findByEmail", query = "SELECT o FROM OpenLead o WHERE o.email = :email"),
    @NamedQuery(name = "OpenLead.findByTelefoni", query = "SELECT o FROM OpenLead o WHERE o.telefoni = :telefoni"),
    @NamedQuery(name = "OpenLead.findByLeadStatus", query = "SELECT o FROM OpenLead o WHERE o.leadStatus = :leadStatus"),
    @NamedQuery(name = "OpenLead.findByKompania", query = "SELECT o FROM OpenLead o WHERE o.kompania = :kompania"),
    @NamedQuery(name = "OpenLead.findByShteti", query = "SELECT o FROM OpenLead o WHERE o.shteti = :shteti"),
    @NamedQuery(name = "OpenLead.findByRruga", query = "SELECT o FROM OpenLead o WHERE o.rruga = :rruga"),
    @NamedQuery(name = "OpenLead.findByQyteti", query = "SELECT o FROM OpenLead o WHERE o.qyteti = :qyteti"),
    @NamedQuery(name = "OpenLead.findByZipCode", query = "SELECT o FROM OpenLead o WHERE o.zipCode = :zipCode")})
public class OpenLead implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leadid")
    private Collection<Oppertunities> oppertunitiesCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Lead_id")
    @GeneratedValue(generator="Lid")
    @SequenceGenerator(name="Lid",sequenceName="L_Id", allocationSize=1)
    private Integer leadid;
    @Basic(optional = false)
    @Column(name = "Emri")
    private String emri;
    @Basic(optional = false)
    @Column(name = "Mbiemri")
    private String mbiemri;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "Telefoni")
    private long telefoni;
    @Basic(optional = false)
    @Column(name = "Lead_Status")
    private String leadStatus;
    @Basic(optional = false)
    @Column(name = "Kompania")
    private String kompania;
    @Basic(optional = false)
    @Column(name = "Shteti")
    private String shteti;
    @Basic(optional = false)
    @Column(name = "Rruga")
    private String rruga;
    @Basic(optional = false)
    @Column(name = "Qyteti")
    private String qyteti;
    @Basic(optional = false)
    @Column(name = "Zip_Code")
    private long zipCode;
    @JoinColumn(name = "Oferta_id", referencedColumnName = "Oferta_id")
    @ManyToOne(optional = false)
    private Oferta ofertaid;

    public OpenLead() {
    }

    public OpenLead(Integer leadid) {
        this.leadid = leadid;
    }

    public OpenLead(Integer leadid, String emri, String mbiemri, String email, long telefoni, String leadStatus, String kompania, String shteti, String rruga, String qyteti, long zipCode) {
        this.leadid = leadid;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.email = email;
        this.telefoni = telefoni;
        this.leadStatus = leadStatus;
        this.kompania = kompania;
        this.shteti = shteti;
        this.rruga = rruga;
        this.qyteti = qyteti;
        this.zipCode = zipCode;
    }

    public Integer getLeadid() {
        return leadid;
    }

    public void setLeadid(Integer leadid) {
        this.leadid = leadid;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelefoni() {
        return telefoni;
    }

    public void setTelefoni(long telefoni) {
        this.telefoni = telefoni;
    }

    public String getLeadStatus() {
        return leadStatus;
    }

    public void setLeadStatus(String leadStatus) {
        this.leadStatus = leadStatus;
    }

    public String getKompania() {
        return kompania;
    }

    public void setKompania(String kompania) {
        this.kompania = kompania;
    }

    public String getShteti() {
        return shteti;
    }

    public void setShteti(String shteti) {
        this.shteti = shteti;
    }

    public String getRruga() {
        return rruga;
    }

    public void setRruga(String rruga) {
        this.rruga = rruga;
    }

    public String getQyteti() {
        return qyteti;
    }

    public void setQyteti(String qyteti) {
        this.qyteti = qyteti;
    }

    public long getZipCode() {
        return zipCode;
    }

    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    public Oferta getOfertaid() {
        return ofertaid;
    }

    public void setOfertaid(Oferta ofertaid) {
        this.ofertaid = ofertaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (leadid != null ? leadid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpenLead)) {
            return false;
        }
        OpenLead other = (OpenLead) object;
        if ((this.leadid == null && other.leadid != null) || (this.leadid != null && !this.leadid.equals(other.leadid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emri;
    }

    @XmlTransient
    public Collection<Oppertunities> getOppertunitiesCollection() {
        return oppertunitiesCollection;
    }

    public void setOppertunitiesCollection(Collection<Oppertunities> oppertunitiesCollection) {
        this.oppertunitiesCollection = oppertunitiesCollection;
    }
    
}
