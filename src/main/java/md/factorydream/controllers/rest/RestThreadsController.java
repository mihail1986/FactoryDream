/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.rest;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.rest.ThreadsValueRest;
import md.factorydream.spring.service.ThreadsService;
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
public class RestThreadsController {

    //Threads Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "threadsService")
    private ThreadsService threadsService;

    //---------------------- Retrieve All Value of Threads --------------------------------------------------
    @RequestMapping(value = "/rest/valueThreads", method = RequestMethod.GET)
    public ResponseEntity<List<ThreadsValueRest>> getAllValueThreads() {

        List<ThreadsValueRest> threadsValueRestList = (ArrayList<ThreadsValueRest>) threadsService.findAllEnableThreadsRest();

        return new ResponseEntity<>(threadsValueRestList, HttpStatus.OK);
    }
}
