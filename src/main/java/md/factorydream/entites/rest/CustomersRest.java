/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.entites.rest;

import java.util.Date;

/**
 *
 * @author Zaițev.Victor
 */
public class CustomersRest {

    private long id;
    private String nameStatusCod;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String customerDescription;
    private String note;
    private Date lastUpdateDate;

    public CustomersRest(long id, String nameStatusCod, String name, String address, String phone, String email, String customerDescription, String note, Date lastUpdateDate) {
        this.id = id;
        this.nameStatusCod = nameStatusCod;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.customerDescription = customerDescription;
        this.note = note;
        this.lastUpdateDate = lastUpdateDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameStatusCod() {
        return nameStatusCod;
    }

    public void setNameStatusCod(String nameStatusCod) {
        this.nameStatusCod = nameStatusCod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerDescription() {
        return customerDescription;
    }

    public void setCustomerDescription(String customerDescription) {
        this.customerDescription = customerDescription;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

}
