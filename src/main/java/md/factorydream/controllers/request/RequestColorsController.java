/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.request;

import java.util.Date;
import javax.validation.Valid;
import md.factorydream.constant.StatusCodeConst;
import md.factorydream.entites.Colors;
import md.factorydream.entites.StatusCod;
import md.factorydream.entites.Users;
import md.factorydream.entites.rest.ColorsInsertRest;
import md.factorydream.entites.rest.ColorsUpdateRest;
import md.factorydream.spring.service.ColorsService;
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
public class RequestColorsController {

    //Colors Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "colorsService")
    private ColorsService colorsService;

    //Users Service which will do all data retrieval/manipulation work
    @Autowired(required = true)
    @Qualifier(value = "usersService")
    private UsersService usersService;

    //StatusCode Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "statusCodService")
    private StatusCodService statusCodService;

    //------------------------ Save a Colors  ------------------------------------
    @RequestMapping(value = "/save/colors", method = RequestMethod.POST)
    public ResponseEntity<ColorsInsertRest> saveColors(@Valid @RequestBody ColorsInsertRest colorsInsertRest, BindingResult bindingResult) {

        System.out.println(" Colors Value " + colorsInsertRest.getValue());
        System.out.println(" Colors Description " + colorsInsertRest.getColorDescription());

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        Users users = usersService.findUserByLogin(name);

        if (users == null) {
            throw new UsernameNotFoundException("Asa utilizator nu exista in baza de date");
        }

        if (Autorization.isAutorization(name, "/rest/colors", "save")) {

            StatusCod statusCod = statusCodService.findStatusCodByCodName(StatusCodeConst.COD_NAME_ENABLE);

            Colors colors = new Colors();
            colors.setValue(colorsInsertRest.getValue());
            colors.setColorDescription(colorsInsertRest.getColorDescription());
            colors.setUsers(users);
            colors.setLastUpdateDate(new Date());
            colors.setStatusCod(statusCod);

            colorsService.save(colors);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(colorsInsertRest, HttpStatus.OK);

    }

    //------------------- Update Colors --------------------------------------------------------
    @RequestMapping(value = "/update/colors", method = RequestMethod.POST)
    public ResponseEntity<ColorsUpdateRest> updateColors(@Valid @RequestBody ColorsUpdateRest colorsUpdateRest, BindingResult bindingResult) {

        System.out.println(" Colors Id " + colorsUpdateRest.getColorsId());
        System.out.println(" Colors Value " + colorsUpdateRest.getValue());
        System.out.println(" Colors Description " + colorsUpdateRest.getColorsDescription());
        System.out.println(" Colors StatusCodeId " + colorsUpdateRest.getStatusCodeId());

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        Users users = usersService.findUserByLogin(name);

        if (users == null) {
            throw new UsernameNotFoundException("Asa utilizator nu exista in baza de date");
        }

        if (Autorization.isAutorization(name, "/rest/colors", "update")) {

            StatusCod statusCod = statusCodService.findStatusCodById(colorsUpdateRest.getStatusCodeId());

            if (statusCod == null) {
                throw new NullPointerException(" statusCod is null ");
            }

            Colors colors = colorsService.findColorsById(colorsUpdateRest.getColorsId());

            if (colors == null) {
                throw new NullPointerException(" Colors is null ");
            }

            colors.setValue(colorsUpdateRest.getValue());
            colors.setColorDescription(colorsUpdateRest.getColorsDescription());
            colors.setUsers(users);
            colors.setLastUpdateDate(new Date());
            colors.setStatusCod(statusCod);

            colorsService.save(colors);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(colorsUpdateRest, HttpStatus.OK);

    }

}
