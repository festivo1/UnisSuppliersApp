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
    private int id, did, sid, iid, diposited_number;

    public ItemDepositedDTO() {
    }

    public ItemDepositedDTO(int id, int did, int sid, int iid, int diposited_number) {
        this.id = id;
        this.did = did;
        this.sid = sid;
        this.iid = iid;
        this.diposited_number = diposited_number;
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

    public int getDiposited_number() {
        return diposited_number;
    }

    public void setDiposited_number(int diposited_number) {
        this.diposited_number = diposited_number;
    }

   
    
    
    
}
