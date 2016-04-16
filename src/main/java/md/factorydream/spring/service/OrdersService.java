/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.List;
import md.factorydream.entites.Orders;

/**
 *
 * @author Mihail.Cepraga
 */
public interface OrdersService {
    
    public void save(Orders orders);

    public List findAll();
    
    public List findAllOrdersRest();
}
