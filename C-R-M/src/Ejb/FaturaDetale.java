/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gramos
 */
@Entity
@Table(name = "FaturaDetale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FaturaDetale.findAll", query = "SELECT f FROM FaturaDetale f"),
    @NamedQuery(name = "FaturaDetale.findByFdid", query = "SELECT f FROM FaturaDetale f WHERE f.fdid = :fdid"),
    @NamedQuery(name = "FaturaDetale.findBySasia", query = "SELECT f FROM FaturaDetale f WHERE f.sasia = :sasia"),
    @NamedQuery(name = "FaturaDetale.findByTotali", query = "SELECT f FROM FaturaDetale f WHERE f.totali = :totali"),
    @NamedQuery(name = "FaturaDetale.findByNjesia", query = "SELECT f FROM FaturaDetale f WHERE f.njesia = :njesia")})
public class FaturaDetale implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Fd_id")
    private Integer fdid;
    @Basic(optional = false)
    @Column(name = "Sasia")
    private int sasia;
    @Basic(optional = false)
    @Column(name = "Totali")
    private long totali;
    @Basic(optional = false)
    @Column(name = "Njesia")
    private String njesia;
    @JoinColumn(name = "Produkti_id", referencedColumnName = "P_id")
    @ManyToOne(optional = false)
    private Produkti produktiid;
    @JoinColumn(name = "F_id", referencedColumnName = "F_id")
    @ManyToOne(optional = false)
    private Fatura fid;

    public FaturaDetale() {
    }

    public FaturaDetale(Integer fdid) {
        this.fdid = fdid;
    }

    public FaturaDetale(Integer fdid, int sasia, long totali, String njesia) {
        this.fdid = fdid;
        this.sasia = sasia;
        this.totali = totali;
        this.njesia = njesia;
    }

    public Integer getFdid() {
        return fdid;
    }

    public void setFdid(Integer fdid) {
        this.fdid = fdid;
    }

    public int getSasia() {
        return sasia;
    }

    public void setSasia(int sasia) {
        this.sasia = sasia;
    }

    public long getTotali() {
        return totali;
    }

    public void setTotali(long totali) {
        this.totali = totali;
    }

    public String getNjesia() {
        return njesia;
    }

    public void setNjesia(String njesia) {
        this.njesia = njesia;
    }

    public Produkti getProduktiid() {
        return produktiid;
    }

    public void setProduktiid(Produkti produktiid) {
        this.produktiid = produktiid;
    }

    public Fatura getFid() {
        return fid;
    }

    public void setFid(Fatura fid) {
        this.fid = fid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fdid != null ? fdid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FaturaDetale)) {
            return false;
        }
        FaturaDetale other = (FaturaDetale) object;
        if ((this.fdid == null && other.fdid != null) || (this.fdid != null && !this.fdid.equals(other.fdid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ejb.FaturaDetale[ fdid=" + fdid + " ]";
    }
    
}
