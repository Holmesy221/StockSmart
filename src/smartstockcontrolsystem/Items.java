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
@Table(name = "ITEMS")
@NamedQueries({
    @NamedQuery(name = "Items.findAll", query = "SELECT i FROM Items i"),
    @NamedQuery(name = "Items.findById", query = "SELECT i FROM Items i WHERE i.id = :id"),
    @NamedQuery(name = "Items.findByItemcode", query = "SELECT i FROM Items i WHERE i.itemcode = :itemcode"),
    @NamedQuery(name = "Items.findByItemname", query = "SELECT i FROM Items i WHERE i.itemname = :itemname"),
    @NamedQuery(name = "Items.findByItemprice", query = "SELECT i FROM Items i WHERE i.itemprice = :itemprice"),
    @NamedQuery(name = "Items.findByItemquantity", query = "SELECT i FROM Items i WHERE i.itemquantity = :itemquantity"),
    @NamedQuery(name = "Items.findByStockarrivaldate", query = "SELECT i FROM Items i WHERE i.stockarrivaldate = :stockarrivaldate"),
    @NamedQuery(name = "Items.findByMinrequireditem", query = "SELECT i FROM Items i WHERE i.minrequireditem = :minrequireditem"),
    @NamedQuery(name = "Items.findByStaffcheck", query = "SELECT i FROM Items i WHERE i.staffcheck = :staffcheck")})
public class Items implements Serializable {

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
    @Column(name = "ITEMPRICE")
    private String itemprice;
    @Column(name = "ITEMQUANTITY")
    private String itemquantity;
    @Column(name = "STOCKARRIVALDATE")
    private String stockarrivaldate;
    @Column(name = "MINREQUIREDITEM")
    private String minrequireditem;
    @Column(name = "STAFFCHECK")
    private String staffcheck;

    public Items() {
    }

    public Items(Integer id) {
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

    public String getItemprice() {
        return itemprice;
    }

    public void setItemprice(String itemprice) {
        String oldItemprice = this.itemprice;
        this.itemprice = itemprice;
        changeSupport.firePropertyChange("itemprice", oldItemprice, itemprice);
    }

    public String getItemquantity() {
        return itemquantity;
    }

    public void setItemquantity(String itemquantity) {
        String oldItemquantity = this.itemquantity;
        this.itemquantity = itemquantity;
        changeSupport.firePropertyChange("itemquantity", oldItemquantity, itemquantity);
    }

    public String getStockarrivaldate() {
        return stockarrivaldate;
    }

    public void setStockarrivaldate(String stockarrivaldate) {
        String oldStockarrivaldate = this.stockarrivaldate;
        this.stockarrivaldate = stockarrivaldate;
        changeSupport.firePropertyChange("stockarrivaldate", oldStockarrivaldate, stockarrivaldate);
    }

    public String getMinrequireditem() {
        return minrequireditem;
    }

    public void setMinrequireditem(String minrequireditem) {
        String oldMinrequireditem = this.minrequireditem;
        this.minrequireditem = minrequireditem;
        changeSupport.firePropertyChange("minrequireditem", oldMinrequireditem, minrequireditem);
    }

    public String getStaffcheck() {
        return staffcheck;
    }

    public void setStaffcheck(String staffcheck) {
        String oldStaffcheck = this.staffcheck;
        this.staffcheck = staffcheck;
        changeSupport.firePropertyChange("staffcheck", oldStaffcheck, staffcheck);
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
        if (!(object instanceof Items)) {
            return false;
        }
        Items other = (Items) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smartstockcontrolsystem.Items[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
