/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.entites.rest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Mihail.Cepraga
 */
public class OrderRestReadOnly {

    private long id;
    private String color;
    private String customer;
    private String diameter;
    private String model;
    private String status;
    private String thread;
    private String type;
    private Date orderData;
    private String orderIdentifier;
    private int quantity;
    private Date delivery;
    private Date distributionDate;
    private Date lastUpdateDate;
    private Set<OrderParametersRestValue> orderParameterses = new HashSet<>();
    private long orderNotes;

    public OrderRestReadOnly(long id, String color, String customer, String diameter, String model, String status, String thread, String type, Date orderData, String orderIdentifier, int quantity, Date delivery, Date distributionDate, Date lastUpdateDate, Set<OrderParametersRestValue> orderParameterses, long orderNotes) {
        this.id = id;
        this.color = color;
        this.customer = customer;
        this.diameter = diameter;
        this.model = model;
        this.status = status;
        this.thread = thread;
        this.type = type;
        this.orderData = orderData;
        this.orderIdentifier = orderIdentifier;
        this.quantity = quantity;
        this.delivery = delivery;
        this.distributionDate = distributionDate;
        this.lastUpdateDate = lastUpdateDate;
        this.orderParameterses = orderParameterses;
        this.orderNotes = orderNotes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getOrderData() {
        return orderData;
    }

    public void setOrderData(Date orderData) {
        this.orderData = orderData;
    }

    public String getOrderIdentifier() {
        return orderIdentifier;
    }

    public void setOrderIdentifier(String orderIdentifier) {
        this.orderIdentifier = orderIdentifier;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDelivery() {
        return delivery;
    }

    public void setDelivery(Date delivery) {
        this.delivery = delivery;
    }

    public Date getDistributionDate() {
        return distributionDate;
    }

    public void setDistributionDate(Date distributionDate) {
        this.distributionDate = distributionDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Set<OrderParametersRestValue> getOrderParameterses() {
        return orderParameterses;
    }

    public void setOrderParameterses(Set<OrderParametersRestValue> orderParameterses) {
        this.orderParameterses = orderParameterses;
    }

    public long getOrderNotes() {
        return orderNotes;
    }

    public void setOrderNotes(long orderNotes) {
        this.orderNotes = orderNotes;
    }

}
