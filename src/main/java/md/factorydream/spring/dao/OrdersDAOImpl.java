/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.List;
import md.factorydream.entites.Orders;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mihail.Cepraga
 */
@Repository
public class OrdersDAOImpl extends AbstractSpringDao implements OrdersDAO{

    @Override
    public void save(Orders orders) {
        super.saveOrUpdate(orders);
    }

    @Override
    public List findAll() {
        return super.findAll(Orders.class);
    }    
}
