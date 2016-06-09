/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.request;

import java.util.Date;
import javax.validation.Valid;
import md.factorydream.constant.StatusCodeConst;
import md.factorydream.entites.Models;

import md.factorydream.entites.StatusCod;
import md.factorydream.entites.Users;
import md.factorydream.entites.rest.ModelsInsertRest;
import md.factorydream.entites.rest.ModelsUpdateRest;
import md.factorydream.spring.service.ModelsService;
import md.factorydream.spring.service.StatusCodService;
import md.factorydream.spring.service.UsersService;
import md.factorydream.util.Autorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
public class RequestModelsController {

    //Models Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "modelsService")
    private ModelsService modelsService;

    //UsersService Service which will do all data retrieval/manipulation work
    @Autowired(required = true)
    @Qualifier(value = "usersService")
    private UsersService usersService;

    //StatusCode Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "statusCodService")
    private StatusCodService statusCodService;

    //------------------- Save Models --------------------------------------------------------
    @RequestMapping(value = "/save/models", method = RequestMethod.POST)
    public ResponseEntity<ModelsInsertRest> saveModels(@Valid @RequestBody ModelsInsertRest modelsInsertRest, BindingResult bindingResult) {

        System.out.println(" Models Value " + modelsInsertRest.getValue());
        System.out.println(" ModelsDescription " + modelsInsertRest.getModelDescription());

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        Users users = usersService.findUserByLogin(name);

        if (users == null) {
            throw new UsernameNotFoundException("Asa utilizator nu exista in baza de date");
        }

        if (Autorization.isAutorization(name, "/rest/models", "save")) {

            StatusCod statusCod = statusCodService.findStatusCodByCodName(StatusCodeConst.COD_NAME_ENABLE);

            Models models = new Models();
            models.setValue(modelsInsertRest.getValue());
            models.setModelDescription(modelsInsertRest.getModelDescription());
            models.setUsers(users);
            models.setLastUpdateDate(new Date());
            models.setStatusCod(statusCod);

            modelsService.save(models);

        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(modelsInsertRest, HttpStatus.OK);

    }

    //------------------- Update Models --------------------------------------------------------
    @RequestMapping(value = "/update/Models", method = RequestMethod.POST)
    public ResponseEntity<ModelsUpdateRest> updateModels(@Valid @RequestBody ModelsUpdateRest modelsUpdateRest, BindingResult bindingResult) {

        System.out.println(" Models Id " + modelsUpdateRest.getModelsId());
        System.out.println(" Models Value " + modelsUpdateRest.getValue());
        System.out.println(" Models Description " + modelsUpdateRest.getModelDescription());
        System.out.println(" Models StatusCodeId " + modelsUpdateRest.getStatusCodeId());

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        Users users = usersService.findUserByLogin(name);

        if (users == null) {
            throw new UsernameNotFoundException("Asa utilizator nu exista in baza de date");
        }

        if (Autorization.isAutorization(name, "/rest/models", "update")) {

            StatusCod statusCod = statusCodService.findStatusCodById(modelsUpdateRest.getStatusCodeId());

            if (statusCod == null) {
                throw new NullPointerException(" statusCod is null ");
            }

            Models models = modelsService.findModelsById(modelsUpdateRest.getModelsId());

            if (models == null) {
                throw new NullPointerException(" models is null ");
            }

            models.setValue(modelsUpdateRest.getValue());
            models.setModelDescription(modelsUpdateRest.getModelDescription());
            models.setUsers(users);
            models.setLastUpdateDate(new Date());
            models.setStatusCod(statusCod);

            modelsService.save(models);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(modelsUpdateRest, HttpStatus.OK);

    }

}
