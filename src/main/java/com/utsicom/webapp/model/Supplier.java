/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsicom.webapp.model;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author utsi
 */
@Entity
@Table(name = "suppliers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supplier.findAll", query = "SELECT s FROM Supplier s")
   })
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 50)
    @Column(name = "address")
    private String address;
    @Size(max = 20)
    @Column(name = "contact_number")
    private String contactNumber;
    @Size(max = 20)
    @Column(name = "pan_number")
    private String panNumber;
//    @OneToMany(mappedBy = "supplier")
//    private List<ItemDeposited> itemDepositedList;
////    @OneToMany(mappedBy = "supplier")
////    private List<Transaction> transactionList;
//    @OneToMany(mappedBy = "supplier")
//    private List<Leakage> leakageList;

    public Supplier() {
    }

    public Supplier(Integer id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

 

//    @XmlTransient
//    public List<ItemDeposited> getItemDepositedList() {
//        return itemDepositedList;
//    }
//
//    public void setItemDepositedList(List<ItemDeposited> itemDepositedList) {
//        this.itemDepositedList = itemDepositedList;
//    }
////
////    @XmlTransient
////    public List<Transaction> getTransactionList() {
////        return transactionList;
////    }
////
////    public void setTransactionList(List<Transaction> transactionList) {
////        this.transactionList = transactionList;
////    }
//
//    @XmlTransient
//    public List<Leakage> getLeakageList() {
//        return leakageList;
//    }
//
//    public void setLeakageList(List<Leakage> leakageList) {
//        this.leakageList = leakageList;
//    }

   
    
}
