/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsicom.webapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "dipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dipo.findAll", query = "SELECT d FROM Dipo d")
})
public class Dipo implements Serializable {

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
//    @Lob
//    @Column(name = "citizenship_pcy", nullable = true)
//    private byte[] citizenshipPcy;
//    
    @Column(name = "added_date", insertable = false)
    private Date addedDate;
//    @Lob
//    @Column(name = "pan_registration_pcy", nullable = true)
//    private byte[] panRegistrationPcy;
//    @OneToMany(mappedBy = "dipo")
//    private Set<AmountDeposited> amountDepositedSet;
//    @OneToMany(mappedBy = "dipo")
//    private Set<ItemDeposited> itemDepositedSet;
//    @OneToMany(mappedBy = "dipo")
//    private Set<Transaction> transactionSet;
//    @OneToOne(mappedBy = "user")
//    private Dipo dipo;

//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @OneToOne
//    private Dipo user;

//@OneToMany(mappedBy = "dipo")
//    private Set<Leakage> leakageSet;

    public Dipo() {
    }

    public Dipo(Integer id) {
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

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
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

//    public byte[] getCitizenshipPcy() {
//        return citizenshipPcy;
//    }
//
//    public void setCitizenshipPcy(byte[] citizenshipPcy) {
//        this.citizenshipPcy = citizenshipPcy;
//    }
//
//    public byte[] getPanRegistrationPcy() {
//        return panRegistrationPcy;
//    }
//
//    public void setPanRegistrationPcy(byte[] panRegistrationPcy) {
//        this.panRegistrationPcy = panRegistrationPcy;
//    }
//    @XmlTransient
//    public Set<AmountDeposited> getAmountDepositedSet() {
//        return amountDepositedSet;
//    }
//
//    public void setAmountDepositedSet(Set<AmountDeposited> amountDepositedSet) {
//        this.amountDepositedSet = amountDepositedSet;
//    }
//
//    @XmlTransient
//    public Set<ItemDeposited> getItemDepositedSet() {
//        return itemDepositedSet;
//    }
//
//    public void setItemDepositedSet(Set<ItemDeposited> itemDepositedSet) {
//        this.itemDepositedSet = itemDepositedSet;
//    }
//
//    @XmlTransient
//    public Set<Transaction> getTransactionSet() {
//        return transactionSet;
//    }
//
//    public void setTransactionSet(Set<Transaction> transactionSet) {
//        this.transactionSet = transactionSet;
//    }
//
//    @XmlTransient
//    public Set<Dipo> getDipoSet() {
//        return dipoSet;
//    }
//
//    public void setDipoSet(Set<Dipo> dipoSet) {
//        this.dipoSet = dipoSet;
//    }
//
//    public Dipo getUser() {
//        return user;
//    }
//
//    public void setUser(Dipo user) {
//        this.user = user;
//    }
//
//    @XmlTransient
//    public Set<Leakage> getLeakageSet() {
//        return leakageSet;
//    }
//
//    public void setLeakageSet(Set<Leakage> leakageSet) {
//        this.leakageSet = leakageSet;
//    }
//
//    
}
