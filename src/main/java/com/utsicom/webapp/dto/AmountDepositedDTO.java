/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsicom.webapp.dto;

/**
 *
 * @author utsi
 */
public class AmountDepositedDTO {
    private int id, did, amountDiposited, decrementedAmount ;

    public AmountDepositedDTO() {
    }

    public AmountDepositedDTO(int id, int did, int amountDiposited, int decrementedAmount) {
        this.id = id;
        this.did = did;
        this.amountDiposited = amountDiposited;
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

    public int getAmountDiposited() {
        return amountDiposited;
    }

    public void setAmountDiposited(int amountDiposited) {
        this.amountDiposited = amountDiposited;
    }

    public int getDecrementedAmount() {
        return decrementedAmount;
    }

    public void setDecrementedAmount(int decrementedAmount) {
        this.decrementedAmount = decrementedAmount;
    }

    
}
