/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.NoteGroups;
import md.factorydream.entites.rest.NoteGroupsValueRest;
import md.factorydream.spring.dao.NoteGroupsDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class NoteGroupsServiceImpl implements NoteGroupsService {

    private NoteGroupsDAO noteGroupsDAO;

    public void setNoteGroupsDAO(NoteGroupsDAO noteGroupsDAO) {
        this.noteGroupsDAO = noteGroupsDAO;
    }

    @Override
    @Transactional
    public void save(NoteGroups noteGroups) {
        noteGroupsDAO.save(noteGroups);
    }

    @Override
    @Transactional
    public List findAll() {
        return noteGroupsDAO.findAll();
    }

    @Override
    @Transactional
    public NoteGroups findNoteGroupsById(long id) {
        return noteGroupsDAO.findNoteGroupsById(id);
    }

    @Override
    public List findAllNoteGroupsRest() {

        List noteGroupsValueRestList = new ArrayList();

        List noteGroupsList = findAll();

        for (Object noteGroups : noteGroupsList) {
            NoteGroups noteGroup = (NoteGroups) noteGroups;

            NoteGroupsValueRest noteGroupsValueRest = new NoteGroupsValueRest(noteGroup.getId(), noteGroup.getName());
            noteGroupsValueRestList.add(noteGroupsValueRest);
        }

        return noteGroupsValueRestList;

    }
    
    

}
