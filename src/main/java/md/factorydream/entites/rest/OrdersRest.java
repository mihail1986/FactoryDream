/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.entites.rest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Mihail.Cepraga
 */
public class OrdersRest {

    @NotNull
    @Min(0)
    private long id;

    @NotNull
    @Min(1)
    private int color;

    @NotNull
    @Min(1)
    private long customer;

    @NotNull
    @Min(1)
    private int diameter;

    @NotNull
    @Min(1)
    private int model;

    @NotNull
    @Min(1)
    private int status;

    @NotNull
    @Min(1)
    private int thread;

    @NotNull
    @Min(1)
    private int type;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @NotNull
    private Date orderData;

    @Pattern(regexp = "(\\d){1,6}\\/(\\d){2,4}")
    private String orderIdentifier;

    @NotNull
    @Min(1)
    private int quantity;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @NotNull
    private Date delivery;

    private Date distributionDate;

    private Date lastUpdateDate;

    @NotNull
    @Min(0)
    private long orderNotes;
    private Set<OrderParametersRestValue> orderParameterses = new HashSet<>();
//    private Set<OrderNotesRestValue> orderNotes = new HashSet<>();

    public OrdersRest() {
    }

    public OrdersRest(long id, int colorId, long customerId, int diameterId, int modelId, int statusId, int threadId, int typeId, Date orderData, String orderIdentifier, int quantity, Date delivery, Date distributionDate, Date lastUpdateDate) {
        this.id = id;
        this.color = colorId;
        this.customer = customerId;
        this.diameter = diameterId;
        this.model = modelId;
        this.status = statusId;
        this.thread = threadId;
        this.type = typeId;
        this.orderData = orderData;
        this.orderIdentifier = orderIdentifier;
        this.quantity = quantity;
        this.delivery = delivery;
        this.distributionDate = distributionDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public OrdersRest(long id, int colorId, long customerId, int diameterId, int modelId, int statusId, int threadId, int typeId, Date orderData, String orderIdentifier, int quantity, Date delivery, Date distributionDate, Date lastUpdateDate, Set<OrderParametersRestValue> orderParameterses, long orderNotes) {
        this.id = id;
        this.color = colorId;
        this.customer = customerId;
        this.diameter = diameterId;
        this.model = modelId;
        this.status = statusId;
        this.thread = threadId;
        this.type = typeId;
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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public long getCustomer() {
        return customer;
    }

    public void setCustomer(int customerId) {
        this.customer = customerId;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getThread() {
        return thread;
    }

    public void setThread(int thread) {
        this.thread = thread;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
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
