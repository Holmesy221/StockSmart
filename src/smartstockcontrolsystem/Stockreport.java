/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstockcontrolsystem;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Holmesy
 */
@Entity
@Table(name = "STOCKREPORT")
@NamedQueries({
    @NamedQuery(name = "Stockreport.findAll", query = "SELECT s FROM Stockreport s"),
    @NamedQuery(name = "Stockreport.findById", query = "SELECT s FROM Stockreport s WHERE s.id = :id"),
    @NamedQuery(name = "Stockreport.findByItemcode", query = "SELECT s FROM Stockreport s WHERE s.itemcode = :itemcode"),
    @NamedQuery(name = "Stockreport.findByItemname", query = "SELECT s FROM Stockreport s WHERE s.itemname = :itemname"),
    @NamedQuery(name = "Stockreport.findByTotalstocked", query = "SELECT s FROM Stockreport s WHERE s.totalstocked = :totalstocked"),
    @NamedQuery(name = "Stockreport.findByTotalsold", query = "SELECT s FROM Stockreport s WHERE s.totalsold = :totalsold"),
    @NamedQuery(name = "Stockreport.findByTotalleft", query = "SELECT s FROM Stockreport s WHERE s.totalleft = :totalleft")})
public class Stockreport implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ITEMCODE")
    private String itemcode;
    @Column(name = "ITEMNAME")
    private String itemname;
    @Column(name = "TOTALSTOCKED")
    private String totalstocked;
    @Column(name = "TOTALSOLD")
    private String totalsold;
    @Column(name = "TOTALLEFT")
    private String totalleft;

    public Stockreport() {
    }

    public Stockreport(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        String oldItemcode = this.itemcode;
        this.itemcode = itemcode;
        changeSupport.firePropertyChange("itemcode", oldItemcode, itemcode);
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        String oldItemname = this.itemname;
        this.itemname = itemname;
        changeSupport.firePropertyChange("itemname", oldItemname, itemname);
    }

    public String getTotalstocked() {
        return totalstocked;
    }

    public void setTotalstocked(String totalstocked) {
        String oldTotalstocked = this.totalstocked;
        this.totalstocked = totalstocked;
        changeSupport.firePropertyChange("totalstocked", oldTotalstocked, totalstocked);
    }

    public String getTotalsold() {
        return totalsold;
    }

    public void setTotalsold(String totalsold) {
        String oldTotalsold = this.totalsold;
        this.totalsold = totalsold;
        changeSupport.firePropertyChange("totalsold", oldTotalsold, totalsold);
    }

    public String getTotalleft() {
        return totalleft;
    }

    public void setTotalleft(String totalleft) {
        String oldTotalleft = this.totalleft;
        this.totalleft = totalleft;
        changeSupport.firePropertyChange("totalleft", oldTotalleft, totalleft);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stockreport)) {
            return false;
        }
        Stockreport other = (Stockreport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smartstockcontrolsystem.Stockreport[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
