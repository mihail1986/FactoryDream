/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.rest;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.rest.TypesValueRest;
import md.factorydream.spring.service.TypesService;
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
public class RestTypesController {

    //Types Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "typesService")
    private TypesService typesService;

    //---------------------- Retrieve All Value of Types --------------------------------------------------
    @RequestMapping(value = "/rest/valueTypes", method = RequestMethod.GET)
    public ResponseEntity<List<TypesValueRest>> getAllValueTypes() {

        List<TypesValueRest> typesValueRestList = (ArrayList<TypesValueRest>) typesService.findAllEnableTypesRest();

        return new ResponseEntity<>(typesValueRestList, HttpStatus.OK);
    }
}
