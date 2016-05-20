/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.rest;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.rest.DiametersValueRest;
import md.factorydream.spring.service.DiametersService;
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
public class RestDiametersController {

    //Diameters Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "diametersService")
    private DiametersService diametersService;

    //---------------------- Retrieve All Value of Diameters --------------------------------------------------
    @RequestMapping(value = "/rest/valueDiameters", method = RequestMethod.GET)
    public ResponseEntity<List<DiametersValueRest>> getAllValueDiameters() {

        List<DiametersValueRest> diametersValueRestList = (ArrayList<DiametersValueRest>) diametersService.findAllEnableDiametersRest();

        return new ResponseEntity<>(diametersValueRestList, HttpStatus.OK);
    }
}
