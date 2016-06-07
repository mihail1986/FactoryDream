/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.request;

import java.util.Date;
import javax.validation.Valid;
import md.factorydream.entites.ParamNames;
import md.factorydream.entites.Users;
import md.factorydream.entites.rest.ParamNamesInsertRest;
import md.factorydream.entites.rest.ParamNamesUpdateRest;
import md.factorydream.spring.service.ParamNamesService;
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
public class RequestParamNamesController {

    //ParamNames Service which will do all data retrieval/manipulation work
    @Autowired(required = true)
    @Qualifier(value = "paramNamesService")
    private ParamNamesService paramNamesService;

    @Autowired(required = true)
    @Qualifier(value = "usersService")
    private UsersService usersService;

    //------------------- Save a Param Names --------------------------------------------------------
    @RequestMapping(value = "/save/paramNames", method = RequestMethod.POST)
    public ResponseEntity<ParamNamesInsertRest> saveParamNames(@Valid @RequestBody ParamNamesInsertRest paramNamesInsertRest, BindingResult bindingResult) {

        System.out.println(" Name parameter " + paramNamesInsertRest.getName());
        System.out.println(" Description parameter " + paramNamesInsertRest.getParamNameDescription());

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        Users users = usersService.findUserByLogin(name);

        if (users == null) {
            throw new UsernameNotFoundException("Asa utilizator nu exista in baza de date");
        }

        if (Autorization.isAutorization(name, "/rest/paramNames", "save")) {

            ParamNames paramNames = new ParamNames();

            paramNames.setName(paramNamesInsertRest.getName());
            paramNames.setParamNameDescription(paramNamesInsertRest.getParamNameDescription());
            paramNames.setUsers(users);
            paramNames.setLastUpdateDate(new Date());

            paramNamesService.save(paramNames);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(paramNamesInsertRest, HttpStatus.OK);

    }

    //------------------- Update a Param Names --------------------------------------------------------
    @RequestMapping(value = "/update/paramNames", method = RequestMethod.POST)
    public ResponseEntity<ParamNamesUpdateRest> updateNotes(@Valid @RequestBody ParamNamesUpdateRest paramNamesUpdateRest, BindingResult bindingResult) {

        System.out.println(" paramNames Id " + paramNamesUpdateRest.getId());
        System.out.println(" paramNames Name " + paramNamesUpdateRest.getName());
        System.out.println(" paramNames Descript " + paramNamesUpdateRest.getParamNameDescription());

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        Users users = usersService.findUserByLogin(name);

        if (users == null) {
            throw new UsernameNotFoundException("Asa utilizator nu exista in baza de date");
        }

        if (Autorization.isAutorization(name, "/rest/paramNames", "update")) {
            if (!paramNamesService.update(paramNamesUpdateRest, users)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(paramNamesUpdateRest, HttpStatus.OK);

    }
    
    
    

}
