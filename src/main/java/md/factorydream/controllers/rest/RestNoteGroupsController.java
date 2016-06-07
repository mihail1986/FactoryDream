/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.rest;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.rest.NoteGroupsValueRest;

import md.factorydream.spring.service.NoteGroupsService;
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
public class RestNoteGroupsController {

    //NoteGroups Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "noteGroupsService")
    private NoteGroupsService noteGroupsService;

    //---------------------- Retrieve All Value of NoteGroups --------------------------------------------------
    @RequestMapping(value = "/rest/valueNoteGroups", method = RequestMethod.GET)
    public ResponseEntity<List<NoteGroupsValueRest>> getAllValueNoteGroups() {

        List<NoteGroupsValueRest> noteGroupsValueList = (ArrayList<NoteGroupsValueRest>) noteGroupsService.findAllNoteGroupsRest();

        return new ResponseEntity<>(noteGroupsValueList, HttpStatus.OK);
    }

}
