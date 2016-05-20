/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.rest;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.rest.ColorsValueRest;
import md.factorydream.spring.service.ColorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Zaițev.Victor
 */
@RestController
public class RestColorsController {

    //Colors Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "colorsService")
    private ColorsService colorsService;

    //---------------------- Retrieve All Value of Colors --------------------------------------------------
    @RequestMapping(value = "/rest/valueColors", method = RequestMethod.GET)
    public ResponseEntity<List<ColorsValueRest>> getAllValueColors() {

        List<ColorsValueRest> colorsValueRestList = (ArrayList<ColorsValueRest>) colorsService.findAllEnableColorsRest();

        return new ResponseEntity<>(colorsValueRestList, HttpStatus.OK);
    }

}
