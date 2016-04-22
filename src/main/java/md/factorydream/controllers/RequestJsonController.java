/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers;

import md.factorydream.entites.rest.OrdersRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Zaițev.Victor
 */
@RestController
public class RequestJsonController {

    //------------------- Save a Orders --------------------------------------------------------
    @RequestMapping(value = "/save/orders", method = RequestMethod.POST)
    public ResponseEntity<OrdersRest> createUser(@RequestBody OrdersRest ordersRest, UriComponentsBuilder ucBuilder) {

        System.out.println(" Orders Id " + ordersRest.getId());
        System.out.println(" colorName " + ordersRest.getColor());
        System.out.println(" customerName " + ordersRest.getCustomer());
        System.out.println(" diameterValue " + ordersRest.getDiameter());
        System.out.println(" modelName " + ordersRest.getModel());
        System.out.println(" statusName " + ordersRest.getStatus());
        System.out.println(" threadName " + ordersRest.getThread());
        System.out.println(" typeName " + ordersRest.getType());
        System.out.println(" orderData " + ordersRest.getOrderData());
        System.out.println(" orderIdentifier " + ordersRest.getOrderIdentifier());
        System.out.println(" quantity " + ordersRest.getQuantity());
        System.out.println(" delivery " + ordersRest.getDelivery());
        System.out.println(" distributionDate " + ordersRest.getDistributionDate());
        System.out.println(" lastUpdateDate " + ordersRest.getLastUpdateDate());

        return new ResponseEntity<>(ordersRest, HttpStatus.OK);
    }

}
