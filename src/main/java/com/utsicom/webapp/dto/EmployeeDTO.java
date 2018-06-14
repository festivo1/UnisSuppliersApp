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
public class EmployeeDTO {
    private int id;
    private String firstName, lastName, address, contactNumber;
    private byte [] citizenshipPCY, licensePCY;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int id, String firstName, String lastName, String address, String contactNumber, byte[] citizenshipPCY, byte[] licensePCY) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.citizenshipPCY = citizenshipPCY;
        this.licensePCY = licensePCY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public byte[] getCitizenshipPCY() {
        return citizenshipPCY;
    }

    public void setCitizenshipPCY(byte[] citizenshipPCY) {
        this.citizenshipPCY = citizenshipPCY;
    }

    public byte[] getLicensePCY() {
        return licensePCY;
    }

    public void setLicensePCY(byte[] licensePCY) {
        this.licensePCY = licensePCY;
    }
    
    
    
}
