/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsicom.webapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author utsi
 */
@Entity
@Table(name = "items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")
    , @NamedQuery(name = "Item.findById", query = "SELECT i FROM Item i WHERE i.id = :id")
    })
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Column(name = "purchased_price")
    private Integer purchasedPrice;
    @Column(name = "selling_price")
    private Integer sellingPrice;
    @Column(name = "added_date")
    @Temporal(TemporalType.DATE)
    private Date addedDate;
    @OneToMany(mappedBy = "item")
    private List<ItemDeposited> itemDepositedList;
    @OneToMany(mappedBy = "item")
//    private List<Transaction> transactionList;
//    @OneToMany(mappedBy = "item")
    private List<Leakage> leakageList;

    public Item() {
    }

    public Item(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPurchasedPrice() {
        return purchasedPrice;
    }

    public void setPurchasedPrice(Integer purchasedPrice) {
        this.purchasedPrice = purchasedPrice;
    }

    public Integer getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Integer sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    @XmlTransient
    public List<ItemDeposited> getItemDepositedList() {
        return itemDepositedList;
    }

    public void setItemDepositedList(List<ItemDeposited> itemDepositedList) {
        this.itemDepositedList = itemDepositedList;
    }

//    @XmlTransient
//    public List<Transaction> getTransactionList() {
//        return transactionList;
//    }

//    public void setTransactionList(List<Transaction> transactionList) {
//        this.transactionList = transactionList;
//    }

    @XmlTransient
    public List<Leakage> getLeakageList() {
        return leakageList;
    }

    public void setLeakageList(List<Leakage> leakageList) {
        this.leakageList = leakageList;
    }

    
}
