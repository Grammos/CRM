/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejb;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gramos
 */
@Entity
@Table(name = "Punetori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Punetori.findAll", query = "SELECT p FROM Punetori p"),
    @NamedQuery(name = "Punetori.findByPid", query = "SELECT p FROM Punetori p WHERE p.pid = :pid"),
    @NamedQuery(name = "Punetori.findByEmri", query = "SELECT p FROM Punetori p WHERE p.emri = :emri"),
    @NamedQuery(name = "Punetori.findByMbiemri", query = "SELECT p FROM Punetori p WHERE p.mbiemri = :mbiemri"),
    @NamedQuery(name = "Punetori.findByAdresa", query = "SELECT p FROM Punetori p WHERE p.adresa = :adresa"),
    @NamedQuery(name = "Punetori.findByTelefoni", query = "SELECT p FROM Punetori p WHERE p.telefoni = :telefoni")})
public class Punetori implements Serializable {
    @JoinColumn(name = "Kontrata_id", referencedColumnName = "Kontrata_Id")
    @ManyToOne(optional = false)
    private Kontrata kontrataid;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "punetori")
    private Kontrata kontrata;
    @Basic(optional = false)
    @Column(name = "Qyteti")
    private String qyteti;
    @JoinColumn(name = "D_id", referencedColumnName = "D_ID")
    @ManyToOne(optional = false)
    private Departamenti did;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(generator="Pid")
    @SequenceGenerator(name="Pid",sequenceName="P_Id", allocationSize=1)
    @Column(name = "P_id")
    private Integer pid;
    @Basic(optional = false)
    @Column(name = "Emri")
    private String emri;
    @Basic(optional = false)
    @Column(name = "Mbiemri")
    private String mbiemri;
    @Basic(optional = false)
    @Column(name = "Adresa")
    private String adresa;
    @Basic(optional = false)
    @Column(name = "Telefoni")
    private long telefoni;
    @JoinColumn(name = "U_id", referencedColumnName = "U_id")
    @ManyToOne
    private Users uid;
    

    public Punetori() {
    }

    public Punetori(Integer pid) {
        this.pid = pid;
    }

    public Punetori(Integer pid, String emri, String mbiemri, String adresa, long telefoni) {
        this.pid = pid;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.adresa = adresa;
        this.telefoni = telefoni;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public long getTelefoni() {
        return telefoni;
    }

    public void setTelefoni(long telefoni) {
        this.telefoni = telefoni;
    }

    public Users getUid() {
        return uid;
    }

    public void setUid(Users uid) {
        this.uid = uid;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pid != null ? pid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Punetori)) {
            return false;
        }
        Punetori other = (Punetori) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emri;
    }

    public String getQyteti() {
        return qyteti;
    }

    public void setQyteti(String qyteti) {
        this.qyteti = qyteti;
    }

    public Departamenti getDid() {
        return did;
    }

    public void setDid(Departamenti did) {
        this.did = did;
    }

    public Kontrata getKontrata() {
        return kontrata;
    }

    public void setKontrata(Kontrata kontrata) {
        this.kontrata = kontrata;
    }

    public Kontrata getKontrataid() {
        return kontrataid;
    }

    public void setKontrataid(Kontrata kontrataid) {
        this.kontrataid = kontrataid;
    }
    
}
