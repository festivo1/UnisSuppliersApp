/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsicom.webapp.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author utsi
 */
@Entity
@Table(name = "leakage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Leakage.findAll", query = "SELECT l FROM Leakage l")
    })
public class Leakage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "received_leakage")
    private Integer receivedLeakage;
    @Column(name = "returned_leakage")
    private Integer returnedLeakage;
    @Column(name = "added_date")
    @Temporal(TemporalType.DATE)
    private Date addedDate;
    @JoinColumn(name = "dipo_id", referencedColumnName = "id")
    @ManyToOne
    private Dipo dipo;
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne
    private Item item;
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne
    private Supplier supplier;

    public Leakage() {
    }

    public Leakage(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReceivedLeakage() {
        return receivedLeakage;
    }

    public void setReceivedLeakage(Integer receivedLeakage) {
        this.receivedLeakage = receivedLeakage;
    }

    public Integer getReturnedLeakage() {
        return returnedLeakage;
    }

    public void setReturnedLeakage(Integer returnedLeakage) {
        this.returnedLeakage = returnedLeakage;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Dipo getDipo() {
        return dipo;
    }

    public void setDipo(Dipo dipo) {
        this.dipo = dipo;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
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
        if (!(object instanceof Leakage)) {
            return false;
        }
        Leakage other = (Leakage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utsicom.webapp.entity.Leakage[ id=" + id + " ]";
    }
    
}
