/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import md.factorydream.constant.AccessNameConst;
import md.factorydream.constant.StatusCodeConst;
import md.factorydream.entites.GroupNotes;
import md.factorydream.entites.NoteGroups;
import md.factorydream.entites.Notes;
import md.factorydream.entites.OrderNote;
import md.factorydream.entites.Orders;
import md.factorydream.entites.RoleAccess;
import md.factorydream.entites.StatusCod;
import md.factorydream.entites.Users;
import md.factorydream.entites.rest.NoteInsertRest;
import md.factorydream.entites.rest.NoteUpdateRest;
import md.factorydream.entites.rest.OrderNoteRest;
import md.factorydream.spring.service.NoteGroupsService;
import md.factorydream.spring.service.NotesService;
import md.factorydream.spring.service.OrdersNoteService;
import md.factorydream.spring.service.OrdersService;
import md.factorydream.spring.service.RoleAccessSevice;
import md.factorydream.spring.service.StatusCodService;
import md.factorydream.spring.service.UsersService;
import md.factorydream.util.Autorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Zaițev.Victor
 */
@RestController
public class RequestNotesController {

    @Autowired
    @Qualifier(value = "notesService")
    private NotesService notesService;

    @Autowired(required = true)
    @Qualifier(value = "usersService")
    private UsersService usersService;

    //StatusCode Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "statusCodService")
    private StatusCodService statusCodService;

    @Autowired
    @Qualifier(value = "noteGroupsService")
    private NoteGroupsService noteGroupsService;

    //Orders Service which will do all data retrieval/manipulation work
    @Autowired(required = true)
    @Qualifier(value = "ordersService")
    private OrdersService ordersService;

    @Autowired(required = true)
    @Qualifier(value = "ordersNoteService")
    private OrdersNoteService ordersNoteService;

//------------------- Update a Notes --------------------------------------------------------
    @RequestMapping(value = "/update/notes", method = RequestMethod.POST)
    public ResponseEntity<Object> updateNotes(@Valid @RequestBody Object noteUpdateRest, BindingResult bindingResult) {

//        System.out.println(" Note Id " + noteUpdateRest.getNoteId());
//        System.out.println(" Note Content " + noteUpdateRest.getNoteConntent());
        System.err.println("I'm inside!!!!");

        NoteUpdateRest nur = (NoteUpdateRest) noteUpdateRest;

        System.err.println(noteUpdateRest.toString());
//        if (bindingResult.hasFieldErrors()) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName();
//
//        Users users = usersService.findUserByLogin(name);
//
//        if (users == null) {
//            throw new UsernameNotFoundException("Asa utilizator nu exista in baza de date");
//        }

//        if (Autorization.isAutorization(name, "/rest/orders", "update")) {
//            if (!notesService.update(noteUpdateRest, users)) {
//                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            }
//        } else {
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
        return new ResponseEntity<>(noteUpdateRest, HttpStatus.OK);

    }

    //----------------------------------- Create Notes -------------------------------------------------------------
    @RequestMapping(value = "/save/notes", method = RequestMethod.POST)
    public ResponseEntity<NoteInsertRest> saveNotes(@Valid @RequestBody NoteInsertRest noteInsertRest, BindingResult bindingResult) {

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

            StatusCod statusCod = statusCodService.findStatusCodByCodName(StatusCodeConst.COD_NAME_ENABLE);

            Orders orders = ordersService.findOrdersById(noteInsertRest.getOrderId());
            NoteGroups notesGroup = noteGroupsService.findNoteGroupsById(noteInsertRest.getNoteGroupId());

            Notes notes = new Notes();
            notes.setNote(noteInsertRest.getNoteConntent());
            notes.setUsers(users);
            notes.setLastUpdateDate(new Date());
            notes.setStatusCod(statusCod);

            GroupNotes groupNotes = new GroupNotes();
            groupNotes.setNotes(notes);
            groupNotes.setNoteGroups(notesGroup);
            groupNotes.setLastUpdateDate(new Date());
            groupNotes.setUsers(users);

            OrderNote orderNote = new OrderNote();
            orderNote.setGroupNotes(groupNotes);
            orderNote.setLastUpdateDate(new Date());
            orderNote.setOrders(orders);
            orderNote.setUsers(users);

            if (!ordersNoteService.save(notes, groupNotes, orderNote)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(noteInsertRest, HttpStatus.OK);
    }

    //----------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/delete/notes", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteNotes(@RequestParam long note) {

        if (note <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        Users users = usersService.findUserByLogin(name);

        if (users == null) {
            throw new UsernameNotFoundException("Asa utilizator nu exista in baza de date");
        }
        if (Autorization.isAutorization(name, "/rest/orders", "delete")) {
            notesService.delete((long) note);
        } else {
            return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
