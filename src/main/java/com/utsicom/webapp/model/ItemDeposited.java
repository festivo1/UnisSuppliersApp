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
@Table(name = "item_deposited")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemDeposited.findAll", query = "SELECT i FROM ItemDeposited i")
    })
public class ItemDeposited implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "diposited_number")
    private Integer dipositedNumber;
    @JoinColumn(name = "dipo_id", referencedColumnName = "id")
    @ManyToOne
    private Dipo dipo;
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne
    private Item item;
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne
    private Supplier supplier;

    public ItemDeposited() {
    }

    public ItemDeposited(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDipositedNumber() {
        return dipositedNumber;
    }

    public void setDipositedNumber(Integer dipositedNumber) {
        this.dipositedNumber = dipositedNumber;
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

    
    
}
