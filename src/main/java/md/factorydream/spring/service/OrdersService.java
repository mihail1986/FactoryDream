/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.List;
import md.factorydream.entites.Orders;
import md.factorydream.entites.Users;
import md.factorydream.entites.rest.OrdersRest;

/**
 *
 * @author Mihail.Cepraga
 */
public interface OrdersService {

    public void save(Orders orders);

    public List findAll();

    public List findAllEnableOrders();

    public List findAllOrdersRest();

    public List findAllOrdersRestReadOnly();

    public boolean save(OrdersRest ordersRest, Users users);

    public Orders findOrdersById(long id);
}
