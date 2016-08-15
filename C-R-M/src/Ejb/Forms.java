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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gramos
 */
@Entity
@Table(name = "Forms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Forms.findAll", query = "SELECT f FROM Forms f"),
    @NamedQuery(name = "Forms.findByFid", query = "SELECT f FROM Forms f WHERE f.fid = :fid"),
    @NamedQuery(name = "Forms.findByFDescription", query = "SELECT f FROM Forms f WHERE f.fDescription = :fDescription")})
public class Forms implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "F_id")
    @GeneratedValue(generator="Fid")
    @SequenceGenerator(name="Fid",sequenceName="Fid", allocationSize=1)
    private Integer fid;
    @Column(name = "F_Description")
    private String fDescription;
    @ManyToMany(mappedBy = "formsCollection")
    private Collection<Role> roleCollection;

    public Forms() {
    }

    public Forms(Integer fid) {
        this.fid = fid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFDescription() {
        return fDescription;
    }

    public void setFDescription(String fDescription) {
        this.fDescription = fDescription;
    }

    @XmlTransient
    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fid != null ? fid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Forms)) {
            return false;
        }
        Forms other = (Forms) object;
        if ((this.fid == null && other.fid != null) || (this.fid != null && !this.fid.equals(other.fid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return fDescription;
    }
    
}
