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
@Table(name = "Produkti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produkti.findAll", query = "SELECT p FROM Produkti p"),
    @NamedQuery(name = "Produkti.findByPid", query = "SELECT p FROM Produkti p WHERE p.pid = :pid"),
    @NamedQuery(name = "Produkti.findByPEmri", query = "SELECT p FROM Produkti p WHERE p.pEmri = :pEmri")})
public class Produkti implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produktiid")
    private Collection<FaturaDetale> faturaDetaleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pid")
    private Collection<Oferta> ofertaCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "P_id")
    @GeneratedValue(generator="Pid")
    @SequenceGenerator(name="Pid",sequenceName="P_Id", allocationSize=1)
    private Integer pid;
    @Basic(optional = false)
    @Column(name = "P_Emri")
    private String pEmri;
    @JoinColumn(name = "Qmimorja_id", referencedColumnName = "Qmimorja_id")
    @ManyToOne(optional = false)
    private Qmimorja qmimorjaid;
    @JoinColumn(name = "G_id", referencedColumnName = "G_id")
    @ManyToOne(optional = false)
    private GrupiProduktev gid;

    public Produkti() {
    }

    public Produkti(Integer pid) {
        this.pid = pid;
    }

    public Produkti(Integer pid, String pEmri) {
        this.pid = pid;
        this.pEmri = pEmri;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPEmri() {
        return pEmri;
    }

    public void setPEmri(String pEmri) {
        this.pEmri = pEmri;
    }

    public Qmimorja getQmimorjaid() {
        return qmimorjaid;
    }

    public void setQmimorjaid(Qmimorja qmimorjaid) {
        this.qmimorjaid = qmimorjaid;
    }

    public GrupiProduktev getGid() {
        return gid;
    }

    public void setGid(GrupiProduktev gid) {
        this.gid = gid;
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
        if (!(object instanceof Produkti)) {
            return false;
        }
        Produkti other = (Produkti) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pEmri;
    }

    @XmlTransient
    public Collection<Oferta> getOfertaCollection() {
        return ofertaCollection;
    }

    public void setOfertaCollection(Collection<Oferta> ofertaCollection) {
        this.ofertaCollection = ofertaCollection;
    }

    @XmlTransient
    public Collection<FaturaDetale> getFaturaDetaleCollection() {
        return faturaDetaleCollection;
    }

    public void setFaturaDetaleCollection(Collection<FaturaDetale> faturaDetaleCollection) {
        this.faturaDetaleCollection = faturaDetaleCollection;
    }
    
}
