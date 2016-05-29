/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.Date;
import java.util.List;
import md.factorydream.entites.Orders;
import md.factorydream.entites.Users;
import md.factorydream.entites.rest.OrdersRest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mihail.Cepraga
 */
@Repository
public class OrdersDAOImpl extends AbstractSpringDao implements OrdersDAO {

    @Override
    public void save(Orders orders) {
        super.saveOrUpdate(orders);
    }

    @Override
    public List findAll() {
        return super.findAll(Orders.class);
    }

    @Override
    public boolean insert(OrdersRest ordersRest, Users users) {

        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery(""
                + " INSERT  INTO orders(   id_color, id_customer, id_diameter, id_model, id_status_code, id_thread "
                + "                      , id_type, id_user_last_update, order_data, order_identifier, quantity "
                + "                      , delivery,  distribution_date, last_update_date  )  "
                + "             VALUES  ( :color, :customer, :diameter, :model, :status, :thread"
                + "                     , :type, :user, :orderData, :orderIdentifier, :quantity "
                + "                     , :delivery, :distributionDate, :lastUpdateDate ) "
        );

        query.setInteger("color", ordersRest.getColor());
        query.setLong("customer", ordersRest.getCustomer());
        query.setInteger("diameter", ordersRest.getDiameter());
        query.setInteger("model", ordersRest.getModel());
        query.setInteger("status", ordersRest.getStatus());
        query.setInteger("thread", ordersRest.getThread());
        query.setInteger("type", ordersRest.getType());
        query.setInteger("user", users.getId());
        query.setDate("orderData", ordersRest.getOrderData());
        query.setString("orderIdentifier", ordersRest.getOrderIdentifier());
        query.setInteger("quantity", ordersRest.getQuantity());
        query.setDate("delivery", ordersRest.getDelivery());
        query.setDate("distributionDate", ordersRest.getDistributionDate());
        query.setTimestamp("lastUpdateDate", new Date());

        int result = query.executeUpdate();

        if (result <= 0) {
            return false;
        }

        return true;
    }

    @Override
    public boolean update(OrdersRest ordersRest, Users users) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery(" UPDATE orders SET "
                + "          id_color       = :color, "
                + "          id_customer    = :customer, "
                + "          id_diameter    = :diameter, "
                + "          id_model       = :model, "
                + "          id_status_code = :status, "
                + "          id_thread      = :thread, "
                + "          id_type        = :type, "
                + "          id_user_last_update = :user, "
                + "          order_data     = :orderData, "
                + "          order_identifier = :orderIdentifier, "
                + "          quantity = :quantity, "
                + "          delivery = :delivery, "
                + "          distribution_date = :distributionDate, "
                + "          last_update_date = :lastUpdateDate"
                + "       WHERE id = :id");

        query.setLong("id", ordersRest.getId());
        query.setInteger("color", ordersRest.getColor());
        query.setLong("customer", ordersRest.getCustomer());
        query.setInteger("diameter", ordersRest.getDiameter());
        query.setInteger("model", ordersRest.getModel());
        query.setInteger("status", ordersRest.getStatus());
        query.setInteger("thread", ordersRest.getThread());
        query.setInteger("type", ordersRest.getType());
        query.setInteger("user", users.getId());
        query.setDate("orderData", ordersRest.getOrderData());
        query.setString("orderIdentifier", ordersRest.getOrderIdentifier());
        query.setInteger("quantity", ordersRest.getQuantity());
        query.setDate("delivery", ordersRest.getDelivery());
        query.setDate("distributionDate", ordersRest.getDistributionDate());
        query.setTimestamp("lastUpdateDate", new Date());

        int result = query.executeUpdate();

        if (result <= 0) {
            return false;
        }

        return true;
    }

    @Override
    public Orders findOrdersById(long id) {
        return (Orders) super.find(Orders.class, id);
    }
}
