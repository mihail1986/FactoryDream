/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.request;

import java.util.Date;
import javax.validation.Valid;
import md.factorydream.constant.StatusCodeConst;
import md.factorydream.entites.StatusCod;
import md.factorydream.entites.Types;
import md.factorydream.entites.Users;
import md.factorydream.entites.rest.TypesInsertRest;
import md.factorydream.entites.rest.TypesUpdateRest;
import md.factorydream.spring.service.StatusCodService;
import md.factorydream.spring.service.TypesService;
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
public class RequestTypesController {

    //Types Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "typesService")
    private TypesService typesService;

    //Users Service which will do all data retrieval/manipulation work
    @Autowired(required = true)
    @Qualifier(value = "usersService")
    private UsersService usersService;

    //StatusCode Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "statusCodService")
    private StatusCodService statusCodService;

    //------------------------ Save a Types  ------------------------------------
    @RequestMapping(value = "/save/types", method = RequestMethod.POST)
    public ResponseEntity<TypesInsertRest> saveTypes(@Valid @RequestBody TypesInsertRest typesInsertRest, BindingResult bindingResult) {

        System.out.println(" Types Value " + typesInsertRest.getValue());
        System.out.println(" Types Description " + typesInsertRest.getTypeDescription());

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        Users users = usersService.findUserByLogin(name);

        if (users == null) {
            throw new UsernameNotFoundException("Asa utilizator nu exista in baza de date");
        }

        if (Autorization.isAutorization(name, "/rest/types", "save")) {

            StatusCod statusCod = statusCodService.findStatusCodByCodName(StatusCodeConst.COD_NAME_ENABLE);

            Types types = new Types();
            types.setValue(typesInsertRest.getValue());
            types.setTypeDescription(typesInsertRest.getTypeDescription());
            types.setLastUpdateDate(new Date());
            types.setUsers(users);
            types.setStatusCod(statusCod);

            typesService.save(types);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(typesInsertRest, HttpStatus.OK);

    }

    //------------------- Update types --------------------------------------------------------
    @RequestMapping(value = "/update/types", method = RequestMethod.POST)
    public ResponseEntity<TypesUpdateRest> updateTypes(@Valid @RequestBody TypesUpdateRest typesUpdateRest, BindingResult bindingResult) {

        System.out.println(" Types Id " + typesUpdateRest.getTypesId());
        System.out.println(" Types Value " + typesUpdateRest.getValue());
        System.out.println(" Types Description " + typesUpdateRest.getTypeDescription());
        System.out.println(" Types StatusCodeId " + typesUpdateRest.getStatusCodeId());

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        Users users = usersService.findUserByLogin(name);

        if (users == null) {
            throw new UsernameNotFoundException("Asa utilizator nu exista in baza de date");
        }

        if (Autorization.isAutorization(name, "/rest/types", "update")) {

            StatusCod statusCod = statusCodService.findStatusCodById(typesUpdateRest.getStatusCodeId());

            if (statusCod == null) {
                throw new NullPointerException(" statusCod is null ");
            }

            Types types = typesService.findTypesById(typesUpdateRest.getTypesId());

            if (types == null) {
                throw new NullPointerException(" types is null ");
            }

            types.setValue(typesUpdateRest.getValue());
            types.setTypeDescription(typesUpdateRest.getTypeDescription());
            types.setLastUpdateDate(new Date());
            types.setUsers(users);
            types.setStatusCod(statusCod);

            typesService.save(types);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(typesUpdateRest, HttpStatus.OK);

    }

}
