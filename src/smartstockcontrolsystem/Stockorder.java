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
@Table(name = "STOCKORDER")
@NamedQueries({
    @NamedQuery(name = "Stockorder.findAll", query = "SELECT s FROM Stockorder s"),
    @NamedQuery(name = "Stockorder.findById", query = "SELECT s FROM Stockorder s WHERE s.id = :id"),
    @NamedQuery(name = "Stockorder.findByItemcode", query = "SELECT s FROM Stockorder s WHERE s.itemcode = :itemcode"),
    @NamedQuery(name = "Stockorder.findByItemname", query = "SELECT s FROM Stockorder s WHERE s.itemname = :itemname"),
    @NamedQuery(name = "Stockorder.findByItemquantity", query = "SELECT s FROM Stockorder s WHERE s.itemquantity = :itemquantity")})
public class Stockorder implements Serializable {

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
    @Column(name = "ITEMQUANTITY")
    private String itemquantity;

    public Stockorder() {
    }

    public Stockorder(Integer id) {
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

    public String getItemquantity() {
        return itemquantity;
    }

    public void setItemquantity(String itemquantity) {
        this.itemquantity = itemquantity;
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
        if (!(object instanceof Stockorder)) {
            return false;
        }
        Stockorder other = (Stockorder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smartstockcontrolsystem.Stockorder[ id=" + id + " ]";
    }
    
}
