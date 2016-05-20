/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.rest;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.rest.ModelValueRest;
import md.factorydream.spring.service.ModelsService;
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
public class RestModelsController {

    //Models Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "modelsService")
    private ModelsService modelsService;

    //---------------------- Retrieve All Value of Models -----------------------------------------------
    @RequestMapping(value = "/rest/valueModels", method = RequestMethod.GET)
    public ResponseEntity<List<ModelValueRest>> getAllValueModels() {

        List<ModelValueRest> modeValueRestList = (ArrayList<ModelValueRest>) modelsService.findAllEnableModelsRest();

        return new ResponseEntity<>(modeValueRestList, HttpStatus.OK);
    }
}
