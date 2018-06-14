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
public class VoucherDTO {
    private int id;
    private String paidBy, paidTo, bank;
    private int paid_amount;

    public VoucherDTO() {
    }

    public VoucherDTO(int id, String paidBy, String paidTo, String bank, int paid_amount) {
        this.id = id;
        this.paidBy = paidBy;
        this.paidTo = paidTo;
        this.bank = bank;
        this.paid_amount = paid_amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    public String getPaidTo() {
        return paidTo;
    }

    public void setPaidTo(String paidTo) {
        this.paidTo = paidTo;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public int getPaid_amount() {
        return paid_amount;
    }

    public void setPaid_amount(int paid_amount) {
        this.paid_amount = paid_amount;
    }
    
}
