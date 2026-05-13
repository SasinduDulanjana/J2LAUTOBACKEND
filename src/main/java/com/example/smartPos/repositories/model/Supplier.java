package com.example.smartPos.repositories.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "SUPPLIER")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_seq")
    @SequenceGenerator(name = "supplier_seq", sequenceName = "supplier_seq", allocationSize = 1)
    private Integer supId;

    private String name;

    private String email;

    private String phone;

    private String address;

    private Integer status;

    private String addBy;
    private String modifiedBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    public void fillNew(String userId){
        this.addBy = userId;
        this.addedDate = new Date();
        this.modifiedBy = userId;
        this.modifiedDate = new Date();
    }

    public void fillUpdated(String userId){
        this.modifiedBy = userId;
        this.modifiedDate = new Date();
    }



    public Integer getSupId() {
        return supId;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddBy() {
        return addBy;
    }

    public void setAddBy(String addBy) {
        this.addBy = addBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

}
