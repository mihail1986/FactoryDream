/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.List;
import md.factorydream.entites.Notes;
import md.factorydream.entites.Users;
import md.factorydream.entites.rest.NoteUpdateRest;

/**
 *
 * @author Zaițev.Victor
 */
public interface NotesDAO {

    public void save(Notes notes);

    public List findAll();

    public boolean update(NoteUpdateRest noteUpdateRest, Users users);

    public void delete(Long noteId);
}
