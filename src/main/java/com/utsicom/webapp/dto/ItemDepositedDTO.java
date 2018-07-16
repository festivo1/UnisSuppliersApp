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
public class ItemDepositedDTO {
    private int id, did, sid, iid, refilledNumber;
    private Integer depositedNumber;
    private String addedDate;

    public ItemDepositedDTO() {
    }

    public ItemDepositedDTO(int id, int did, int sid, int iid, int refilledNumber, Integer depositedNumber, String addedDate) {
        this.id = id;
        this.did = did;
        this.sid = sid;
        this.iid = iid;
        this.refilledNumber = refilledNumber;
        this.depositedNumber = depositedNumber;
        this.addedDate = addedDate;
    }

    public Integer getDepositedNumber() {
        return depositedNumber;
    }

    public void setDepositedNumber(Integer depositedNumber) {
        this.depositedNumber = depositedNumber;
    }
    public int getRefilledNumber() {
        return refilledNumber;
    }

    public void setRefilledNumber(int refilledNumber) {
        this.refilledNumber = refilledNumber;
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

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
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

    public void setIid(int iid) {
        this.iid = iid;
    }

}
