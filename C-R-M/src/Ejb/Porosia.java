/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejb;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gramos
 */
@Entity
@Table(name = "Porosia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Porosia.findAll", query = "SELECT p FROM Porosia p"),
    @NamedQuery(name = "Porosia.findByPid", query = "SELECT p FROM Porosia p WHERE p.pid = :pid"),
    @NamedQuery(name = "Porosia.findBySasia", query = "SELECT p FROM Porosia p WHERE p.sasia = :sasia"),
    @NamedQuery(name = "Porosia.findByAdresa", query = "SELECT p FROM Porosia p WHERE p.adresa = :adresa"),
    @NamedQuery(name = "Porosia.findByData", query = "SELECT p FROM Porosia p WHERE p.data = :data")})
public class Porosia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "P_id")
    private Integer pid;
    @Basic(optional = false)
    @Column(name = "Sasia")
    private int sasia;
    @Basic(optional = false)
    @Column(name = "Adresa")
    private String adresa;
    @Basic(optional = false)
    @Column(name = "Data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @JoinColumn(name = "Klienti_id", referencedColumnName = "Klienti_id")
    @ManyToOne(optional = false)
    private Klienti klientiid;

    public Porosia() {
    }

    public Porosia(Integer pid) {
        this.pid = pid;
    }

    public Porosia(Integer pid, int sasia, String adresa, Date data) {
        this.pid = pid;
        this.sasia = sasia;
        this.adresa = adresa;
        this.data = data;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public int getSasia() {
        return sasia;
    }

    public void setSasia(int sasia) {
        this.sasia = sasia;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
        hash += (pid != null ? pid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Porosia)) {
            return false;
        }
        Porosia other = (Porosia) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ejb.Porosia[ pid=" + pid + " ]";
    }
    
}
