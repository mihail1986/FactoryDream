/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.entites.rest;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Date;

/**
 *
 * @author Mihail.Cepraga
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class OrdersRest {

    private long id;
    private String colorName;
    private String customerName;
    private String diameterValue;
    private String modelName;
    private String statusName;
    private String threadName;
    private String typeName;
    private Date orderData;
    private String orderIdentifier;
    private int quantity;
    private Date delivery;
    private Date distributionDate;
    private Date lastUpdateDate;

    public OrdersRest() {
    }

    public OrdersRest(long id, String colorName, String customerName, String diameterValue, String modelName, String statusName, String threadName, String typeName, Date orderData, String orderIdentifier, int quantity, Date delivery, Date distributionDate, Date lastUpdateDate) {
        this.id = id;
        this.colorName = colorName;
        this.customerName = customerName;
        this.diameterValue = diameterValue;
        this.modelName = modelName;
        this.statusName = statusName;
        this.threadName = threadName;
        this.typeName = typeName;
        this.orderData = orderData;
        this.orderIdentifier = orderIdentifier;
        this.quantity = quantity;
        this.delivery = delivery;
        this.distributionDate = distributionDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDiameterValue() {
        return diameterValue;
    }

    public void setDiameterValue(String diameterValue) {
        this.diameterValue = diameterValue;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

}
