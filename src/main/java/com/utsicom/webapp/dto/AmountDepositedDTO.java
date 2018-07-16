/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsicom.webapp.dto;

import java.util.Date;

/**
 *
 * @author utsi
 */
public class AmountDepositedDTO {
    private int id, did, amountDeposited;
     private int decrementedAmount;
    private String addedDate;
    public AmountDepositedDTO() {
    }

    public AmountDepositedDTO(int id, int did, int amountDeposited, Integer decrementedAmount, String addedDate) {
        this.id = id;
        this.did = did;
        this.amountDeposited = amountDeposited;
        this.decrementedAmount = decrementedAmount;
        this.addedDate = addedDate;
    }

    public Integer getDecrementedAmount() {
        return decrementedAmount;
    }

    public void setDecrementedAmount(Integer decrementedAmount) {
        this.decrementedAmount = decrementedAmount;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getAmountDeposited() {
        return amountDeposited;
    }

    public void setAmountDeposited(int amountDeposited) {
        this.amountDeposited = amountDeposited;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }
    

    
}
