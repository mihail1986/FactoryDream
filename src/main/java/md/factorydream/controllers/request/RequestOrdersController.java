/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.request;

import javax.validation.Valid;
import md.factorydream.entites.rest.OrdersRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Zaițev.Victor
 */
@RestController
public class RequestOrdersController {

    //------------------- Save a Orders --------------------------------------------------------
    @RequestMapping(value = "/save/orders", method = RequestMethod.POST)
    public ResponseEntity<OrdersRest> createUser(@Valid @RequestBody OrdersRest ordersRest, BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()) {
            System.out.println(" Zaitev Victor ");
            System.out.println(" Zaitev " +bindingResult.getFieldError().getField());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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
        System.out.println(" OrderParametersRestValue " + ordersRest.getOrderParameterses());
        System.out.println(" OrderNotes " + ordersRest.getOrderNotes());

        return new ResponseEntity<>(ordersRest, HttpStatus.OK);

    }

}
