/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.rest;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.rest.OrderNoteRest;
import md.factorydream.spring.service.OrdersNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Zaițev.Victor
 */
@RestController
public class RestOrderNoteController {

    @Autowired
    @Qualifier(value = "ordersNoteService")
    private OrdersNoteService ordersNoteService;

    @RequestMapping(value = "/rest/orderNotes", method = RequestMethod.GET)
    public ResponseEntity<List<OrderNoteRest>> getAllOrderNotesByOrderId(@RequestParam long orderId) {

        List<OrderNoteRest> orderNotesRestList = (ArrayList<OrderNoteRest>) ordersNoteService.findOrderNoteRestByOrderId(orderId);

        return new ResponseEntity<>(orderNotesRestList, HttpStatus.OK);
    }

}
