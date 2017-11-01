/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstockcontrolsystem;

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
        this.id = id;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getItemprice() {
        return itemprice;
    }

    public void setItemprice(String itemprice) {
        this.itemprice = itemprice;
    }

    public String getItemquantity() {
        return itemquantity;
    }

    public void setItemquantity(String itemquantity) {
        this.itemquantity = itemquantity;
    }

    public String getStockarrivaldate() {
        return stockarrivaldate;
    }

    public void setStockarrivaldate(String stockarrivaldate) {
        this.stockarrivaldate = stockarrivaldate;
    }

    public String getMinrequireditem() {
        return minrequireditem;
    }

    public void setMinrequireditem(String minrequireditem) {
        this.minrequireditem = minrequireditem;
    }

    public String getStaffcheck() {
        return staffcheck;
    }

    public void setStaffcheck(String staffcheck) {
        this.staffcheck = staffcheck;
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
    
}
