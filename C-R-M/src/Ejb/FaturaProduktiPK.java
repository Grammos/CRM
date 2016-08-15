/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Gramos
 */
@Embeddable
public class FaturaProduktiPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "F_id")
    private int fid;
    @Basic(optional = false)
    @Column(name = "Produkti_id")
    private int produktiid;

    public FaturaProduktiPK() {
    }

    public FaturaProduktiPK(int fid, int produktiid) {
        this.fid = fid;
        this.produktiid = produktiid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getProduktiid() {
        return produktiid;
    }

    public void setProduktiid(int produktiid) {
        this.produktiid = produktiid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fid;
        hash += (int) produktiid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FaturaProduktiPK)) {
            return false;
        }
        FaturaProduktiPK other = (FaturaProduktiPK) object;
        if (this.fid != other.fid) {
            return false;
        }
        if (this.produktiid != other.produktiid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ejb.FaturaProduktiPK[ fid=" + fid + ", produktiid=" + produktiid + " ]";
    }
    
}
