/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsicom.webapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author utsi
 */
@Entity
@Table(name = "employees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    })
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 40)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 40)
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 100)
    @Column(name = "address")
    private String address;
    @Size(max = 30)
    @Column(name = "contact_number")
    private String contactNumber;
    @Lob
    @Column(name = "citizenship_pcy")
    private byte[] citizenshipPcy;
    @Lob
    @Column(name = "license_pcy")
    private byte[] licensePcy;
    @Column(name = "added_date")
    @Temporal(TemporalType.DATE)
    private Date addedDate;
    @OneToMany(mappedBy = "employee")
    private List<EmployeePayment> employeePaymentList;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public byte[] getCitizenshipPcy() {
        return citizenshipPcy;
    }

    public void setCitizenshipPcy(byte[] citizenshipPcy) {
        this.citizenshipPcy = citizenshipPcy;
    }

    public byte[] getLicensePcy() {
        return licensePcy;
    }

    public void setLicensePcy(byte[] licensePcy) {
        this.licensePcy = licensePcy;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    @XmlTransient
    public List<EmployeePayment> getEmployeePaymentList() {
        return employeePaymentList;
    }

    public void setEmployeePaymentList(List<EmployeePayment> employeePaymentList) {
        this.employeePaymentList = employeePaymentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    
}
