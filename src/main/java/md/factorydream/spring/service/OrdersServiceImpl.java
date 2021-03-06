/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import md.factorydream.entites.OrderParameters;
import md.factorydream.entites.Orders;
import md.factorydream.entites.Users;
import md.factorydream.entites.rest.OrderParametersRestValue;
import md.factorydream.entites.rest.OrderRestReadOnly;
import md.factorydream.entites.rest.OrdersRest;
import md.factorydream.spring.dao.OrderNoteDAO;
import md.factorydream.spring.dao.OrdersDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mihail.Cepraga
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    private OrdersDAO ordersDAO;
    private OrderNoteDAO ordersNoteDAO;

    public void setOrdersDAO(OrdersDAO ordersDAO) {
        this.ordersDAO = ordersDAO;
    }

    public void setOrdersNoteDAO(OrderNoteDAO ordersNoteDAO) {
        this.ordersNoteDAO = ordersNoteDAO;
    }

    @Override
    @Transactional
    public void save(Orders orders) {
        this.ordersDAO.save(orders);
    }

    @Override
    @Transactional
    public List findAll() {
        return this.ordersDAO.findAll();
    }

    @Override
    @Transactional
    public List findAllOrdersRest() {
        List ordersRestList = new ArrayList();

        List ordersList = findAllEnableOrders();

        for (Object orders : ordersList) {

            Orders order = (Orders) orders;

            Set<OrderParametersRestValue> orderParametersSet = new HashSet<>();

            long orderNotesCount = ordersNoteDAO.countNotesPerOrder(order.getId());

            for (OrderParameters orderParameters : order.getOrderParameterses()) {
                OrderParametersRestValue orderParametersRestValue = new OrderParametersRestValue(orderParameters.getParamNames().getName(), orderParameters.getValue());
                orderParametersSet.add(orderParametersRestValue);
            }

            OrdersRest ordersRest = new OrdersRest(order.getId(), order.getColors().getId(), order.getCustomers().getId(), order.getDiameters().getId(), order.getModels().getId(), order.getStatusCod().getId(), order.getThreads().getId(), order.getTypes().getId(), order.getOrderData(), order.getOrderIdentifier(), order.getQuantity(), order.getDelivery(), order.getDistributionDate(), order.getLastUpdateDate(), orderParametersSet, orderNotesCount);

            ordersRestList.add(ordersRest);

        }
        return ordersRestList;
    }

    @Override
    @Transactional
    public List findAllOrdersRestReadOnly() {
        List ordersRestReadonlyList = new ArrayList();

        List ordersList = findAllEnableOrders();

        for (Object orders : ordersList) {

            Orders order = (Orders) orders;

            Set<OrderParametersRestValue> orderParametersSet = new HashSet<>();

            long orderNotesCount = ordersNoteDAO.countNotesPerOrder(order.getId());

            for (OrderParameters orderParameters : order.getOrderParameterses()) {
                OrderParametersRestValue orderParametersRestValue = new OrderParametersRestValue(orderParameters.getParamNames().getName(), orderParameters.getValue());
                orderParametersSet.add(orderParametersRestValue);
            }

            OrderRestReadOnly orderRestReadOnly = new OrderRestReadOnly(
                    order.getId(),
                    order.getColors().getValue(),
                    order.getCustomers().getName(),
                    order.getDiameters().getValue(),
                    order.getModels().getValue(),
                    order.getStatusCod().getStatuses().getName(),
                    order.getThreads().getValue(),
                    order.getTypes().getValue(),
                    order.getOrderData(),
                    order.getOrderIdentifier(),
                    order.getQuantity(),
                    order.getDelivery(),
                    order.getDistributionDate(),
                    order.getLastUpdateDate(),
                    orderParametersSet,
                    orderNotesCount);

            ordersRestReadonlyList.add(orderRestReadOnly);
        }

        return ordersRestReadonlyList;
    }

    @Override
    @Transactional
    public boolean save(OrdersRest ordersRest, Users users) {

        System.out.println("User Id" + users.getId());
        if (ordersRest.getId() <= 0) {
            return ordersDAO.insert(ordersRest, users);
        }
        return ordersDAO.update(ordersRest, users);
    }

    @Override
    @Transactional
    public Orders findOrdersById(long id) {
        return ordersDAO.findOrdersById(id);
    }

    @Override
    @Transactional
    public List findAllEnableOrders() {
        return ordersDAO.findAllEnableOrders();
    }

}
