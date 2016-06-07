/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.rest;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.OrderParameters;
import md.factorydream.spring.service.ParamNamesService;
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
public class RestOrderParametersRest {

    //ParamNames Service which will do all data retrieval/manipulation work
    @Autowired(required = true)
    @Qualifier(value = "paramNamesService")
    private ParamNamesService paramNamesService;

    //---------------------- Retrieve All Value of Diameters --------------------------------------------------
    @RequestMapping(value = "/rest/paramNames", method = RequestMethod.GET)
    public ResponseEntity<List<OrderParameters>> getAllValueDiameters() {

        List<OrderParameters> statusCodeValueRestList = (ArrayList<OrderParameters>) paramNamesService.findDistinctParamNames();
        return new ResponseEntity<>(statusCodeValueRestList, HttpStatus.OK);
    }

}
