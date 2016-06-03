/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.List;
import md.factorydream.entites.Notes;
import md.factorydream.entites.Users;
import md.factorydream.entites.rest.NoteUpdateRest;
import md.factorydream.spring.dao.NotesDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class NotesServiceImpl implements NotesService {
    
    private NotesDAO notesDAO;
    
    public void setNotesDAO(NotesDAO notesDAO) {
        this.notesDAO = notesDAO;
    }
    
    @Override
    @Transactional
    public void save(Notes notes) {
        notesDAO.save(notes);
    }
    
    @Override
    @Transactional
    public List findAll() {
        return notesDAO.findAll();
    }
    
    @Override
    @Transactional
    public boolean update(NoteUpdateRest noteUpdateRest, Users users) {
        return notesDAO.update(noteUpdateRest, users);
    }
    
    @Override
    @Transactional
    public void delete(Long noteId) {
        notesDAO.delete(noteId);
    }
    
}
