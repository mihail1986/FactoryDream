/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.rest;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.rest.StatusCodeRest;
import md.factorydream.spring.service.StatusCodService;
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
public class RestStatusCodController {

    //StatusCode Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "statusCodService")
    private StatusCodService statusCodService;

    //---------------------- Retrieve All Value of Diameters --------------------------------------------------
    @RequestMapping(value = "/rest/statusCodStatuses", method = RequestMethod.GET)
    public ResponseEntity<List<StatusCodeRest>> getAllValueDiameters(@RequestParam short statusCod) {

        List<StatusCodeRest> statusCodeValueRestList = (ArrayList<StatusCodeRest>) statusCodService.findStatusCodByGroupId(statusCod);

        return new ResponseEntity<>(statusCodeValueRestList, HttpStatus.OK);
    }
}
