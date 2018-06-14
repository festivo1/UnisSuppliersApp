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
public class LeakageDTO {
    private int id, did, sid, iid, received_leakage, returned_leakage;

    public LeakageDTO() {
    }

    public LeakageDTO(int id, int did, int sid, int iid, int received_leakage, int returned_leakage) {
        this.id = id;
        this.did = did;
        this.sid = sid;
        this.iid = iid;
        this.received_leakage = received_leakage;
        this.returned_leakage = returned_leakage;
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

    public void setIid(int iid) {
        this.iid = iid;
    }

    public int getReceived_leakage() {
        return received_leakage;
    }

    public void setReceived_leakage(int received_leakage) {
        this.received_leakage = received_leakage;
    }

    public int getReturned_leakage() {
        return returned_leakage;
    }

    public void setReturned_leakage(int returned_leakage) {
        this.returned_leakage = returned_leakage;
    }
    
    
}   
