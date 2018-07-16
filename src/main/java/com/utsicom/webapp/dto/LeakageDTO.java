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
public class LeakageDTO {
    private int id, did, sid, iid, receivedLeakage, returnedLeakage;
    private String addedDate;

    public LeakageDTO() {
    }

    public LeakageDTO(int id, int did, int sid, int iid, int receivedLeakage, int returnedLeakage, String addedDate) {
        this.id = id;
        this.did = did;
        this.sid = sid;
        this.iid = iid;
        this.receivedLeakage = receivedLeakage;
        this.returnedLeakage = returnedLeakage;
        this.addedDate = addedDate;
    }

   
    

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
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

    public void setIid(int iid) {
        this.iid = iid;
    }

    public int getReceivedLeakage() {
        return receivedLeakage;
    }

    public void setReceivedLeakage(int receivedLeakage) {
        this.receivedLeakage = receivedLeakage;
    }

    public int getReturnedLeakage() {
        return returnedLeakage;
    }

    public void setReturnedLeakage(int returnedLeakage) {
        this.returnedLeakage = returnedLeakage;
    }

   
    
    
}   
