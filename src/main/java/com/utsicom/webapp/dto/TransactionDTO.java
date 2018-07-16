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
public class TransactionDTO {
    private int id, did, sid, iid;
    private int transactedNumber, soldNumber, emptyRate, refilledRate ;
    private String addedDate;
    public TransactionDTO() {
    }

    public TransactionDTO(int id, int did, int sid, int iid, int transactedNumber, int soldNumber, int emptyRate, int refilledRate, String addedDate) {
        this.id = id;
        this.did = did;
        this.sid = sid;
        this.iid = iid;
        this.transactedNumber = transactedNumber;
        this.soldNumber = soldNumber;
        this.emptyRate = emptyRate;
        this.refilledRate = refilledRate;
        this.addedDate = addedDate;
    }

   

    public int getEmptyRate() {
        return emptyRate;
    }

    public void setEmptyRate(int emptyRate) {
        this.emptyRate = emptyRate;
    }

    public int getRefilledRate() {
        return refilledRate;
    }

    public void setRefilledRate(int refilledRate) {
        this.refilledRate = refilledRate;
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

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getIid() {
        return iid;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public int getTransactedNumber() {
        return transactedNumber;
    }

    public void setTransactedNumber(int transactedNumber) {
        this.transactedNumber = transactedNumber;
    }

    public int getSoldNumber() {
        return soldNumber;
    }

    public void setSoldNumber(int soldNumber) {
        this.soldNumber = soldNumber;
    }

    
    
}
