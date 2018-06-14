/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsicom.webapp.model;

import java.io.Serializable;
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
    @Column(name = "diposited_amount")
    private Integer dipositedAmount;
    @JoinColumn(name = "dipo_id", referencedColumnName = "id")
    @ManyToOne
    private Dipo dipo;
   
    public AmountDeposited() {
    }

    public AmountDeposited(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDipositedAmount() {
        return dipositedAmount;
    }

    public void setDipositedAmount(Integer dipositedAmount) {
        this.dipositedAmount = dipositedAmount;
    }

    public Dipo getDipo() {
        return dipo;
    }

    public void setDipo(Dipo dipo) {
        this.dipo = dipo;
    }

    
    
}
