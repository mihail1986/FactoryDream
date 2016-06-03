/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.rest;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.rest.MenuValueRest;
import md.factorydream.spring.service.SpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Zaițev.Victor
 */
@RestController
public class RestSpringController {

    //Orders Service which will do all data retrieval/manipulation work
    @Autowired(required = true)
    @Qualifier(value = "springService")
    private SpringService springService;

    @RequestMapping(value = "/rest/menuLabel", method = RequestMethod.GET)
    public ResponseEntity<MenuValueRest> getAllOrderNotesByOrderId() {

        MenuValueRest menuValueRestsList = (MenuValueRest) springService.selectMeniu();

        return new ResponseEntity<>(menuValueRestsList, HttpStatus.OK);
    }
}
