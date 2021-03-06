

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
@Table(name = "Users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUid", query = "SELECT u FROM Users u WHERE u.uid = :uid"),
    @NamedQuery(name = "Users.findByShfrytezuesi", query = "SELECT u FROM Users u WHERE u.shfrytezuesi = :shfrytezuesi"),
    @NamedQuery(name = "Users.findByFjalekalimi", query = "SELECT u FROM Users u WHERE u.fjalekalimi = :fjalekalimi")})
public class Users implements Serializable {
    @OneToMany(mappedBy = "uid")
    private Collection<Punetori> punetoriCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "U_id")
    @GeneratedValue(generator="Uid")
    @SequenceGenerator(name="Uid",sequenceName="U_Id", allocationSize=1)
    private Integer uid;
    @Basic(optional = false)
    @Column(name = "Shfrytezuesi")
    private String shfrytezuesi;
    @Basic(optional = false)
    @Column(name = "Fjalekalimi")
    private String fjalekalimi;
    @JoinColumn(name = "Role_id", referencedColumnName = "Role_id")
    @ManyToOne(optional = false)
    private Role roleid;

    public Users() {
    }

    public Users(Integer uid) {
        this.uid = uid;
    }

    public Users(Integer uid, String shfrytezuesi, String fjalekalimi) {
        this.uid = uid;
        this.shfrytezuesi = shfrytezuesi;
        this.fjalekalimi = fjalekalimi;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getShfrytezuesi() {
        return shfrytezuesi;
    }

    public void setShfrytezuesi(String shfrytezuesi) {
        this.shfrytezuesi = shfrytezuesi;
    }

    public String getFjalekalimi() {
        return fjalekalimi;
    }

    public void setFjalekalimi(String fjalekalimi) {
        this.fjalekalimi = fjalekalimi;
    }

    public Role getRoleid() {
        return roleid;
    }

    public void setRoleid(Role roleid) {
        this.roleid = roleid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uid != null ? uid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.uid == null && other.uid != null) || (this.uid != null && !this.uid.equals(other.uid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return shfrytezuesi;
    }

    @XmlTransient
    public Collection<Punetori> getPunetoriCollection() {
        return punetoriCollection;
    }

    public void setPunetoriCollection(Collection<Punetori> punetoriCollection) {
        this.punetoriCollection = punetoriCollection;
    }
    
}
