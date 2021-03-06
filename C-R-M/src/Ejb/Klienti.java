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
@Table(name = "Klienti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klienti.findAll", query = "SELECT k FROM Klienti k"),
    @NamedQuery(name = "Klienti.findByKlientiid", query = "SELECT k FROM Klienti k WHERE k.klientiid = :klientiid"),
    @NamedQuery(name = "Klienti.findByKEmri", query = "SELECT k FROM Klienti k WHERE k.kEmri = :kEmri"),
    @NamedQuery(name = "Klienti.findByKMbiemri", query = "SELECT k FROM Klienti k WHERE k.kMbiemri = :kMbiemri"),
    @NamedQuery(name = "Klienti.findByKAdresa", query = "SELECT k FROM Klienti k WHERE k.kAdresa = :kAdresa"),
    @NamedQuery(name = "Klienti.findByEmail", query = "SELECT k FROM Klienti k WHERE k.email = :email"),
    @NamedQuery(name = "Klienti.findByTelefoni", query = "SELECT k FROM Klienti k WHERE k.telefoni = :telefoni")})
public class Klienti implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klientiid")
    private Collection<Porosia> porosiaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klientiid")
    private Collection<Fatura> faturaCollection;
    @JoinColumn(name = "Oferta", referencedColumnName = "Oferta_id")
    @ManyToOne
    private Oferta oferta;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Klienti_id")
    @GeneratedValue(generator="Kid")
    @SequenceGenerator(name="Kid",sequenceName="K_Id", allocationSize=1)
    private Integer klientiid;
    @Basic(optional = false)
    @Column(name = "K_Emri")
    private String kEmri;
    @Basic(optional = false)
    @Column(name = "K_Mbiemri")
    private String kMbiemri;
    @Basic(optional = false)
    @Column(name = "K_Adresa")
    private String kAdresa;
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "Telefoni")
    private String telefoni;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klientiid")
    private Collection<Oferta> ofertaCollection;
    @JoinColumn(name = "O_id", referencedColumnName = "O_id")
    @ManyToOne
    private Oppertunities oid;
    @JoinColumn(name = "G_Kid", referencedColumnName = "G_Kid")
    @ManyToOne(optional = false)
    private GrupiKlientav gKid;

    public Klienti() {
    }

    public Klienti(Integer klientiid) {
        this.klientiid = klientiid;
    }

    public Klienti(Integer klientiid, String kEmri, String kMbiemri, String kAdresa, String telefoni) {
        this.klientiid = klientiid;
        this.kEmri = kEmri;
        this.kMbiemri = kMbiemri;
        this.kAdresa = kAdresa;
        this.telefoni = telefoni;
    }

    public Integer getKlientiid() {
        return klientiid;
    }

    public void setKlientiid(Integer klientiid) {
        this.klientiid = klientiid;
    }

    public String getKEmri() {
        return kEmri;
    }

    public void setKEmri(String kEmri) {
        this.kEmri = kEmri;
    }

    public String getKMbiemri() {
        return kMbiemri;
    }

    public void setKMbiemri(String kMbiemri) {
        this.kMbiemri = kMbiemri;
    }

    public String getKAdresa() {
        return kAdresa;
    }

    public void setKAdresa(String kAdresa) {
        this.kAdresa = kAdresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoni() {
        return telefoni;
    }

    public void setTelefoni(String telefoni) {
        this.telefoni = telefoni;
    }

    @XmlTransient
    public Collection<Oferta> getOfertaCollection() {
        return ofertaCollection;
    }

    public void setOfertaCollection(Collection<Oferta> ofertaCollection) {
        this.ofertaCollection = ofertaCollection;
    }

    public Oppertunities getOid() {
        return oid;
    }

    public void setOid(Oppertunities oid) {
        this.oid = oid;
    }

    public GrupiKlientav getGKid() {
        return gKid;
    }

    public void setGKid(GrupiKlientav gKid) {
        this.gKid = gKid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (klientiid != null ? klientiid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klienti)) {
            return false;
        }
        Klienti other = (Klienti) object;
        if ((this.klientiid == null && other.klientiid != null) || (this.klientiid != null && !this.klientiid.equals(other.klientiid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return kEmri;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    @XmlTransient
    public Collection<Porosia> getPorosiaCollection() {
        return porosiaCollection;
    }

    public void setPorosiaCollection(Collection<Porosia> porosiaCollection) {
        this.porosiaCollection = porosiaCollection;
    }

    @XmlTransient
    public Collection<Fatura> getFaturaCollection() {
        return faturaCollection;
    }

    public void setFaturaCollection(Collection<Fatura> faturaCollection) {
        this.faturaCollection = faturaCollection;
    }
    
}
