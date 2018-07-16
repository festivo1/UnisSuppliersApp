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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author utsi
 */
@Entity
@Table(name = "amount_deposited")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmountDeposited.findAll", query = "SELECT a FROM AmountDeposited a")})
public class AmountDeposited implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "deposited_amount")
    private Integer depositedAmount;
    @Column(name = "decremented_amount")
    private Integer decrementedAmount;
    @Column (name="added_date")
    private Date addedDate;
    @JoinColumn(name = "dipo_id", referencedColumnName = "id")
    @ManyToOne
    private Dipo dipo;

    public AmountDeposited() {
    }

    public AmountDeposited(Integer id, Integer depositedAmount, Integer decrementedAmount, Date addedDate, Dipo dipo) {
        this.id = id;
        this.depositedAmount = depositedAmount;
        this.decrementedAmount = decrementedAmount;
        this.addedDate = addedDate;
        this.dipo = dipo;
    }

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepositedAmount() {
        return depositedAmount;
    }

    public void setDepositedAmount(Integer depositedAmount) {
        this.depositedAmount = depositedAmount;
    }

    public Integer getDecrementedAmount() {
        return decrementedAmount;
    }

    public void setDecrementedAmount(Integer decrementedAmount) {
        this.decrementedAmount = decrementedAmount;
    }

    public Dipo getDipo() {
        return dipo;
    }

    public void setDipo(Dipo dipo) {
        this.dipo = dipo;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }
    

    

    
    
}
