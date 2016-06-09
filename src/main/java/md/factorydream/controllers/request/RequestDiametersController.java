/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.request;

import java.util.Date;
import javax.validation.Valid;

import md.factorydream.constant.StatusCodeConst;
import md.factorydream.entites.Diameters;
import md.factorydream.entites.StatusCod;
import md.factorydream.entites.Users;
import md.factorydream.entites.rest.DiametersInsertRest;
import md.factorydream.entites.rest.DiametersUpdateRest;

import md.factorydream.spring.service.DiametersService;
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
public class RequestDiametersController {

    //UsersService Service which will do all data retrieval/manipulation work
    @Autowired(required = true)
    @Qualifier(value = "usersService")
    private UsersService usersService;

    //StatusCode Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "statusCodService")
    private StatusCodService statusCodService;

    //Diameters Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "diametersService")
    private DiametersService diametersService;

    //------------------- Save Diameters --------------------------------------------------------
    @RequestMapping(value = "/save/diameters", method = RequestMethod.POST)
    public ResponseEntity<DiametersInsertRest> saveDiameters(@Valid @RequestBody DiametersInsertRest diametersInsertRest, BindingResult bindingResult) {

        System.out.println(" Diameters Value " + diametersInsertRest.getValue());
        System.out.println(" Diameters Description " + diametersInsertRest.getDiameterDescription());

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        Users users = usersService.findUserByLogin(name);

        if (users == null) {
            throw new UsernameNotFoundException("Asa utilizator nu exista in baza de date");
        }

        if (Autorization.isAutorization(name, "/rest/diameters", "save")) {

            StatusCod statusCod = statusCodService.findStatusCodByCodName(StatusCodeConst.COD_NAME_ENABLE);

            Diameters diameters = new Diameters();
            diameters.setValue(diametersInsertRest.getValue());
            diameters.setDiameterDescription(diametersInsertRest.getDiameterDescription());
            diameters.setUsers(users);
            diameters.setLastUpdateDate(new Date());
            diameters.setStatusCod(statusCod);

            diametersService.save(diameters);

        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(diametersInsertRest, HttpStatus.OK);

    }

    //------------------- Update diameters --------------------------------------------------------
    @RequestMapping(value = "/update/diameters", method = RequestMethod.POST)
    public ResponseEntity<DiametersUpdateRest> updateDiameters(@Valid @RequestBody DiametersUpdateRest diametersUpdateRest, BindingResult bindingResult) {

        System.out.println(" Diameters Id " + diametersUpdateRest.getDiametersId());
        System.out.println(" Diameters Value " + diametersUpdateRest.getValue());
        System.out.println(" Diameters Description " + diametersUpdateRest.getDiametersDescription());
        System.out.println(" Diameters StatusCodeId " + diametersUpdateRest.getStatusCodeId());

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        Users users = usersService.findUserByLogin(name);

        if (users == null) {
            throw new UsernameNotFoundException("Asa utilizator nu exista in baza de date");
        }

        if (Autorization.isAutorization(name, "/rest/diameters", "update")) {

            StatusCod statusCod = statusCodService.findStatusCodById(diametersUpdateRest.getStatusCodeId());

            if (statusCod == null) {
                throw new NullPointerException(" statusCod is null ");
            }

            Diameters diameters = diametersService.findDiametersById(diametersUpdateRest.getDiametersId());

            if (diameters == null) {
                throw new NullPointerException(" diameters is null ");
            }

            diameters.setValue(diametersUpdateRest.getValue());
            diameters.setDiameterDescription(diametersUpdateRest.getDiametersDescription());
            diameters.setUsers(users);
            diameters.setLastUpdateDate(new Date());
            diameters.setStatusCod(statusCod);

            diametersService.save(diameters);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(diametersUpdateRest, HttpStatus.OK);

    }

}
