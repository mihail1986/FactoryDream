/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import md.factorydream.spring.dao.OrderParametersDAO;
import org.springframework.stereotype.Service;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class OrderParametersServiceImpl implements OrderParametersService {

    private OrderParametersDAO orderParametersDAO;

    public void setOrderParametersDAO(OrderParametersDAO orderParametersDAO) {
        this.orderParametersDAO = orderParametersDAO;
    }

}
