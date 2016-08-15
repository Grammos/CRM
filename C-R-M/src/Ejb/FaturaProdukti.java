/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejb;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gramos
 */
@Entity
@Table(name = "Fatura_Produkti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FaturaProdukti.findAll", query = "SELECT f FROM FaturaProdukti f"),
    @NamedQuery(name = "FaturaProdukti.findByFid", query = "SELECT f FROM FaturaProdukti f WHERE f.faturaProduktiPK.fid = :fid"),
    @NamedQuery(name = "FaturaProdukti.findByProduktiid", query = "SELECT f FROM FaturaProdukti f WHERE f.faturaProduktiPK.produktiid = :produktiid")})
public class FaturaProdukti implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FaturaProduktiPK faturaProduktiPK;

    public FaturaProdukti() {
    }

    public FaturaProdukti(FaturaProduktiPK faturaProduktiPK) {
        this.faturaProduktiPK = faturaProduktiPK;
    }

    public FaturaProdukti(int fid, int produktiid) {
        this.faturaProduktiPK = new FaturaProduktiPK(fid, produktiid);
    }

    public FaturaProduktiPK getFaturaProduktiPK() {
        return faturaProduktiPK;
    }

    public void setFaturaProduktiPK(FaturaProduktiPK faturaProduktiPK) {
        this.faturaProduktiPK = faturaProduktiPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (faturaProduktiPK != null ? faturaProduktiPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FaturaProdukti)) {
            return false;
        }
        FaturaProdukti other = (FaturaProdukti) object;
        if ((this.faturaProduktiPK == null && other.faturaProduktiPK != null) || (this.faturaProduktiPK != null && !this.faturaProduktiPK.equals(other.faturaProduktiPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ejb.FaturaProdukti[ faturaProduktiPK=" + faturaProduktiPK + " ]";
    }
    
}
