/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.request;

import java.util.Date;
import javax.validation.Valid;
import md.factorydream.constant.AccessNameConst;
import md.factorydream.entites.NoteGroups;
import md.factorydream.entites.RoleAccess;
import md.factorydream.entites.Users;
import md.factorydream.entites.rest.NoteGroupInsertRest;
import md.factorydream.entites.rest.NoteGroupUpdateRest;
import md.factorydream.spring.service.NoteGroupsService;
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
public class RequestNotesGroupController {

    @Autowired(required = true)
    @Qualifier(value = "usersService")
    private UsersService usersService;

    @Autowired(required = true)
    @Qualifier(value = "noteGroupsService")
    private NoteGroupsService noteGroupsService;

    //------------------- Save noteGroup --------------------------------------------------------
    @RequestMapping(value = "/save/noteGroup", method = RequestMethod.POST)
    public ResponseEntity<NoteGroupInsertRest> saveNotesGroup(@Valid @RequestBody NoteGroupInsertRest noteGroupInsertRest, BindingResult bindingResult) {

        System.out.println(" Name Note Group  " + noteGroupInsertRest.getNameNoteGroup());
        System.out.println(" Description Note Group " + noteGroupInsertRest.getDescriptionNoteGroup());

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        Users users = usersService.findUserByLogin(name);

        if (users == null) {
            throw new UsernameNotFoundException("Asa utilizator nu exista in baza de date");
        }

        if (Autorization.isAutorization(name, "/rest/orders", "save")) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        NoteGroups noteGroups = new NoteGroups();
        noteGroups.setName(noteGroupInsertRest.getNameNoteGroup());
        noteGroups.setNoteGroupDescription(noteGroupInsertRest.getDescriptionNoteGroup());
        noteGroups.setUsers(users);
        noteGroups.setLastUpdateDate(new Date());

        noteGroupsService.save(noteGroups);

        return new ResponseEntity<>(noteGroupInsertRest, HttpStatus.OK);
    }

    //------------------------------ Update Note Group ------------------------------------------------------
    @RequestMapping(value = "/update/noteGroup", method = RequestMethod.POST)
    public ResponseEntity<NoteGroupUpdateRest> updateNotesGroup(@Valid @RequestBody NoteGroupUpdateRest noteGroupUpdateRest, BindingResult bindingResult) {

        System.out.println(" Id Note Group " + noteGroupUpdateRest.getNoteId());
        System.out.println(" Name Note Group  " + noteGroupUpdateRest.getNameNoteGroup());
        System.out.println(" Description Note Group " + noteGroupUpdateRest.getDescriptionNoteGroup());

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        Users users = usersService.findUserByLogin(name);

        if (users == null) {
            throw new UsernameNotFoundException("Asa utilizator nu exista in baza de date");
        }

        if (Autorization.isAutorization(name, "/rest/orders", "update")) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        NoteGroups noteGroups = noteGroupsService.findNoteGroupsById(noteGroupUpdateRest.getNoteId());

        if (noteGroups == null) {
            noteGroups = new NoteGroups();
        }

        noteGroups.setName(noteGroupUpdateRest.getNameNoteGroup());
        noteGroups.setNoteGroupDescription(noteGroupUpdateRest.getDescriptionNoteGroup());
        noteGroups.setUsers(users);
        noteGroups.setLastUpdateDate(new Date());

        noteGroupsService.save(noteGroups);

        return new ResponseEntity<>(noteGroupUpdateRest, HttpStatus.OK);
    }

}
