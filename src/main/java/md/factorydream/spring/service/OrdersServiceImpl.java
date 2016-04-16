/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.Orders;
import md.factorydream.entites.rest.OrdersRest;
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

    public void setOrdersDAO(OrdersDAO ordersDAO) {
        this.ordersDAO = ordersDAO;
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
    public List findAllOrdersRest() {
        List ordersRestList = new ArrayList();

        List ordersList = findAll();

        for (Object orders : ordersList) {
            Orders ord = (Orders) orders;
            OrdersRest ordersRest = new OrdersRest(ord.getId(), ord.getColors().getValue(), ord.getCustomers().getName(), ord.getDiameters().getValue(), ord.getModels().getValue(), ord.getStatusCod().getStatuses().getName(), ord.getThreads().getValue(), ord.getTypes().getValue(), ord.getOrderData(), ord.getOrderIdentifier(), ord.getQuantity(), ord.getDelivery(), ord.getDistributionDate(), ord.getLastUpdateDate());

            ordersRestList.add(ordersRest);

        }
        return ordersRestList;
    }

}
